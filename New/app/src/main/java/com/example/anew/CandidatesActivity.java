package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.anew.databinding.ActivityCandidatesBinding;

public class CandidatesActivity extends DrawerBaseActivity {


    ActivityCandidatesBinding activityCandidatesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCandidatesBinding = ActivityCandidatesBinding.inflate(getLayoutInflater());

        setContentView(activityCandidatesBinding.getRoot());
        allocateActivityTitle("Candidates");


    }
}