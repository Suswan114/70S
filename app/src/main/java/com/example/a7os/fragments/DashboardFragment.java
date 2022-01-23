package com.example.a7os.fragments;

import static android.R.color.*;

import android.app.Dialog;
import android.content.Intent;
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
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.example.a7os.R;
import com.example.a7os.activities.PlannerActivity;

public class DashboardFragment extends Fragment {

    ImageView pie_chart_button;
    ImageView plus,minus;
    Button cashButton,creditButton,allButton;
    SwitchCompat toggleSwitch;
    TextView switchText,expenditure, earnings,total;

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
        expenditure=view.findViewById(R.id.cash_val);
        earnings =view.findViewById(R.id.credit_val);
        total=view.findViewById(R.id.total_val);
        cashButton=view.findViewById(R.id.cash_button);
        creditButton=view.findViewById(R.id.credit_button);
        allButton=view.findViewById(R.id.all_button);

        allButton.setBackgroundColor(getResources().getColor(R.color.button_selected));

        /*______________________________TEXT CONFIG___________________________*/
        final int[] selected = {0};
        expenditure.setText("INR 2,500");
        earnings.setText("INR 3,000");
        total.setText("INR 500");

        /*_______________________________BUTTONS CONFIGS_________________________________________*/

        cashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cashButton.setBackgroundColor(getResources().getColor(R.color.button_selected));
                creditButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));
                allButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));
                selected[0] =1;
                if(toggleSwitch.isChecked()){
                    expenditure.setText("INR 4,000");
                    earnings.setText("INR 4,800");
                    total.setText("INR 800");
                }else{
                    expenditure.setText("INR 1,000");
                    earnings.setText("INR 1,200");
                    total.setText("INR 200");
                }

            }
        });
        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditButton.setBackgroundColor(getResources().getColor(R.color.button_selected));
                cashButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));
                allButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));

                selected[0] =2;

                if(toggleSwitch.isChecked()){
                    expenditure.setText("INR 6,000");
                    earnings.setText("INR 7,200");
                    total.setText("INR 1,200");
                }else{
                    expenditure.setText("INR 1,500");
                    earnings.setText("INR 1,800");
                    total.setText("INR 300");
                }
            }
        });
        allButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allButton.setBackgroundColor(getResources().getColor(R.color.button_selected));
                creditButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));
                cashButton.setBackgroundColor(getResources().getColor(R.color.button_unselected));
                selected[0] =0;
                if(toggleSwitch.isChecked()){
                    expenditure.setText("INR 10,000");
                    earnings.setText("INR 12,000");
                    total.setText("INR 2,000");
                }else{
                    expenditure.setText("INR 2,500");
                    earnings.setText("INR 3,000");
                    total.setText("INR 500");
                }
            }
        });

        toggleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switchText.setText("MONTHLY");
                    if(selected[0]==0){
                        expenditure.setText("INR 10,000");
                        earnings.setText("INR 12,000");
                        total.setText("INR 2,000");
                    }else if(selected[0]==1){
                        expenditure.setText("INR 4,000");
                        earnings.setText("INR 4,800");
                        total.setText("INR 800");
                    }else{
                        expenditure.setText("INR 6,000");
                        earnings.setText("INR 7,200");
                        total.setText("INR 1,200");
                    }

                }else{
                    switchText.setText("WEEKLY");
                    if(selected[0]==0){
                        expenditure.setText("INR 2,500");
                        earnings.setText("INR 3,000");
                        total.setText("INR 500");
                    }else if(selected[0]==1){
                        expenditure.setText("INR 1,000");
                        earnings.setText("INR 1,200");
                        total.setText("INR 200");
                    }else{
                        expenditure.setText("INR 1,500");
                        earnings.setText("INR 1,800");
                        total.setText("INR 300");
                    }
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
