package com.appgeeksarena.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button login;
    EditText userEmail, userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.bt_login);
        userEmail = findViewById(R.id.tx_email);
        userPass = findViewById(R.id.tx_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userEmail.getText().toString().equals("Gwa") && userPass.getText().toString().equals("12345678")) {
                    startActivity(new Intent(getApplicationContext(), Home.class));
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"USER NOT FOUND ", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
