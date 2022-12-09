package com.example.anew;


import android.os.Bundle;

import com.example.anew.databinding.ActivityHomeBinding;

public class HomeActivity extends DrawerBaseActivity {

    ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());

        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Home ");


    }


}