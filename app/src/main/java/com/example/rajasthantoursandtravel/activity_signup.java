package com.example.rajasthantoursandtravel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_signup extends AppCompatActivity {

    private EditText fullName, email, password, confirmPassword;
    private Button signupButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize UI elements
        fullName = findViewById(R.id.fullName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.passwordSignup);
        confirmPassword = findViewById(R.id.confirmPassword);
        signupButton = findViewById(R.id.signupButton);

        dbHelper = new DatabaseHelper(this);

        // Handle Signup Button Click
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = fullName.getText().toString().trim();
        String userEmail = email.getText().toString().trim();
        String userPassword = password.getText().toString().trim();
        String userConfirmPassword = confirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(userEmail) ||
                TextUtils.isEmpty(userPassword) || TextUtils.isEmpty(userConfirmPassword)) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!userPassword.equals(userConfirmPassword)) {
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean inserted = dbHelper.insertUser(name, userEmail, userPassword);
        if (inserted) {
            Toast.makeText(this, "Signup Successful!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, activity_login.class));
            finish();
        } else {
            Toast.makeText(this, "Signup Failed: Email already registered", Toast.LENGTH_LONG).show();
        }
    }
}
