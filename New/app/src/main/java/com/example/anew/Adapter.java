package com.example.anew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    ArrayList<CandidatesRetriveClass> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, pos,desc;
        CheckBox cb;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.Candidatename);
            pos = itemView.findViewById(R.id.pos);


        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public Adapter(Context context, ArrayList<CandidatesRetriveClass> List) {
        this.context = context;
        this.list = List;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.candidateslist, parent, false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CandidatesRetriveClass candidatesRetriveClass= list.get(position);
        holder.name.setText(candidatesRetriveClass.getName());
        holder.pos.setText(candidatesRetriveClass.getPosition());



    }



}
