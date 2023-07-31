package com.example.cabway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccount extends AppCompatActivity {
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    Button btnSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        btnSign = findViewById(R.id.btnSign);
        if (et1.getText().toString().equals("Sanjana")&& et2.getText().toString().equals("admin")&& et3.getText().toString().equals("12345")&&et4.getText().toString().equals("9369591459")){
            Intent intent = new Intent(CreateAccount.this, LoginPage.class);
            startActivity(intent);
        }
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CreateAccount.this, LoginPage.class);
                startActivity(intent1);
            }
        });
    }
}
