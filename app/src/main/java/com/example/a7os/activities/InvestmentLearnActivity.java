package com.example.a7os.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.a7os.R;

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

        backButton.setOnClickListener(view -> finish());

        intermediate.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),IntermediateInvestLearnActivity.class);
            startActivity(i);
        });

        beginner.setOnClickListener(view -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });

        trends.setOnClickListener(view -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });

    }
}