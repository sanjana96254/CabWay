package com.example.cabway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {
    EditText etEmail;
    EditText etPass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);
        if (etEmail.getText().toString().equals("admin")&& etPass.getText().toString().equals("12345")){
            Intent i = new Intent(LoginPage.this, FindLocation.class);
            startActivity(i);
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LoginPage.this, FindLocation.class);
                startActivity(intent1);

            }
        });
    }
}