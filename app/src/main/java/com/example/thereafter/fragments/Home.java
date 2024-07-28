package com.example.thereafter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thereafter.R;


public class Home extends Fragment {
    private View sermons;
    private View activities;
    private View toprusers;
    private View posts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        posts = view.findViewById(R.id.posts);
        toprusers = view.findViewById(R.id.topusers);
        sermons = view.findViewById(R.id.sermons);
        activities = view.findViewById(R.id.activities);

        // Set text for TextViews
//        ((TextView) posts.findViewById(R.id.fragText)).setText(getResources().getString(R.string.posts));
//        ((TextView) toprusers.findViewById(R.id.fragText)).setText(getResources().getString(R.string.topusers));
//        ((TextView) sermons.findViewById(R.id.fragText)).setText(getResources().getString(R.string.sermons));
//        ((TextView) activities.findViewById(R.id.fragText)).setText(getResources().getString(R.string.activities));


        // Set click listeners
        posts.setOnClickListener(v -> replaceFragment(new Posts()));
        toprusers.setOnClickListener(v -> replaceFragment(new TopUsers()));
        sermons.setOnClickListener(v -> replaceFragment(new Sermons()));
        activities.setOnClickListener(v -> replaceFragment(new Activities()));

    }

    private void replaceFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.flFragment, fragment)
                .addToBackStack(null)  // Optional: Add to back stack to handle navigation
                .commit();
    }

}