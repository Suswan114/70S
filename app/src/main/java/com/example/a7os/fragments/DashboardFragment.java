package com.example.a7os.fragments;

import static android.R.color.*;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import android.R.color;
import com.example.a7os.R;
import com.example.a7os.activities.PlannerActivity;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class DashboardFragment extends Fragment {

    ImageView pie_chart_button;
    ImageView plus,minus;
    Button cashButton,creditButton,allButton;
    SwitchCompat toggleSwitch;
    TextView switchText,cash,credit,total;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_dashboard,container,false);

        /*--------------------DECLARATIONS------------------------------------------*/
        pie_chart_button=view.findViewById(R.id.main_page_pie);
        plus=view.findViewById(R.id.add_button);
        minus=view.findViewById(R.id.minus_button);
        toggleSwitch=view.findViewById(R.id.switch_day);
        switchText=view.findViewById(R.id.switch_text);
        cash=view.findViewById(R.id.cash_val);
        credit=view.findViewById(R.id.credit_val);
        total=view.findViewById(R.id.total_val);
        cashButton=view.findViewById(R.id.cash_button);
        creditButton=view.findViewById(R.id.credit_button);
        allButton=view.findViewById(R.id.all_button);

        allButton.setBackgroundColor(getResources().getColor(R.color.button_selected));



        /*TODO
            1.TOGGLE BUTTON FUNCTIONS LEFT
            2.SWITCH FUNCTIONS LEFT
            3.TEXT NOT CHANGING ON CLICKS
            4.DESIGNS REMODELING
            /#1D385A/
         */

        /*_______________________________BUTTONS CONFIGS_________________________________________*/

        cashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cashButton.setBackgroundColor(getResources().getColor(R.color.button_selected));
                creditButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));
                allButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));

                //text change
            }
        });
        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditButton.setBackgroundColor(getResources().getColor(R.color.button_selected));
                cashButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));
                allButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));

                //text change
            }
        });
        allButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allButton.setBackgroundColor(getResources().getColor(R.color.button_selected));
                creditButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));
                cashButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));

                //text change
            }
        });

        toggleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switchText.setText("MONTHLY");
                    //weekly
                }else{
                    switchText.setText("WEEKLY");
                    //monthly
                }
            }
        });

        pie_chart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), PlannerActivity.class);
                startActivity(intent);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddDialog();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMinusDialog();
            }

        });
        return view;
    }

    private void showAddDialog(){
        Dialog add_dialog=new Dialog(getActivity());
        add_dialog.setContentView(R.layout.add_dialog_layout);
        add_dialog.getWindow().setBackgroundDrawableResource(transparent);
        TextView ok_button=add_dialog.findViewById(R.id.ok_button);
        TextView cancel_button=add_dialog.findViewById(R.id.cancel_button);

        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add data to file
                add_dialog.dismiss();
            }
        });
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_dialog.dismiss();
            }
        });
        add_dialog.show();

    }
    private void showMinusDialog(){
        Dialog minus_dialog=new Dialog(getActivity());
        minus_dialog.setContentView(R.layout.minus_dialog_layout);
        minus_dialog.getWindow().setBackgroundDrawableResource(transparent);
        TextView ok_button=minus_dialog.findViewById(R.id.ok_button);
        TextView cancel_button=minus_dialog.findViewById(R.id.cancel_button);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add data to file
                minus_dialog.dismiss();
            }
        });
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minus_dialog.dismiss();
            }
        });
        minus_dialog.show();
    }


}
