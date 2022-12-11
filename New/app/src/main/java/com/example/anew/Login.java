package com.example.anew;


import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

import java.util.Objects;

public class Login extends AppCompatActivity {

Button  loginButton;
TextView goToSignup;
EditText loginUsername, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginButton = findViewById(R.id.loginBtn);
        goToSignup = findViewById(R.id.createtext);

        loginUsername = findViewById(R.id.mobileNumber);
        loginPassword = findViewById(R.id.password);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = loginUsername.getText().toString();
                String password_ = loginPassword.getText().toString();

                if(!username.isEmpty()){
                    loginUsername.setError(null);

                    if(!password_.isEmpty()){
                        loginPassword.setError(null);

                        final String loginUsername_data = loginUsername.getText().toString();
                        final String loginPassword_data = loginPassword.getText().toString();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference reference = firebaseDatabase.getReference("users");

                        Query checkUsername = reference.orderByChild("name").equalTo(loginUsername_data);
                        checkUsername.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    loginUsername.setError(null);
                                    String passwordCheck = snapshot.child(loginUsername_data).child("password").getValue(String.class);
                                    if(passwordCheck.equals(loginPassword_data)){
                                        loginPassword.setError(null);
                                        Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();


                                        String Fullname = snapshot.child(loginUsername_data).child("name").getValue(String.class);
                                        String Email = snapshot.child(loginUsername_data).child("email").getValue(String.class);
                                        String Mobile = snapshot.child(loginUsername_data).child("phone").getValue(String.class);


                                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);

                                        intent.putExtra("name", Fullname);
                                        intent.putExtra("email", Email);
                                        intent.putExtra("phone", Mobile);

                                        startActivity(intent);
                                        finish();

                                    }else {
                                        loginPassword.setError("Wrong Password");
                                    }

                                }else{
                                     loginUsername.setError("User Does not Exists");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }else{
                        loginPassword.setError("Please Enter Password");
                    }

                }else{
                    loginUsername.setError("Please Enter Username");
                }
            }
        });

        goToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
                finish();

            }
        });

    }


}


//
//------------------------------------------------------------------------------------------------------
//
//     EditText mEmail, mpassword;
//     Button mLoginBtn;
//     TextView mCreateBtn;
//     FirebaseAuth fAuth;
//     FirebaseDatabase firebaseDatabase;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        fAuth = FirebaseAuth.getInstance();
//        mEmail = findViewById(R.id.email);
//        mpassword = findViewById(R.id.password);
//        mLoginBtn = findViewById(R.id.loginBtn);
//       mCreateBtn = findViewById(R.id.createtext);
//
//
//
//
//        mCreateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), Register.class));
//
//            }
//        });
//
//        mLoginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String email = mEmail.getText().toString().trim();
//                String password = mpassword.getText().toString().trim();
//
//                if(TextUtils.isEmpty(email)){
//                    mEmail.setError("Email is required");
//                    return;
//                }
//
//                if(TextUtils.isEmpty(password)){
//                    mpassword.setError("Password is required");
//                    return;
//                }
//
//                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
//
//                        } else {
//
//                            Toast.makeText(Login.this, "Login Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//                    }
//
//                });
//    }
//}
