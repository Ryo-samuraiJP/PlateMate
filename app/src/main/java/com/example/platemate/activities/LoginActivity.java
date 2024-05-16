package com.example.platemate.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.platemate.R;

public class LoginActivity extends AppCompatActivity {
    // declare global variables
    EditText et_email, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // get references
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
    }

    // login method to handle click event on Login button
    public void login(View view) {
        // get email and password entered by users
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        // get registered email and password from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("REGISTERED_USERS", MODE_PRIVATE);
        String registeredEmail = sharedPreferences.getString("EMAIL", email);
        String registeredPassword = sharedPreferences.getString("PASSWORD", password);

        // Check whether email is empty or not
        if (email.isEmpty()) {
            et_email.setError("Email is empty");
        }
        // check whether password is empty or not
        else if (password.isEmpty()) {
            et_password.setError("Password is empty");
        }
        // check whether input email and password match the registered ones or not
        else if (!email.equals(registeredEmail) || !password.equals(registeredPassword)) {
            Toast.makeText(this, "Invalid email address or password", Toast.LENGTH_SHORT).show();
        }
        // if both of them are valid, login successfully
        else {
            startActivity(new Intent(this, MainActivity.class));
            Toast.makeText(this, "Welcome back to PlateMate!", Toast.LENGTH_SHORT).show();
        }
    }

    // register method to handle click event on Register text view
    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

}