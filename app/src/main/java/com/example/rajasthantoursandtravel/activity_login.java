package com.example.rajasthantoursandtravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_login extends AppCompatActivity {

    EditText username, password;
    Button loginButton;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        dbHelper = new DatabaseHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(activity_login.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else {
                    boolean validUser = dbHelper.checkUser(user, pass);
                    if (validUser) {
                        Toast.makeText(activity_login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(activity_login.this, activity_home.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(activity_login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}


