package com.lcoa.ems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Check_Attendance extends AppCompatActivity {
TextView textView;
DatabaseReference databaseReference;
FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__attendance);
        textView=findViewById(R.id.attendancestatus);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();

databaseReference=firebaseDatabase.getReference("Attendance");
        SharedPreferences sharedPreferences= getApplicationContext().getSharedPreferences("sharedpref",0);
        final String EMPID=sharedPreferences.getString("Employ","default");

        DatabaseReference newref=databaseReference.child(EMPID);
        newref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {

                    if(dataSnapshot1.getKey().equals("location")) {
                        String orderNumber = dataSnapshot1.getValue().toString();

                        if (orderNumber.equals("16, Mahal Rd, Mustafabad, Vidhyadhar Nagar, Sin Ka Barah, Jagatpura, Jaipur, Rajasthan 302029, India,Jaipur,Rajasthan,India,302029"))
                        {
                            textView.setText("PRESENT");
                        }
                        else
                        {
                            Toast.makeText(Check_Attendance.this, "in else", Toast.LENGTH_SHORT).show();
                            textView.setText("ABSENT");
                        }
                    }



                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
