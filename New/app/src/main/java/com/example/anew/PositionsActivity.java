package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.anew.databinding.ActivityPositionsBinding;

public class PositionsActivity extends DrawerBaseActivity {
    ActivityPositionsBinding activityPositionsBinding;

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPositionsBinding = ActivityPositionsBinding.inflate(getLayoutInflater());
        setContentView(activityPositionsBinding.getRoot());
        allocateActivityTitle("Positions");

        relativeLayout = findViewById(R.id.Positions);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CandidatesActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}