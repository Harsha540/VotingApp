package com.example.anew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.anew.databinding.ActivityDashboardBinding;

public class DashboardActivity extends DrawerBaseActivity {

    FrameLayout frameLayout;

    ActivityDashboardBinding activityDashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());

        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("Home ");

        frameLayout=findViewById(R.id.Frame_layout);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.Logout_fragment:
                Fragment fragment1= new LogoutFragment();
                FragmentTransaction transaction1= getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.Frame_layout,fragment1);
                transaction1.commit();
                break;
        }
        return true;
    }


}