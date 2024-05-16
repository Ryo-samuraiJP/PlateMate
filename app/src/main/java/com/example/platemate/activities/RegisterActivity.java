package com.example.platemate.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.platemate.R;

public class RegisterActivity extends AppCompatActivity {
    // Declare global variables
    EditText et_name, et_email, et_password, et_password2;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // get references
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_password2 = findViewById(R.id.et_password2);
        checkBox = findViewById(R.id.checkBox);

        // To change part of textView and make it bold
        String text = "I agree to Terms and Conditions";
        SpannableString spannableString = new SpannableString(text);
        int startIndex = text.indexOf("Terms");
        int endIndex = startIndex + "Terms".length();
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4CAF50")), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        startIndex = text.indexOf("Conditions");
        endIndex = startIndex + "Conditions".length();
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4CAF50")), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        checkBox.setText(spannableString);
    }

    // register method to handle click event on Register button
    public void register (View view) {
        // get name, email, password, and confirm password entered by users
        String name = et_name.getText().toString().trim();
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String confirmPassword = et_password2.getText().toString().trim();

        // check whether name is empty or not
        if (name.isEmpty()) {
            et_name.setError("Name is empty");
        }
        // check whether email is empty or not
        else if (email.isEmpty()) {
            et_email.setError("Email is empty");
        }
        // check whether email ends with either @gmail.com, @yahoo.com, or @icloud.com or not
        else if (!email.endsWith("@gmail.com") && !email.endsWith("@yahoo.com") && !email.endsWith("@icloud.com")) {
            et_email.setError("Invalid email address");
            Toast.makeText(this, "Please use either @gmail, @yahoo.com, or @icloud.com", Toast.LENGTH_SHORT).show();
        }
        // check whether password is empty or not
        else if (password.isEmpty()) {
            et_password.setError("Password is empty");
        }
        // check whether password is at least 8 characters long or not
        else if (password.length() < 8) {
            et_password.setError("Password must be at least 8 characters long");
        }
        // check whether password contains both letters and numbers or not
        else if (password.matches("[0-9]+") || password.matches("[a-zA-Z]+")) {
            et_password.setError("Password must include both letters and numbers");
        }
        // check whether confirm password is empty or not
        else if (confirmPassword.isEmpty()) {
            et_password2.setError("Confirm Password is empty");
        }
        // check whether confirm password matches entered password above or not
        else if (!confirmPassword.equals(password)) {
            et_password2.setError("Password does not match");
        }
        // check whether check box is checked or not
        else if (!checkBox.isChecked()) {
            Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show();
        }
        // if passed all of validations above, store email and password in SharedPreferences and start the MainActivity
        else {
            startActivity(new Intent(this, MainActivity.class));
            Toast.makeText(this, "Registration succeeded", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Welcome to PlateMate!", Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("REGISTERED_USERS", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("EMAIL", email);
            editor.putString("PASSWORD", password);
            editor.apply();
        }
    }

    // login method to handle click event on Login text view
    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}