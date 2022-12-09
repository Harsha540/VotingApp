package com.example.anew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;




    @SuppressLint("InflateParams")
    @Override
    public void setContentView(View view){
        drawerLayout =(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);




        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()){

            case R.id.nav_home:
                startActivity(new Intent(this, DashboardActivity.class));
                break;

            case R.id.nav_profile:
                startActivity(new Intent(this,ProfileActivity.class));
                break;

            case R.id.nav_candidates:
                startActivity(new Intent(this, CandidatesActivity.class));
                break;

            case R.id.nav_positions:
                startActivity(new Intent(this, PositionsActivity.class));
                break;

            case R.id.nav_voting:
                startActivity(new Intent(this, VotingActivity.class));
                break;

            case R.id.nav_location:
                startActivity(new Intent(this, LocationActivity.class));
                break;
        }

        return false;
    }
    protected  void  allocateActivityTitle(String titleString){
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(titleString);
        }
    }
}