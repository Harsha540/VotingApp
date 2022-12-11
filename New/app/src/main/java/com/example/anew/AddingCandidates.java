package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anew.databinding.ActivityAddingCandidatesBinding;
import com.example.anew.databinding.ActivityCandidatesBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class AddingCandidates extends DrawerBaseActivity {

    EditText candidateName, candidatePosition, candidatesDescription;
    DatabaseReference reference;
    FirebaseDatabase firebaseDatabase;
    Button addingCandidate;

    ActivityAddingCandidatesBinding activityAddingCandidatesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddingCandidatesBinding = ActivityAddingCandidatesBinding.inflate(getLayoutInflater());

        setContentView(activityAddingCandidatesBinding.getRoot());
        allocateActivityTitle("Adding Candidates");


            candidateName = findViewById(R.id.candidatesUsername);
            candidatePosition = findViewById(R.id.candidatesPosition);
            candidatesDescription = findViewById(R.id.candidatesDescription);

            addingCandidate = findViewById(R.id.submit);

            reference = FirebaseDatabase.getInstance().getReference().child("candidates");

        addingCandidate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
                 String candidatename_ = candidateName.getText().toString();
                 String candidateposition_ = candidatePosition.getText().toString();
                 String candidateDescription_ = candidatesDescription.getText().toString();

                 if (candidateName.getText().toString().isEmpty() || candidatePosition.getText().toString().isEmpty()
                         || candidatesDescription.getText().toString().isEmpty()) {
                     Toast.makeText(AddingCandidates.this, "Empty fields", Toast.LENGTH_SHORT).show();
                 }else{
                     firebaseDatabase = FirebaseDatabase.getInstance();
                     reference = FirebaseDatabase.getInstance().getReference("candidates");
                     String candidatename_get = candidateName.getText().toString();
                     String candidateposition_get = candidatePosition.getText().toString();
                     String candidatedesc_get = candidatesDescription.getText().toString();

                     Helper1Class helper1Class = new Helper1Class(candidatename_get, candidateposition_get, candidatedesc_get);

                     reference.child(candidatename_get).setValue(helper1Class);

                     Toast.makeText(AddingCandidates.this, "Candidate Added Successfully", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(getApplicationContext(), CandidatesActivity.class);
                     startActivity(intent);
                     finish();

                 }
             }
        });
    }
}