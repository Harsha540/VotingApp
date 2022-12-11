package com.example.anew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    ArrayList<CandidatesRetriveClass> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, position;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.Candidatename);
            position = itemView.findViewById(R.id.positions);
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
        holder.position.setText(candidatesRetriveClass.getPositions());

    }



}
