package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class PlanActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     PlanAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        initviews();

        try {
            Intent intent = getIntent();
            plan plan = intent.getParcelableExtra("plan");
            Toast.makeText(this, plan.getDay(), Toast.LENGTH_LONG).show();

            adapter.setPlans(Utils.getPlans());


        }catch (Exception e){



        }




    }

    private void initviews() {
        recyclerView = findViewById(R.id.planrecycle);
        adapter = new PlanAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
