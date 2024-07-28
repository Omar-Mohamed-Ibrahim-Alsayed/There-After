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
import com.example.thereafter.databases.room.entities.PostItemEntity;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AddPost extends Fragment {

    private Button addButton;
    private EditText post;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_post, container, false);

        addButton = view.findViewById(R.id.submitButton);
        post = view.findViewById(R.id.postContent);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postContent = post.getText().toString();
                submitPost(postContent);
            }
        });

        return view;
    }

    private void submitPost(String postContent) {
        PostItemEntity i = new PostItemEntity("Tag1", postContent, "Owner1", "Badge1", "Image1.jpg", 100, 10);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            LocalDB.getDatabase(this.getContext()).postItemDao().insert(i);
        });
    }
}