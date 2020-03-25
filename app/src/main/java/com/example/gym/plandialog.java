package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class plandialog extends AppCompatActivity {
    private static final String TAG = "";
    Button btadd, btcancel;
    TextView nametxt;
    EditText minedit;
    Spinner spinner;

    ArrayList<String> strings = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plandialog);
        initviews();

        strings.add("Monday");
        strings.add("Tuesday");
        strings.add("Wednesday");
        strings.add("Thursday");
        strings.add("Friday");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(adapter);

        try {

                 Intent intent = getIntent();
                final Training training = intent.getParcelableExtra("parcelable");
                  String n = training.getName();
                 nametxt.setText(n);
            btadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int x = Integer.parseInt(minedit.getText().toString());
                    plan plan = new plan();
                    plan.setMinutes(x);
                    plan.setDay(spinner.getSelectedItem().toString());
                    plan.setTrainingplan(training);
                    Utils.addplans(plan);
                    Intent intent1 = new Intent(plandialog.this, PlanActivity.class);
                    intent1.putExtra("plan", plan);
                    startActivity(intent1);


                }
            });


        }catch (Exception e){
            Log.e(TAG, "onCreate: "+ e );

        }




    }

    private void initviews() {

        btadd = findViewById(R.id.btadd);
        btcancel = findViewById(R.id.btcancel);
        nametxt = findViewById(R.id.tname);
        minedit = findViewById(R.id.minsedit);
        spinner = findViewById(R.id.spinner);
    }
}
