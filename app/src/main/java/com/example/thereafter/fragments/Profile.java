package com.example.thereafter.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.thereafter.R;

public class Profile extends Fragment {

    private ImageView profileImage;
    private EditText editName;
    private EditText editBadges;
    private EditText editDescription;
    private ImageButton editNameBtn;
    private ImageButton editBadgesBtn;
    private ImageButton editDescriptionBtn;

    // Example initial data
    private String name = "Omar";
    private String badges = "Gold Badge";
    private String description = "Anything";

    // Flags to track editing state
    private boolean isEditingName = false;
    private boolean isEditingBadges = false;
    private boolean isEditingDescription = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileImage = view.findViewById(R.id.profileImage);
        editName = view.findViewById(R.id.editName);
        editBadges = view.findViewById(R.id.editBadges);
        editDescription = view.findViewById(R.id.editDescription);
        editNameBtn = view.findViewById(R.id.editNameBtn);
        editBadgesBtn = view.findViewById(R.id.editBadgesBtn);
        editDescriptionBtn = view.findViewById(R.id.editDescriptionBtn);

        // Set initial values
        profileImage.setImageResource(R.drawable.baseline_photo_size_select_actual_24);
        editName.setText(name);
        editBadges.setText(badges);
        editDescription.setText(description);

        // Setup edit button listeners
        setupEditButton(editNameBtn, editName, () -> updateProfileName(editName.getText().toString()));
        setupEditButton(editBadgesBtn, editBadges, () -> updateProfileBadges(editBadges.getText().toString()));
        setupEditButton(editDescriptionBtn, editDescription, () -> updateProfileDescription(editDescription.getText().toString()));
    }

    private void setupEditButton(ImageButton button, EditText editText, Runnable onSave) {
        button.setOnClickListener(v -> {
            if (!isEditingName && !isEditingBadges && !isEditingDescription) {
                // Enable editing
                editText.setEnabled(true);
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                button.setImageResource(R.drawable.ic_save); // Change icon to save
                editText.setSelection(editText.getText().length()); // Move cursor to end

                // Set editing flag
                if (editText == editName) {
                    isEditingName = true;
                } else if (editText == editBadges) {
                    isEditingBadges = true;
                } else if (editText == editDescription) {
                    isEditingDescription = true;
                }
            } else {
                // Disable editing
                editText.setEnabled(false);
                editText.setFocusable(false);
                button.setImageResource(R.drawable.ic_edit_pen); // Change icon back to edit pen

                // Clear focus and hide keyboard
                editText.clearFocus();
                editText.setOnEditorActionListener(null);

                // Reset editing flag
                if (editText == editName) {
                    isEditingName = false;
                } else if (editText == editBadges) {
                    isEditingBadges = false;
                } else if (editText == editDescription) {
                    isEditingDescription = false;
                }

                // Save changes
                onSave.run();
            }
        });

        // Handle enter key press to save changes
        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (event != null && event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                // Save changes
                onSave.run();

                // Disable editing
                editText.setEnabled(false);
                editText.setFocusable(false);
                button.setImageResource(R.drawable.ic_edit_pen); // Change icon back to edit pen

                // Clear focus and hide keyboard
                editText.clearFocus();
                return true;
            }
            return false;
        });
    }

    // Example methods to update profile information
    private void updateProfileName(String newName) {
        // Update UI or save to database
        name = newName;
        editName.setText(name);
    }

    private void updateProfileBadges(String newBadges) {
        // Update UI or save to database
        badges = newBadges;
        editBadges.setText(badges);
    }

    private void updateProfileDescription(String newDescription) {
        // Update UI or save to database
        description = newDescription;
        editDescription.setText(description);
    }
}
