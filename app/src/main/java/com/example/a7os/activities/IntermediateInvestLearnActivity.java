package com.example.a7os.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.a7os.R;

public class IntermediateInvestLearnActivity extends AppCompatActivity {
    ImageView backButton;
    CardView equity,mutualFunds,fd,goldBond,ppf,ipo,crypto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate_invest_learn);
        backButton=findViewById(R.id.back_button_inv);
        equity=findViewById(R.id.direct_equity);
        mutualFunds=findViewById(R.id.mutual_funds);
        fd=findViewById(R.id.fixed_deposit);
        goldBond=findViewById(R.id.gold_bonds);
        ppf=findViewById(R.id.ppf);
        ipo=findViewById(R.id.ipo);
        crypto=findViewById(R.id.crypto);

        backButton.setOnClickListener(view -> finish());
        equity.setOnClickListener(view -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });

        mutualFunds.setOnClickListener(view -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });

        fd.setOnClickListener(view -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });

        goldBond.setOnClickListener(view -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });
        ppf.setOnClickListener(view -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });

        ipo.setOnClickListener(view -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });

        crypto.setOnClickListener(view -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });

    }
}