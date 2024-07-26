package com.example.thereafter;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.example.thereafter.fragments.Home;
import com.example.thereafter.fragments.Posts;
import com.example.thereafter.fragments.Profile;
import com.example.thereafter.fragments.Sermons;
import com.example.thereafter.fragments.Settings;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String PREFERENCES_FILE = "com.example.thereafter.preferences";
    private static final String LANGUAGE_KEY = "language";
    private static final String DARK_MODE_KEY = "dark_mode";
    private DrawerLayout drawer;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load preferences
        SharedPreferences preferences = getSharedPreferences(PREFERENCES_FILE, 0);
        String language = preferences.getString(LANGUAGE_KEY, Locale.getDefault().getLanguage());
        boolean darkMode = preferences.getBoolean(DARK_MODE_KEY, false);

        // Apply language settings
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Apply dark mode settings
        applyDarkMode(darkMode);

        // Set content view after updating configuration
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, new Home())
                            .commit();
                    break;
                case R.id.nav_sermons:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, new Sermons())
                            .commit();
                    break;
                case R.id.nav_posts:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, new Posts())
                            .commit();
                    break;
                case R.id.nav_profile:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, new Profile())
                            .commit();
                    break;
                case R.id.nav_settings:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, new Settings())
                            .commit();
                    break;
            }
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });

        // Show the HomeFragment by default
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, new Home())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void applyDarkMode(boolean isDarkModeEnabled) {
        if (isDarkModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            Log.d("MainActivity", "Dark mode applied");
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            Log.d("MainActivity", "Light mode applied");
        }
    }
}
