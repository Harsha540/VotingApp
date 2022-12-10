package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.anew.databinding.ActivityAddingCandidatesBinding;
import com.example.anew.databinding.ActivityCandidatesBinding;

public class AddingCandidates extends DrawerBaseActivity {

    ActivityAddingCandidatesBinding activityAddingCandidatesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddingCandidatesBinding = ActivityAddingCandidatesBinding.inflate(getLayoutInflater());

        setContentView(activityAddingCandidatesBinding.getRoot());
        allocateActivityTitle("Adding Candidates");





    }
}