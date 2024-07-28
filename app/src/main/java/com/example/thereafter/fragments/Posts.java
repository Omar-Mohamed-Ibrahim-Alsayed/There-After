package com.example.thereafter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thereafter.R;
import com.example.thereafter.utilities.PostItem;
import com.example.thereafter.utilities.PostsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Posts extends Fragment {

    private FragmentManager fragmentManager;
    private RecyclerView recyclerView;
    private ImageButton addPost;


    public Posts() {
        // Required empty public constructor
    }

    public static List<PostItem> getSamplePosts() {
        List<PostItem> posts = new ArrayList<>();
        posts.add(new PostItem(1, "Tag1", "Content1", "Owner1", "Badge1", "Image1.jpg", 100, 10, 50));
        posts.add(new PostItem(2, "Tag2", "Content2", "Owner2", "Badge2", "Image2.jpg", 150, 20, 60));
        posts.add(new PostItem(3, "Tag3", "Content3", "Owner3", "Badge3", "Image3.jpg", 200, 30, 70));
        // Add more sample posts as needed
        return posts;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        fragmentManager = getParentFragmentManager();

        addPost = view.findViewById(R.id.add_post);
        addPost.setOnClickListener(v -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.flFragment, new AddPost())
                    .addToBackStack(null)
                    .commit();
        });

        recyclerView = view.findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<PostItem> posts = getSamplePosts();
        PostsAdapter adapter = new PostsAdapter(posts, getParentFragmentManager());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
