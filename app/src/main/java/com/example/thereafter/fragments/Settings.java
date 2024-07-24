package com.example.thereafter.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.thereafter.MainActivity;
import com.example.thereafter.R;

import java.util.Locale;
import java.util.Objects;

public class Settings extends Fragment {

    private static final String PREFERENCES_FILE = "com.example.thereafter.preferences";
    private static final String LANGUAGE_KEY = "language";

    public Settings() {
        // Required empty public constructor
    }

    public static Settings newInstance() {
        return new Settings();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        Button buttonChangeLanguage = view.findViewById(R.id.buttonChangeLanguage);
        buttonChangeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage();
            }
        });

        return view;
    }

    private void changeLanguage() {
        // Check current language
        String currentLang = getResources().getConfiguration().locale.getLanguage();
        String newLang = currentLang.equals("ar") ? "en" : "ar";

        // Save the new language preference
        SharedPreferences preferences = requireActivity().getSharedPreferences(PREFERENCES_FILE, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(LANGUAGE_KEY, newLang);
        editor.apply();

        // Update the locale
        Locale locale = new Locale(newLang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Restart the activity to apply changes
        if (getActivity() != null) {
            Intent refresh = new Intent(getActivity(), MainActivity.class);
            getActivity().finish();
            startActivity(refresh);
        }
    }

}
