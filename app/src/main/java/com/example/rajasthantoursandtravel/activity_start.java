package com.example.rajasthantoursandtravel;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class activity_start extends AppCompatActivity {

    private Spinner languageSpinner;
    private String[] languages = {"English","Gujarati"};
    private boolean isLanguageChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Initialize UI elements
        Button btnSignup = findViewById(R.id.btnSignup);
        Button btnLogin = findViewById(R.id.btnLogin);
        languageSpinner = findViewById(R.id.languageSpinner);

        // Set up Spinner adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        // Handle language selection
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        changeLanguage("en");
                        break;
                    case 1:
                        changeLanguage("gu");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Signup button click
        btnSignup.setOnClickListener(v -> {
            Intent intent = new Intent(activity_start.this, activity_signup.class);
            startActivity(intent);
        });

        // Login button click
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(activity_start.this, activity_login.class);
            startActivity(intent);
        });
    }

    private void changeLanguage(String languageCode) {
        if (!isCurrentLocale(languageCode)) {
            Locale locale = new Locale(languageCode);
            Locale.setDefault(locale);
            Resources resources = getResources();
            Configuration config = resources.getConfiguration();
            DisplayMetrics dm = resources.getDisplayMetrics();
            config.setLocale(locale);
            resources.updateConfiguration(config, dm);

            isLanguageChanged = true;
            recreate(); // Refresh the activity
        }
    }

    private boolean isCurrentLocale(String languageCode) {
        Locale currentLocale = getResources().getConfiguration().locale;
        return currentLocale.getLanguage().equals(languageCode);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isLanguageChanged) {
            isLanguageChanged = false;
        }
    }
}

