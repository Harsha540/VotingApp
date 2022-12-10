package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anew.databinding.ActivityCandidatesBinding;

public class CandidatesActivity extends DrawerBaseActivity {

    Button addingCandidates;


    ActivityCandidatesBinding activityCandidatesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCandidatesBinding = ActivityCandidatesBinding.inflate(getLayoutInflater());

        setContentView(activityCandidatesBinding.getRoot());
        allocateActivityTitle("Candidates");

        addingCandidates = findViewById(R.id.addingCandidates);

        addingCandidates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddingCandidates.class);
                startActivity(intent);
                finish();
            }
        });




    }
}