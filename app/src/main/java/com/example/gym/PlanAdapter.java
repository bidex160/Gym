package com.example.gym;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder>{

    private ArrayList<plan> plans = new ArrayList<>();
    Context context;

    public PlanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_adapter_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ntxt.setText(plans.get(position).getTrainingplan().getName());
        holder.sdesc.setText(plans.get(position).getTrainingplan().getShortdesc());
        Glide.with(context)
                .asBitmap()
                .load(plans.get(position).getTrainingplan().getImageurl())
                .into(holder.pimageView);


    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pimageView;
        TextView ntxt, sdesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pimageView = itemView.findViewById(R.id.pimgview);
            ntxt = itemView.findViewById(R.id.pname);
            sdesc = itemView.findViewById(R.id.pdesc);
        }
    }

    public void setPlans(ArrayList<plan> plans) {
        this.plans = plans;
    }
}
