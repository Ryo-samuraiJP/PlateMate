package com.example.platemate.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.platemate.R;

public class OrderPlaced extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);
    }

    // Method to handle click event on Back to Home button
    public void backToHome(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}