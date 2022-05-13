package com.example.a7os.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.a7os.R;
import com.example.a7os.activities.InvestmentLearnActivity;

import java.util.Objects;

public class LearnFragment extends Fragment {

    CardView savings,invest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_learn,container,false);
        invest=view.findViewById(R.id.invest);
        savings=view.findViewById(R.id.savings);

        invest.setOnClickListener(view1 -> {
            Intent i=new Intent(getActivity(), InvestmentLearnActivity.class);
            startActivity(i);
            Objects.requireNonNull(getActivity()).overridePendingTransition(0,0);
        });
        savings.setOnClickListener(view12 -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            startActivity(viewIntent);
        });

        return view;
    }
}
