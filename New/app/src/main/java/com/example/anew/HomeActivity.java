package com.example.anew;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.anew.databinding.ActivityHomeBinding;

public class HomeActivity extends DrawerBaseActivity {

    ActivityHomeBinding activityHomeBinding;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());

        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Home ");
        frameLayout=findViewById(R.id.Frame_layout);


    }




}