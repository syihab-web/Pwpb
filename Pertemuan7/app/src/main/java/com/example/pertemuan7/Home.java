package com.example.pertemuan7;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.pertemuan7.ui.dashboard.DashboardFragment;
import com.example.pertemuan7.ui.home.HomeFragment;
import com.example.pertemuan7.ui.notifications.NotificationsFragment;
import com.example.pertemuan7.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_fragment);
        loadFragment(new HomeFragment());

        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
         Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home: fragment = new HomeFragment();
            break;

            case R.id.navigation_dashboard: fragment = new DashboardFragment();
            break;

            case R.id.navigation_notifications: fragment = new NotificationsFragment();
            break;

            case R.id.navigation_profile: fragment = new ProfileFragment();
            break;

            }

        return loadFragment(fragment);
    }
        private boolean loadFragment(Fragment fragment) {

            if (fragment != null) {
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
                return true;
            }
            return false;
        }

    }
