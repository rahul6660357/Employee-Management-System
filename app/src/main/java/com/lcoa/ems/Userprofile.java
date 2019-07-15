package com.lcoa.ems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Userprofile extends AppCompatActivity {
TextView name, email, mobileno;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
String str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();



        name=findViewById(R.id.nameofuser);
        email=findViewById(R.id.emailofuser);
        mobileno=findViewById(R.id.MobileNumber);
        Intent i=getIntent();
        str=i.getStringExtra("email");

        databaseReference=firebaseDatabase.getReference("USERS");
databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
{

    Taskpojo taskpojo=dataSnapshot1.getValue(Taskpojo.class);
   additional add = taskpojo.getAddi();

   add.setNumber(add.getNumber());

   mobileno.setText(add.getNumber());


   email.setText(str);
   name.setText(taskpojo.getUsername());

}


    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {




    }
});


    }
}
