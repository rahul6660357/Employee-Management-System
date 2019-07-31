package com.lcoa.ems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WORK_HAS_TO_BE_COMPLETED extends AppCompatActivity {
TextView textView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button CompleteWork;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work__has__to__be__completed);
        textView=findViewById(R.id.myworkgivenbyadmin);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();

CompleteWork=findViewById(R.id.workcompleted);
        databaseReference = firebaseDatabase.getReference("WORK_ASSIGN");
        SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("sharedpref",0);
        // String name=sharedPreferences.getString("EmailADDRESS","default");
        final String EMPID=sharedPreferences.getString("Employ","default");
        DatabaseReference newref=databaseReference.child(EMPID);
        newref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {

                    if(dataSnapshot1.getKey().equals("woRKASS")) {
                        String orderNumber = dataSnapshot1.getValue().toString();

                        textView.setText(orderNumber);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

CompleteWork.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        databaseReference = firebaseDatabase.getReference("WORK_ASSIGN");
        SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("sharedpref",0);
        final  String Emailid=sharedPreferences.getString("Email","default");
        final String EMPID=sharedPreferences.getString("Employ","default");
        DatabaseReference newref=databaseReference.child(EMPID);
        newref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {

                    if(dataSnapshot1.getKey().equals("status")) {
                        String orderNumber = dataSnapshot1.getValue().toString();
                        String work="";
                           orderNumber="completed";
                           EMP_ASSIGN_WORK_POJO emp= new EMP_ASSIGN_WORK_POJO(Emailid,EMPID,work,orderNumber);
                           databaseReference.child(EMPID).setValue(emp);



                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
});
    }
}
