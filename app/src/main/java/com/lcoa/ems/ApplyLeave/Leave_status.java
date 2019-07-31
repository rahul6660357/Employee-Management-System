package com.lcoa.ems.ApplyLeave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lcoa.ems.Approve_leave;
import com.lcoa.ems.Leavepojo;
import com.lcoa.ems.R;

public class Leave_status extends AppCompatActivity {
TextView Date1, Date2, DecisionSTATUS;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_status);


        Date1=findViewById(R.id.fromdate);
        Date2=findViewById(R.id.todate);
        DecisionSTATUS=findViewById(R.id.decisionstatus);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();

        Intent i=getIntent();
        final String name=i.getStringExtra("Name");
        final String LeaveFrom=i.getStringExtra("LeaveFrom");
        final String LeaveTo=i.getStringExtra("LeaveTo");
        final String Reasons=i.getStringExtra("Reason");
        final String emailid=i.getStringExtra("EmailId");

        Date1.setText(LeaveFrom);
        Date2.setText(LeaveTo);



        databaseReference = firebaseDatabase.getReference("LEAVE");
        DatabaseReference newref=databaseReference.child(name);
        newref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {

                    if(dataSnapshot1.getKey().equals("status"));
                    {

                        String ordernumber=dataSnapshot1.getValue().toString();



                        if(ordernumber.equals("true"))
                    {

                        DecisionSTATUS.setText("approved");
                    }
                        else
                        {
                            DecisionSTATUS.setText("Pending");
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
