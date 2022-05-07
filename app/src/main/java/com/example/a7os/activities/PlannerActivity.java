package com.example.a7os.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a7os.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PlannerActivity extends AppCompatActivity {

    private PieChart pie1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);
        pie1=findViewById(R.id.pie_chart_1);
        ImageView backButton = findViewById(R.id.back_button_planner);

        backButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(PlannerActivity.this, MainActivity.class);
            PlannerActivity.this.startActivity(myIntent);
            finish();
        });
        loadPieChart1();
    }

    private void loadPieChart1(){

        pie1.setDrawHoleEnabled(false);
        pie1.setUsePercentValues(true);
        pie1.setCenterTextSize(8f);
        pie1.setEntryLabelColor(Color.BLACK);
        pie1.setCenterTextSize(8f);
        pie1.getDescription().setEnabled(false);
        Legend l=pie1.getLegend();
        l.setDrawInside(false);
        l.setEnabled(false);

        ArrayList<PieEntry> entries=new ArrayList<>();
        entries.add(new PieEntry(0.1f,"Housing"));
        entries.add(new PieEntry(0.1f,"Food"));
        entries.add(new PieEntry(0.1f,"Medication"));
        entries.add(new PieEntry(0.1f,"Transport"));
        entries.add(new PieEntry(0.2f,"Essentials"));
        entries.add(new PieEntry(0.1f,"Luxury"));
        entries.add(new PieEntry(0.1f,"Gift"));
        entries.add(new PieEntry(0.2f,"Misc."));

        ArrayList<Integer> colors =new ArrayList<>();
        for(int color: ColorTemplate.MATERIAL_COLORS){ colors.add(color); }
        for(int color:ColorTemplate.VORDIPLOM_COLORS){ colors.add(color); }
        PieDataSet dataSet=new PieDataSet(entries,"Expenses");
        dataSet.setColors(colors);

        PieData data=new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pie1));
        data.setValueTextSize(8f);
        data.setValueTextColor(Color.BLACK);
        pie1.setData(data);
        pie1.invalidate();
        pie1.animateX(1400, Easing.EaseInOutQuad);
    }
}