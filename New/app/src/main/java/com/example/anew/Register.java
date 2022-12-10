package com.example.anew;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    Button registerButton;
    TextView goToLogin, signUpUsername, signUpPassword, signUpEmail, signUpMobile;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerButton = findViewById(R.id.registerbtn);
        goToLogin = findViewById(R.id.createtext);

        signUpUsername = findViewById(R.id.fullname);
        signUpEmail = findViewById(R.id.email);
        signUpMobile = findViewById(R.id.phone);
        signUpPassword = findViewById(R.id.password);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username_ = signUpUsername.getText().toString();
                String email_ = signUpEmail.getText().toString();
                String password_ = signUpPassword.getText().toString();
                String mobile_ = signUpMobile.getText().toString();

                if(!username_.isEmpty()){
                    signUpUsername.setError(null);
                    if(!email_.isEmpty()){
                        signUpEmail.setError(null);
                        if(!password_.isEmpty()){
                            signUpPassword.setError(null);
                            if(!mobile_.isEmpty()){
                                signUpMobile.setError(null);
                                if (email_.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                                        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {

                                    firebaseDatabase = FirebaseDatabase.getInstance();
                                    reference = FirebaseDatabase.getInstance().getReference("users");

                                    String username_get = signUpUsername.getText().toString();
                                    String email_get = signUpEmail.getText().toString();
                                    String password_get = signUpPassword.getText().toString();
                                    String mobile_get = signUpMobile.getText().toString();

                                    HelperClass helperClass = new HelperClass(username_get, email_get, password_get, mobile_get);
                                    reference.child(username_get).setValue(helperClass);

                                    Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Login.class);
                                    startActivity(intent);
                                    finish();


                                }else{
                                    signUpEmail.setError("Invalid Email");
                                }



                            }else{
                                signUpMobile.setError("Please Enter Mobile");
                            }

                        }else{
                            signUpPassword.setError("Please Enter Password");
                        }

                    }else{
                        signUpEmail.setError("Please Enter Email");
                    }

                }else{
                    signUpUsername.setError("Please Enter Username");
                }
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();

            }
        });

    }



}







    //
//    EditText mFullname, mEmail, mPassword, mPhone;
//    Button RegisterBtn;
//    TextView LoginBtn;
//    FirebaseDatabase database;
//    DatabaseReference reference;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        mFullname = findViewById(R.id.fullname);
//        mEmail = findViewById(R.id.email);
//        mPassword = findViewById(R.id.password);
//        mPhone = findViewById(R.id.phone);
//        RegisterBtn = findViewById(R.id.registerbtn);
//        LoginBtn = findViewById(R.id.createtext);
//
//        RegisterBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                database = FirebaseDatabase.getInstance();
//                reference = database.getReference("users");
//
//                String name = mFullname.getText().toString();
//                String email = mEmail.getText().toString();
//                String password = mPassword.getText().toString();
//                String phone = mPhone.getText().toString();
//
//                HelperClass helperClass = new HelperClass(name, email, password, phone);
//                reference.child(name).setValue(helperClass);
//                Toast.makeText(Register.this, "Signup successfully", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Register.this,Login.class);
//                startActivity(intent);
//            }
//        });
//
//        LoginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Register.this, Login.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//}


////////////////////////////////////////////////////////////////////////////////////


//  import android.content.Intent;
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Register extends AppCompatActivity {
//
//    FirebaseFirestore fstore;
//    String userID;
//    FirebaseAuth fAuth;
//    FirebaseUser firebaseUser;
//    FirebaseDatabase database;
//
//
//
//    public static final String TAG = "TAG";
//    EditText mFullname, mEmail, mPassword, mPhone;
//    Button mRegisterBtn;
//    TextView mLoginBtn;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        mFullname = findViewById(R.id.fullname);
//        mEmail = findViewById(R.id.email);
//        mPassword = findViewById(R.id.password);
//        mPhone = findViewById(R.id.phone);
//        mRegisterBtn = findViewById(R.id.registerbtn);
//        mLoginBtn = findViewById(R.id.createtext);
//
//        fAuth = FirebaseAuth.getInstance();
//        fstore = FirebaseFirestore.getInstance();
//
//        if (fAuth.getCurrentUser() != null) {
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            finish();
//        }
//
//        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//                 String email = mEmail.getText().toString().trim();
//                String password = mPassword.getText().toString().trim();
//                 String fullName = mFullname.getText().toString();
//                 String phone = mPhone.getText().toString();
//
//                if (TextUtils.isEmpty(fullName)) {
//
//                    mFullname.setError("Please enter your name...!!");
//                    return;
//                }
//
//                if (!fullName.matches("a-zA-Z+")) {
//
//                    mFullname.setError("Enter only Alphabetical Characters");
//                }
//
//
//                if (TextUtils.isEmpty(email)) {
//
//                    mEmail.setError("Email is Required");
//                    return;
//                }
//
//                if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+//.+[a-z]+")) {
//
//                    mEmail.setError("Enter Valid Email");
//                }
//
//                if (!phone.matches("[0-9]{10,13}$")) {
//
//                    mPhone.setError("Enter Correct Format");
//                }
//
//                if (TextUtils.isEmpty(password)) {
//                    mPassword.setError("Password is Required");
//                    return;
//                }
//
//                if (password.length() < 8) {
//                    mPassword.setError("Password must be >=8 characters");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(phone)) {
//                    mPhone.setError("Please enter your mobile number");
//                    return;
//                }
//
//
//                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//
//                        FirebaseUser fuser = fAuth.getCurrentUser();
//
//
//
//
//                        fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>(){
//                            @Override
//                            public void onSuccess(Void unused){
//                            Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show();
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                 Log.d(TAG, "OnFailure: Email Not Sent" + e.getMessage());
//                            }
//                        });
//                            Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
//                            userID = fAuth.getCurrentUser().getUid();
//                            DocumentReference documentReference = fstore.collection("user").document(userID);
//                            Map<String, Object> user = new HashMap<>();
//                            user.put("fName", fullName);
//                            user.put("email",email);
//                            user.put("phone",phone);
//                          documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//                                    Log.d(TAG, "onSuccess: user profile is created for " + userID);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Log.d(TAG, "onFailure: " + e.toString());
//                                }
//                            });
//
//
//
//                            startActivity(new Intent(getApplicationContext(), Login.class));
//
//
//
//
//                        }
//                        else{
//                            Toast.makeText(Register.this, "Error"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                        }
//                   }
//
//
//                });
//            }
//        });
//
//        mLoginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), Login.class));
//            }
//        });
//
//    }
//}
//
