package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class AllActivities extends AppCompatActivity {
    private static final String TAG = "";
    RecyclerView recyclerView;
    AllTrainingAdapter adapter;
    Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_activities);
        recyclerView = findViewById(R.id.recycle);

        adapter = new AllTrainingAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        utils = new Utils();
      try {
          adapter.setTrainings(Utils.getTrainings());

      }catch (Exception e){
          Log.e(TAG, "onCreate: "+ e);

      }


    }
}
