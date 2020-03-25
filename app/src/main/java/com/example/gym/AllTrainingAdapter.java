package com.example.gym;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AllTrainingAdapter extends RecyclerView.Adapter<AllTrainingAdapter.ViewHolder>{
    ArrayList<Training> trainings = new ArrayList<>();
    Context context;

    public AllTrainingAdapter(Context context) {
        this.context = context;
    }

  //  public AllTrainingAdapter() {
   // }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       holder.Aname.setText(trainings.get(position).getName());
        holder.sdesc.setText(trainings.get(position).getShortdesc());
        Glide.with(context)
                .asBitmap()
                .load(trainings.get(position).getImageurl())
                .into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: navigate to the other
                Intent intent = new Intent(context, Trainigactivity.class);
                intent.putExtra("training", trainings.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

         ImageView imageView;
          TextView sdesc, Aname;
          CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgview);
            Aname = itemView.findViewById(R.id.name);
            sdesc = itemView.findViewById(R.id.Sdesc);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }

    public void setTrainings(ArrayList<Training> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }
}
