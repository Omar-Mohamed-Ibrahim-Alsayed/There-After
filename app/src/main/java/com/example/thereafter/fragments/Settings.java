package com.example.thereafter.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.thereafter.MainActivity;
import com.example.thereafter.R;

import java.util.Locale;

public class Settings extends Fragment {

    private static final String TAG = "SettingsFragment";
    private static final String PREFERENCES_FILE = "com.example.thereafter.preferences";
    private static final String LANGUAGE_KEY = "language";
    private static final String DARK_MODE_KEY = "dark_mode";
    private static final String NOTIFICATIONS_KEY = "notifications";
    private static final String TOS_URL = "https://docs.google.com/document/d/19QOdQ2C8bALA2qyQfWpilXUBXj9mPqGcGjFb7tXsILQ/edit?usp=sharing";
    private static final String PAP_URL = "https://docs.google.com/document/d/19QOdQ2C8bALA2qyQfWpilXUBXj9mPqGcGjFb7tXsILQ/edit?usp=sharing";
    private static final String LEGAL_URL = "https://docs.google.com/document/d/19QOdQ2C8bALA2qyQfWpilXUBXj9mPqGcGjFb7tXsILQ/edit?usp=sharing";
    private static final String HELP_URL = "https://docs.google.com/document/d/19QOdQ2C8bALA2qyQfWpilXUBXj9mPqGcGjFb7tXsILQ/edit?usp=sharing";
    private static final String SUPP_MAIL = "example@gmail.com";

    private SharedPreferences preferences;

    public Settings() {
        // Required empty public constructor
    }

    public static Settings newInstance() {
        return new Settings();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = requireActivity().getSharedPreferences(PREFERENCES_FILE, 0);
        Log.d(TAG, "onCreate: Preferences loaded");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Initialize and set up the UI components
        Spinner languageSpinner = view.findViewById(R.id.spinner_language);
        Switch darkModeSwitch = view.findViewById(R.id.switch_dark_mode);
        Switch notificationsSwitch = view.findViewById(R.id.switch_notifications);
        Button accountSettingsButton = view.findViewById(R.id.button_account_settings);
        Button helpSupportButton = view.findViewById(R.id.button_help_support);
        Button feedbackButton = view.findViewById(R.id.button_feedback);
        Button termsOfServiceButton = view.findViewById(R.id.button_terms_of_service);
        Button privacyPolicyButton = view.findViewById(R.id.button_privacy_policy);

        Log.d(TAG, "onCreateView: UI components initialized");

        // Set up the language spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        Log.d(TAG, "onCreateView: Language spinner set up");

        // Load saved preferences and set initial values
        loadPreferences(languageSpinner, darkModeSwitch, notificationsSwitch);

        // Set up listeners
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Retrieve the selected language code from the language_codes array
                String[] languageCodes = getResources().getStringArray(R.array.language_codes);
                String selectedLanguageCode = languageCodes[position];
                Log.d(TAG, "Language selected: " + selectedLanguageCode);
                changeLanguage(selectedLanguageCode);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "onNothingSelected: No language selected");
            }
        });

        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.d(TAG, "Dark mode toggled: " + isChecked);
            savePreference(DARK_MODE_KEY, isChecked);
            applyDarkMode(isChecked);
        });

        notificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.d(TAG, "Notifications toggled: " + isChecked);
            savePreference(NOTIFICATIONS_KEY, isChecked);
            applyNotifications(isChecked);
        });

        accountSettingsButton.setOnClickListener(v -> {
            Log.d(TAG, "Account settings button clicked");

        });

        helpSupportButton.setOnClickListener(v -> {
            Log.d(TAG, "Help and Support button clicked");
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(HELP_URL)));
        });

        feedbackButton.setOnClickListener(v -> {
            Log.d(TAG, "Feedback button clicked");
            // Open email client or feedback form
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", SUPP_MAIL, null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
            startActivity(Intent.createChooser(emailIntent, "Send Feedback"));
        });

        termsOfServiceButton.setOnClickListener(v -> {
            Log.d(TAG, "Terms of Service button clicked");
            // Open Terms of Service page
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(TOS_URL)));
        });

        privacyPolicyButton.setOnClickListener(v -> {
            Log.d(TAG, "Privacy Policy button clicked");
            // Open Privacy Policy page
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(PAP_URL)));
        });

        return view;
    }

    private void changeLanguage(String languageCode) {
        // Check current language and avoid unnecessary changes
        String currentLang = getResources().getConfiguration().locale.getLanguage();
        Log.d(TAG, "Current language: " + currentLang);
        Log.d(TAG, "New language: " + languageCode);
        if (!currentLang.equals(languageCode)) {
            // Save the new language preference
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(LANGUAGE_KEY, languageCode);
            editor.apply();
            Log.d(TAG, "Language preference saved: " + languageCode);

            // Update the locale
            Locale locale = new Locale(languageCode);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());

            Log.d(TAG, "Locale updated: " + languageCode);

            // Restart the activity to apply changes
            if (getActivity() != null) {
                Intent refresh = new Intent(getActivity(), MainActivity.class);
                getActivity().finish(); // Ensure old activity is finished
                startActivity(refresh);
                Log.d(TAG, "Activity restarted to apply language changes");
            }
        }
    }

    private void loadPreferences(Spinner languageSpinner, Switch darkModeSwitch, Switch notificationsSwitch) {
        // Load saved preferences
        String savedLanguage = preferences.getString(LANGUAGE_KEY, "en");
        boolean darkMode = preferences.getBoolean(DARK_MODE_KEY, false);
        boolean notifications = preferences.getBoolean(NOTIFICATIONS_KEY, true);

        Log.d(TAG, "Preferences loaded: Language=" + savedLanguage + ", DarkMode=" + darkMode + ", Notifications=" + notifications);

        // Set UI components based on saved preferences
        String[] languageCodes = getResources().getStringArray(R.array.language_codes);
        int languagePosition = 0;
        for (int i = 0; i < languageCodes.length; i++) {
            if (languageCodes[i].equals(savedLanguage)) {
                languagePosition = i;
                break;
            }
        }
        languageSpinner.setSelection(languagePosition);
        darkModeSwitch.setChecked(darkMode);
        notificationsSwitch.setChecked(notifications);

        // Apply dark mode if it's enabled
        applyDarkMode(darkMode);

        // Apply notifications settings if necessary
        applyNotifications(notifications);
    }

    private void savePreference(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
        Log.d(TAG, "Preference saved: " + key + " = " + value);
    }

    private void applyDarkMode(boolean isDarkModeEnabled) {
        if (isDarkModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            Log.d(TAG, "Dark mode applied");
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            Log.d(TAG, "Light mode applied");
        }
    }

    private void applyNotifications(boolean areNotificationsEnabled) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getContext());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // For Android 8.0 (API level 26) and above, manage notification channels
            for (String channelId : getNotificationChannelIds()) {
                NotificationChannel channel = notificationManager.getNotificationChannel(channelId);
                if (channel != null) {
                    channel.setImportance(areNotificationsEnabled ? NotificationManager.IMPORTANCE_DEFAULT : NotificationManager.IMPORTANCE_NONE);
                    notificationManager.createNotificationChannel(channel);
                }
            }
        } else {
            // For versions below Android 8.0, use a flag to disable notifications
            Log.d(TAG, "Notifications " + (areNotificationsEnabled ? "enabled" : "disabled"));
        }
    }

    private String[] getNotificationChannelIds() {
        // Return an array of notification channel IDs used in your app
        return new String[]{
                "channel_id_1",
                "channel_id_2",
                // Add more channel IDs as needed
        };
    }
}
