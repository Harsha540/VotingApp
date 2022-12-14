package com.example.anew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.anew.databinding.ActivityCandidatesBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class CandidatesActivity extends DrawerBaseActivity {

    static boolean flag=false;

    Button addingCandidates;


    ActivityCandidatesBinding activityCandidatesBinding;

    RecyclerView recyclerView;
    DatabaseReference reference;
    Adapter adapter;
    ArrayList<CandidatesRetriveClass> list;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCandidatesBinding = ActivityCandidatesBinding.inflate(getLayoutInflater());

        setContentView(activityCandidatesBinding.getRoot());
        allocateActivityTitle("Candidates");
        addingCandidates = findViewById(R.id.addingCandidates);



        recyclerView = findViewById(R.id.candidatesList);
        reference = FirebaseDatabase.getInstance().getReference("candidates");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);
        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    CandidatesRetriveClass user = dataSnapshot.getValue(CandidatesRetriveClass.class);
//                    String n = user.getPosition();
                    list.add(user);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addingCandidates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddingCandidates.class);
                startActivity(intent);
                finish();
            }
        });

        if (flag == true)
            Toast.makeText(this, "you have already casted your vote, thank you", Toast.LENGTH_SHORT).show();

        else {

            new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                    flag=true;

                    CandidatesRetriveClass cr = list.get(viewHolder.getAdapterPosition());

                    startActivity(new Intent(CandidatesActivity.this, DashboardActivity.class));

                    int pos = viewHolder.getAbsoluteAdapterPosition();

                    Toast.makeText(CandidatesActivity.this, "you have voted" + cr.name, Toast.LENGTH_SHORT).show();



                }


            }).attachToRecyclerView(recyclerView);;


        }
    }
}