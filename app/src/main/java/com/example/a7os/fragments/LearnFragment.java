package com.example.a7os.fragments;

import android.app.Activity;
import android.content.Intent;
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

public class LearnFragment extends Fragment {

    CardView savings,invest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_learn,container,false);
        invest=view.findViewById(R.id.invest);
        invest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), InvestmentLearnActivity.class);
                startActivity(i);
                ((Activity)getActivity()).overridePendingTransition(0,0);
            }
        });
        return view;
        //check
    }
}
