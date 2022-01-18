package com.example.a7os.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.a7os.R;
import com.example.a7os.fragments.DashboardFragment;
import com.example.a7os.fragments.LearnFragment;
import com.example.a7os.fragments.LeaderboardFragment;
import com.example.a7os.fragments.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new DashboardFragment()).commit();
        bottom_navigation=findViewById(R.id.bottom_nav);
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment =null;

                switch (item.getItemId())
                {
                    case R.id.dashboard:
                        selectedFragment=new DashboardFragment();
                        break;
                        //open fragement
                    case R.id.wallet:
                        selectedFragment=new WalletFragment();
                        break;
                        //open fragement
                    case R.id.learn:
                        selectedFragment=new LearnFragment();
                        break;
                        //open fragement
                    case R.id.leaderboard:
                        selectedFragment=new LeaderboardFragment();
                        break;
                        //open fragement

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
                return true;
            }
        });
        // check
    }
}