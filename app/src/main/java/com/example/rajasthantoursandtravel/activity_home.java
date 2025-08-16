package com.example.rajasthantoursandtravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView jaipur = findViewById(R.id.imgJaipur);
        ImageView jaiselmer = findViewById(R.id.imgJaiselmer);
        ImageView udaipur = findViewById(R.id.imgUdaipur);
        ImageView kumbalgarh = findViewById(R.id.imgkumbalgarh);
        ImageView mountAbu = findViewById(R.id.imgMountabu);
        ImageView pushkar = findViewById(R.id.imgpushkar);

        jaipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, activity_jaipur.class);
                startActivity(intent);
            }
        });

        jaiselmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, activity_jaiselmer.class);
                startActivity(intent);
            }
        });

        udaipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, activity_udaipur.class);
                startActivity(intent);
            }
        });

        kumbalgarh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, activity_kumbalgarh.class);
                startActivity(intent);
            }
        });

        mountAbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, activity_mount_abu.class);
                startActivity(intent);
            }
        });

        pushkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this, activity_pushkar.class);
                startActivity(intent);
            }
        });
    }
}
