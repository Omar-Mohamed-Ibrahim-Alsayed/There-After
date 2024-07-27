package com.example.thereafter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thereafter.R;
import com.example.thereafter.utilities.TopUsersAdapter;
import com.example.thereafter.utilities.UserItem;

import java.util.ArrayList;
import java.util.List;

public class TopUsers extends Fragment {

    private RecyclerView recyclerView;


    public TopUsers() {
        // Required empty public constructor
    }

    public static List<UserItem> getSampleUsers() {
        List<UserItem> users = new ArrayList<>();
        users.add(new UserItem("User 1", 1, "Badge1", "Image1.jpg", 5, 10, 15));
        users.add(new UserItem("User 2", 2, "Badge2", "Image2.jpg", 4.5, 8, 12));
        users.add(new UserItem("User 3", 3, "Badge3", "Image3.jpg", 4, 15, 20));
        // Add more sample users as needed
        return users;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_users, container, false);

        recyclerView = view.findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<UserItem> topUsers = getSampleUsers();
        TopUsersAdapter adapter = new TopUsersAdapter(topUsers, getParentFragmentManager());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
