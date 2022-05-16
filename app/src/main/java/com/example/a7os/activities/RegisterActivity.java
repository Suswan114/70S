package com.example.a7os.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.a7os.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText name,email,password,phone,age;
    CardView registerButton;
    TextView loginButton;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    ProgressBar progressBar;
    String userID;
    String v="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.signup_name);
        email=findViewById(R.id.signup_email);
        password=findViewById(R.id.signup_pass);
        phone=findViewById(R.id.signup_phone);
        registerButton=findViewById(R.id.signup_button);
        loginButton=findViewById(R.id.login_redirect);
        progressBar=findViewById(R.id.signup_progressbar);
        age=findViewById(R.id.signup_age);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();


        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        loginButton.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });


        registerButton.setOnClickListener(view -> {
            String dEmail=email.getText().toString().trim();
            String dPass=password.getText().toString().trim();
            String dName=name.getText().toString().trim();
            String dPhone=phone.getText().toString().trim();
            String dAge=age.getText().toString().trim();

            if(TextUtils.isEmpty(dEmail)){
                email.setError("Email is required!!");
                return;
            }

            if(TextUtils.isEmpty(dPass)){
                password.setError("Password is required!!");
                return;
            }

            if(dPass.length()<6){
                password.setError("Please enter more than 6 characters");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);


            fAuth.createUserWithEmailAndPassword(dEmail,dPass)
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User Created!!", Toast.LENGTH_SHORT).show();
                            userID=fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=fStore.collection("users").document(userID);

                            Map<String,Object> user=new HashMap<>();
                            user.put("Name",dName);
                            user.put("Email",dEmail);
                            user.put("Phone",dPhone);
                            user.put("Age",dAge);
                            user.put("Earning",v);
                            user.put("House",v);
                            user.put("Food",v);
                            user.put("Medical",v);
                            user.put("Transport",v);
                            user.put("Luxury",v);
                            user.put("Essentials",v);
                            user.put("Gift",v);
                            user.put("Miscellaneous",v);
                            //sed
                            documentReference.set(user);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }else{

                            Toast.makeText(RegisterActivity.this, "ERROR!!!", Toast.LENGTH_SHORT).show();
                        }
                    });

        });

    }
}