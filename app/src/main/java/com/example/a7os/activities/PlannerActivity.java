package com.example.a7os.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;

public class PlannerActivity extends AppCompatActivity {

    private PieChart pie1;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    String house,food,transport,essential,misc,gift,luxury,medical;
    TextView House,Food,Transport,Essential,Misc,Gift,Luxury,Medical;
    ImageView backButton;
    //ghjghgh

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);
        pie1=findViewById(R.id.pie_chart_1);
        backButton = findViewById(R.id.back_button_planner);

        House=findViewById(R.id.house_amt);
        Food=findViewById(R.id.food_amt);
        Transport=findViewById(R.id.transport_amt);
        Essential=findViewById(R.id.transport_amt);
        Misc=findViewById(R.id.misc_amt);
        Gift=findViewById(R.id.gift_amt);
        Luxury=findViewById(R.id.luxury_amt);
        Medical=findViewById(R.id.medical_amt);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        userID=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference=fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                house=value.getString("House");
                food=value.getString("Food");
                essential=value.getString("Essentials");
                gift= value.getString("Gift");
                transport=value.getString("Transport");
                misc=value.getString("Miscellaneous");
                luxury=value.getString("Luxury");
                medical=value.getString("Medical");

            }
        });

        House.setText(house);
        Food.setText(food);
        Essential.setText(essential);
        Gift.setText(gift);
        Transport.setText(transport);
        Misc.setText(misc);
        Luxury.setText(luxury);
        Medical.setText(medical);

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