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
import com.example.thereafter.utilities.ActivityAdapter;
import com.example.thereafter.utilities.ActivityItem;

import java.util.ArrayList;
import java.util.List;

public class Activities extends Fragment {

    private RecyclerView recyclerView;
    private String mParam1;
    private String mParam2;

    public Activities() {
        // Required empty public constructor
    }

    public static List<ActivityItem> getSampleActivities() {
        List<ActivityItem> activities = new ArrayList<>();
        activities.add(new ActivityItem("Activity 1", 1, "Tag1", "Description1", "Owner1", "Image1.jpg", 100, "2024-07-27", "Certification1"));
        activities.add(new ActivityItem("Activity 2", 2, "Tag2", "Description2", "Owner2", "Image2.jpg", 200, "2024-08-15", "Certification2"));
        activities.add(new ActivityItem("Activity 3", 3, "Tag3", "Description3", "Owner3", "Image3.jpg", 300, "2024-09-01", "Certification3"));
        // Add more sample activities as needed
        return activities;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activities, container, false);

        recyclerView = view.findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        List<ActivityItem> activities = getSampleActivities();
        ActivityAdapter adapter = new ActivityAdapter(activities, getParentFragmentManager());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
