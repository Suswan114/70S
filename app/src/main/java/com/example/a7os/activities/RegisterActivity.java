package com.example.a7os.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a7os.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText name,email,password,phone;
    CardView registerButton;
    TextView loginButton;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

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
        fAuth=FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dEmail=email.getText().toString().trim();
                String dPass=password.getText().toString().trim();

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
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User Created!!", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();

                        }else{
                            Toast.makeText(RegisterActivity.this, "ERROR!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });



    }




}