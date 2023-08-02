package com.example.cabway;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {
    EditText etEmail;
    EditText etPass;
    Button btnLogin;
    Button btnSign;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnSign = findViewById(R.id.btnSign);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginPage.this, CreateAccount.class);
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Intent intent1 = new Intent(LoginPage.this,FindLocation.class);
                    startActivity(intent1);

                }
            }
        });
    }
    private boolean validate() {
        if (etEmail.getText().toString().equals("")) {
            etEmail.setError("Invalid Email");
            etEmail.setFocusable(true);
            etEmail.setFocusableInTouchMode(true);
            etEmail.requestFocus();

            return false;
        }
        if (etPass.getText().toString().equals("")) {
            etPass.setError("Invalid Password");
            etPass.setFocusable(true);
            etPass.setFocusableInTouchMode(true);
            etPass.requestFocus();
            return false;
        }
        return true;
    }
}