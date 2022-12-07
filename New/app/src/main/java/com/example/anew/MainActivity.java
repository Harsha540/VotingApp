package com.example.anew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

public class MainActivity extends AppCompatActivity {

    TextView mFullname, mEmail, mPassword, mPhone;
    String email,phone;
    Button mRegisterBtn;
     FirebaseAuth fAuth;
     FirebaseFirestore fstore;
     Button LogoutBtn;
     FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


//        mEmail= findViewById(R.id.email);
//        mPhone = findViewById(R.id.phone);
//        fAuth = FirebaseAuth.getInstance();
//       LogoutBtn = findViewById(R.id.LogoutBtn);
//        fstore = FirebaseFirestore.getInstance();
//
//        LogoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fAuth.signOut();
//                Intent intent = new Intent(MainActivity.this, Login.class);
//                startActivity(intent);
//                finish();
//                Toast.makeText(MainActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
//            }
//        });





      }
}