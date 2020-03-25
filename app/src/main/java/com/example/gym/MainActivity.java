package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button planbt, alltraining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();
        Utils.init();

        alltraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllActivities.class);
                startActivity(intent);

            }
        });

    }

    private void initviews() {
        alltraining = findViewById(R.id.alltraining);
        planbt = findViewById(R.id.plan);
    }
}
