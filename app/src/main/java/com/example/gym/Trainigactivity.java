package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Trainigactivity extends AppCompatActivity {
    Button addplan;
    TextView name, Ldesc;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainigactivity);
        initviews();

        try {
            final Intent intent = getIntent();
             final Training training = intent.getParcelableExtra("training");
            name.setText(training.getName());
            Ldesc.setText(training.getLongdesc());
            Glide.with(this)
                    .asBitmap()
                    .load(training.getImageurl())
                    .into(imageView);


                   addplan.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           Intent intent1 = new Intent(Trainigactivity.this, plandialog.class);
                           intent1.putExtra("parcelable",training );
                           startActivity(intent1);

                       }
                   });

        }catch (Exception e){

        }
    }

    private void initviews() {
        addplan = findViewById(R.id.addplan);
        name = findViewById(R.id.name);
        Ldesc = findViewById(R.id.Ldesc);
        imageView = findViewById(R.id.imgv);
    }
}
