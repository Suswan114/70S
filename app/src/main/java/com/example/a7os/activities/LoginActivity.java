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

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    CardView mLoginButton;
    TextView mCreateButton;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.login_email);
        password=findViewById(R.id.login_pass);
        mLoginButton=findViewById(R.id.login_button);
        mCreateButton=findViewById(R.id.signup_redirect);
        progressBar=findViewById(R.id.login_progressbar);
        fAuth = FirebaseAuth.getInstance();

        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
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

                //authenticating the user

               fAuth.signInWithEmailAndPassword(dEmail,dPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login Successful!!", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "ERROR!!!", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                });

            }
        });

    }
}