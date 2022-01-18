package com.example.a7os.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a7os.R;
import com.example.a7os.activities.PlannerActivity;

public class DashboardFragment extends Fragment {

    ImageView pie_chart_button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_dashboard,container,false);
        pie_chart_button=view.findViewById(R.id.main_page_pie);
        pie_chart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), PlannerActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
