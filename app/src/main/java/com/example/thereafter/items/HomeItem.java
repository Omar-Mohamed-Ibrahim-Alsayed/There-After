package com.example.thereafter.items;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thereafter.R;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HomeItem extends Fragment {

    private static final String ARG_NAME = "name";

    private String mName;

    public HomeItem() {
        // Required empty public constructor
    }

    public static HomeItem newInstance(String name) {
        HomeItem fragment = new HomeItem();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_item, container, false);

        TextView fragText = view.findViewById(R.id.fragText);
        fragText.setText(mName);

        // You can further customize UI elements based on mName or other arguments here

        return view;
    }
}
