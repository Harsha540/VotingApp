package com.example.anew;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.anew.databinding.ActivityProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends DrawerBaseActivity {



   ActivityProfileBinding activityProfileBinding;
    FirebaseStorage storage;
    ImageView imageview;
    Button button;
    Uri imageUri;

    //Navigation image retrieval
//    private CircleImageView navheaderImage;
//    private TextView navheaderEmail, navheadername;
//    private NavigationView navigationView;
//    private DatabaseReference databaseReference;
//
//
//    private FirebaseAuth fAuth;
//    private FirebaseUser fUser;
//    private View header;

    //---


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityProfileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(activityProfileBinding.getRoot());
        allocateActivityTitle("Profile");

        imageview = findViewById(R.id.imageCamera);
        button = findViewById(R.id.buttonCamera);
        storage = FirebaseStorage.getInstance();



        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.launch("image/*");

            }


        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadImage();

            }
        });

        //NIR

//
//        navheaderEmail= navigationView.getHeaderView(0).findViewById(R.id.header_email);
//        navheadername= navigationView.getHeaderView(0).findViewById(R.id.header_fullname);
//        navheaderImage= navigationView.getHeaderView(0).findViewById(R.id.header_image);
//        databaseReference= FirebaseDatabase.getInstance().getReference().child("user").child(FirebaseAuth.getInstance())


//        header= navView.getHeaderView(0);
//
//        if(fUser!=null){
//            ImageView imageView= (ImageView) header.findViewById(R.id.header_image);
//            Picasso.get().load(fUser.getPhotoUrl()).placeholder(getDrawable(R.id.u)).into(imageView);
//            TextView username= (TextView) header.findViewById(R.id.header_fullname);
//            username.setText(fUser.getDisplayName());
//
//            TextView email= (TextView) header.findViewById(R.id.header_email);
//            email.setText(fUser.getEmail());
//        }


    }

    private void uploadImage() {

        if(imageUri != null){
            StorageReference reference = storage.getReference().child("images/" + UUID.randomUUID().toString());

            reference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(ProfileActivity.this, "Image Uploaded Successfully", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(ProfileActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    ActivityResultLauncher<String> image= registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri result) {

            if(result != null){

                imageview.setImageURI(result);

                imageUri = result;

            }

        }
    });

}


