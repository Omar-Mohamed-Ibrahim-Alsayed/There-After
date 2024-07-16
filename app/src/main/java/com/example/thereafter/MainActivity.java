package com.example.thereafter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.example.thereafter.fragments.Home;
import com.example.thereafter.fragments.Posts;
import com.example.thereafter.fragments.Profile;
import com.example.thereafter.fragments.Sermons;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.flFragment, Splash())
//            commit()
//        }
//    }
//}

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            // Handle navigation item clicks here.
            // You can replace fragments based on the selected item.
            switch (item.getItemId()) {
                case R.id.nav_home:
                    // Replace fragment with HomeFragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, new Home())
                            .commit();
                    break;
                case R.id.nav_sermons:
                    // Replace fragment with GalleryFragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, new Sermons())
                            .commit();
                    break;
                case R.id.nav_posts:
                    // Replace fragment with SlideshowFragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, new Posts())
                            .commit();
                    break;
                case R.id.nav_profile:
                    // Replace fragment with SlideshowFragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, new Profile())
                            .commit();
                    break;

            }

            // Close the drawer after selecting an item
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

    // Ensure the ActionBarDrawerToggle handles the back button press correctly
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}


