package com.example.superhero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText mUsername, mPassword;
    Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = findViewById(R.id.input_username);
        mPassword = findViewById(R.id.input_password);
        mSubmit = findViewById(R.id.input_submit);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

                if (username.equals("admin") && password.equals("0000")) {
                    mUsername.setError(null);
                    mPassword.setError(null);
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                } else {
                    if (!username.equals("admin")) {
                        mUsername.setError("incorrect username!");
                    }
                    if (!password.equals("0000")) {
                        mPassword.setError("incorrect password!");
                    }
                }
            }
        });
    }
}