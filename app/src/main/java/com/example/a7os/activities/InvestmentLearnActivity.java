package com.example.a7os.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a7os.R;
import com.example.a7os.fragments.LearnFragment;

public class InvestmentLearnActivity extends AppCompatActivity {
    CardView beginner,intermediate,trends;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment_learn);

        beginner=findViewById(R.id.beginner);
        intermediate=findViewById(R.id.intermediate);
        trends=findViewById(R.id.trends);
        backButton=findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),IntermediateInvestLearnActivity.class);
                startActivity(i);
            }
        });

        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                startActivity(viewIntent);
            }
        });

        trends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                startActivity(viewIntent);
            }
        });

    }
}