package com.example.a7os.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.a7os.R;
import com.example.a7os.fragments.DashboardFragment;
import com.example.a7os.fragments.LeaderboardFragment;
import com.example.a7os.fragments.LearnFragment;
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
        bottom_navigation.setOnNavigationItemSelectedListener(item -> {

            Fragment selectedFragment =null;

            switch (item.getItemId())
            {
                case R.id.dashboard:
                    selectedFragment=new DashboardFragment();
                    break;

                case R.id.wallet:
                    selectedFragment=new WalletFragment();
                    break;

                case R.id.learn:
                    selectedFragment=new LearnFragment();
                    break;

                case R.id.leaderboard:
                    selectedFragment=new LeaderboardFragment();
                    break;


            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        });
    }
}