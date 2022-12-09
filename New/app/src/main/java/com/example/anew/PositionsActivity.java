package com.example.anew;

import android.os.Bundle;

import com.example.anew.databinding.ActivityPositionsBinding;

public class PositionsActivity extends DrawerBaseActivity {
    ActivityPositionsBinding activityPositionsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPositionsBinding = ActivityPositionsBinding.inflate(getLayoutInflater());
        setContentView(activityPositionsBinding.getRoot());
        allocateActivityTitle("Positions");
    }
}