package com.example.cabway;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Objects;

public class CreateAccount extends AppCompatActivity {
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    Button btnSign;
    Button btnGoogle;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        firebaseAuth = FirebaseAuth.getInstance();
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        btnSign = findViewById(R.id.btnSign);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    Intent intent1 = new Intent(CreateAccount.this,FindLocation.class);
                    startActivity(intent1);
                }
            }
        });

        GoogleSignInClient googleSignInClient;
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Todo: add login with google

                // authentication code
                Intent googleSignInIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(googleSignInIntent, 1234);

            }
        });

    }

    public boolean validate() {

        //checking if empty
        if(et1.getText().toString().equals("")){
            et1.setError("Invalid Name");
            et1.setFocusable(true);
            et1.setFocusableInTouchMode(true);
            et1.requestFocus();
            return false;
        }if(et2.getText().toString().equals("")){
            et2.setError("Invalid Email");
            et2.setFocusable(true);
            et2.setFocusableInTouchMode(true);
            et2.requestFocus();
            return false;
        }if(et3.getText().toString().equals("")){
            et3.setError("Invalid Password");
            et3.setFocusable(true);
            et3.setFocusableInTouchMode(true);
            et3.requestFocus();
            return false;
        }if(et4.getText().toString().equals("")){
            et4.setError("Invalid Phone no");
            et4.setFocusable(true);
            et4.setFocusableInTouchMode(true);
            et4.requestFocus();
            return false;
        }
        return true;
    }

    // for google authentication
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
                firebaseAuth.signInWithCredential(credential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Todo: create next Activity in place of 'LoginActivity' in below code (call 1)
//                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                                    startActivity(intent);
                                } else {
                                    Toast.makeText(CreateAccount.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            // Todo: create next Activity in place of 'LoginActivity' in below code (call 2)

        }
    }

}
