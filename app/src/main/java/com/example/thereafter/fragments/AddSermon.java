package com.example.thereafter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.thereafter.R;
import com.example.thereafter.databases.room.database.LocalDB;
import com.example.thereafter.databases.room.entities.SermonEntity;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AddSermon extends Fragment {
    private Button addButton;
    private EditText post;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_sermon, container, false);
        addButton = view.findViewById(R.id.submitButton);
        post = view.findViewById(R.id.sermonContent);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sermonContent = post.getText().toString();
                submitPost(sermonContent);
            }
        });

        return view;
    }

    private void submitPost(String sermonContent) {
        SermonEntity i = new SermonEntity("خطبة 2", "فئة ب", sermonContent, "مالك 2", "فئة ب", "صورة2.jpg", 100.0);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            LocalDB.getDatabase(this.getContext()).sermonDao().insert(i);
        });
    }
}