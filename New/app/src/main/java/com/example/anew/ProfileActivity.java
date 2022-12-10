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
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.anew.databinding.ActivityProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
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

    EditText profileFullname, profileEmail, profileMobile;
    String nameUser, emailUser, mobileUser;

    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityProfileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(activityProfileBinding.getRoot());
        allocateActivityTitle("Profile");

        reference = FirebaseDatabase.getInstance().getReference("users");

         profileFullname = findViewById(R.id.profileUsername);
         profileEmail = findViewById(R.id.profileEmail);
         profileMobile = findViewById(R.id.profileMobile);

         showUserData();



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



    }

    public  void showUserData(){

        Intent intent = getIntent();
         nameUser = intent.getStringExtra("name");
         emailUser = intent.getStringExtra("email");
         mobileUser = intent.getStringExtra("phone");

        profileFullname.setText(nameUser);
        profileEmail.setText(emailUser);
        profileMobile.setText(mobileUser);

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


    //For Update the user data in profile Activity

//    public void Update_Button(View view) {
//        if(nameChange() || mobileChange()){
//
//            Toast.makeText(this, "Updated Details Successfully", Toast.LENGTH_SHORT).show();
//
//        }else{
//
//            Toast.makeText(this, "You never made any changes", Toast.LENGTH_SHORT).show();
//
//        }
//    }
//
//
//
//    private boolean mobileChange() {
//
//        if (!mobileUser.equals(profileMobile.getText().toString())) {
//            reference.child(mobileUser).child("phone").setValue(profileMobile.getText().toString());
//            mobileUser = profileMobile.getText().toString();
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    private boolean nameChange() {
//
//        if(!nameUser.equals(profileFullname.getText().toString())){
//            reference.child(nameUser).child("name").setValue(profileFullname.getText().toString());
//            nameUser = profileFullname.getText().toString();
//
//            return true;
//        }else{
//            return false;
//        }
//    }
}


