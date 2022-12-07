package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.anew.databinding.ActivityVotingBinding;

public class VotingActivity extends DrawerBaseActivity {

    ActivityVotingBinding activityVotingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityVotingBinding = ActivityVotingBinding.inflate(getLayoutInflater());

        setContentView(activityVotingBinding.getRoot());
        allocateActivityTitle("Voting");
    }
}