package com.example.thereafter.items;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.thereafter.R;

public class SermonItem extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private boolean isExpanded = false;

    public SermonItem() {
        // Required empty public constructor
    }

    public static SermonItem newInstance(String param1, String param2) {
        SermonItem fragment = new SermonItem();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sermon_item, container, false);

//        // Accessing views
//        TextView sercontent = view.findViewById(R.id.sercontent);
//        TextView toggle = view.findViewById(R.id.toggle);
//
//        // Set the initial state
//        sercontent.setMaxLines(3);
//        toggle.setText(R.string.show_more);
//
//        // Toggle button click listener
//        toggle.setOnClickListener(v -> {
//            if (isExpanded) {
//                // Collapse the text
//                sercontent.setMaxLines(3);
//                toggle.setText(R.string.show_more);
//            } else {
//                // Expand the text
//                sercontent.setMaxLines(Integer.MAX_VALUE);
//                toggle.setText(R.string.show_less);
//            }
//            isExpanded = !isExpanded;
//        });

        return view;
    }
}
