package com.example.platemate.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.platemate.R;

public class OpenerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opener);
    }

    // register method to handle click event on Register button
    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    // login method to handle click event on Login text view
    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}