package com.example.plutusecurus.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.plutusecurus.R;
import com.example.plutusecurus.fragments.DashboardFragment;
import com.example.plutusecurus.fragments.NftFragment;
import com.example.plutusecurus.fragments.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;
    ImageView qrScanner,profileButton;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new DashboardFragment()).commit();
        bottom_navigation=findViewById(R.id.bottom_nav);
        qrScanner=findViewById(R.id.qr);
        profileButton=findViewById(R.id.profile);

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

                case R.id.nft:
                    selectedFragment=new NftFragment();
                    break;


            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        });

        qrScanner.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),QrActivity.class));
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
            }
        });

    }
}