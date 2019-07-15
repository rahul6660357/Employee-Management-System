package com.lcoa.ems.AddDocuments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lcoa.ems.R;
import com.lcoa.ems.Taskpojo;
import com.lcoa.ems.additional;
import com.lcoa.ems.docspojo;
import com.lcoa.ems.personalactivity;
import com.lcoa.ems.useractivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class add_documents extends AppCompatActivity {
EditText Ugdetails,degreename, University, PassingYear, degreemarks;
Button submitbtn;
    private static final int PICK_REQUEST=10;
Button uploaddocs;

  FirebaseAuth firebaseAuth;

    List<Taskpojo> addDocs=new ArrayList<>();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_documents);
        Ugdetails=findViewById(R.id.ugdetails);
        degreename=findViewById(R.id.degreename);
        University= findViewById(R.id.University);
        PassingYear=findViewById(R.id.passingyear);
        degreemarks=findViewById(R.id.marks);
        uploaddocs=findViewById(R.id.uploaddocs);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference("USERS");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot d:dataSnapshot.getChildren()){
                    addDocs.add(d.getValue(Taskpojo.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

final String email=firebaseAuth.getCurrentUser().getEmail();
        submitbtn=findViewById(R.id.submit);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String UgDetails=Ugdetails.getText().toString();
                String DegreeName=degreename.getText().toString();
                String UniversityName=University.getText().toString();
                String Passingyear=PassingYear.getText().toString();
                String DegreeMarks=degreemarks.getText().toString();
               // !TextUtils.isEmpty(UgDetails) && !TextUtils.isEmpty(DegreeName) && !TextUtils.isEmpty(DegreeMarks) && !TextUtils.isEmpty(UniversityName) && !TextUtils.isEmpty(Passingyear)
                if( !TextUtils.isEmpty(UgDetails) )
                {
                    for (Taskpojo t : addDocs) {

                        if (t.getEmail().equals(email)) {
                            Toast.makeText(getApplicationContext(),email , Toast.LENGTH_SHORT).show();
//                            t.setAdd(new docspojo(UgDetails,
//                                    DegreeName,
//                                    UniversityName,
//                                    Passingyear,
//                                    DegreeMarks));

                            databaseReference.child(t.getUserid()).setValue(t).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    //Toast.makeText(personalactivity.this, "send data", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(getApplication(), useractivity.class);
                                    startActivity(i);

                                }
                            });
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Fill Your All Details ",Toast.LENGTH_LONG).show();
                }
            }
        });
        uploaddocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
