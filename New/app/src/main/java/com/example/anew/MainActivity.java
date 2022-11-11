package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    TextView mFullname, mEmail, mPassword, mPhone;
    String email,phone;
    Button mRegisterBtn;
     FirebaseAuth fAuth;
     FirebaseFirestore fstore;
     Button LogoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail= findViewById(R.id.email);
        mPhone = findViewById(R.id.phone);
        fAuth = FirebaseAuth.getInstance();
        LogoutBtn = findViewById(R.id.LogoutBtn);
        fstore = FirebaseFirestore.getInstance();

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth.signOut();
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
                Toast.makeText(MainActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            }
        });


      }
}