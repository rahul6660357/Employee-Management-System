package com.lcoa.ems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Approve_leave extends AppCompatActivity {
TextView Name, FromDate, ToDate, Reason;
Button Approve;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_leave);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();

        Name=findViewById(R.id.nameofemp);
        FromDate=findViewById(R.id.fromleave);
        ToDate=findViewById(R.id.toleave);
        Reason=findViewById(R.id.leavereason);
        Approve=findViewById(R.id.approvebutton);
        Intent i=getIntent();
        final String name=i.getStringExtra("Name");
        final String LeaveFrom=i.getStringExtra("LeaveFrom");
        final String LeaveTo=i.getStringExtra("LeaveTo");
        final String Reasons=i.getStringExtra("Reason");
        final String emailid=i.getStringExtra("EmailId");


        Name.setText(name);
        FromDate.setText(LeaveFrom);
        ToDate.setText(LeaveTo);
        Reason.setText(Reasons);



        Approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                databaseReference = firebaseDatabase.getReference("LEAVE");
                DatabaseReference newref=databaseReference.child(name);
                newref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                        {


                            if(dataSnapshot1.getKey().equals("status")) {
                                Toast.makeText(Approve_leave.this, "Approved", Toast.LENGTH_SHORT).show();
                                    String orderNumber =  dataSnapshot1.getValue().toString();

                               String orderNumber1="true";
                                Leavepojo leavepojo=new Leavepojo(LeaveFrom, LeaveTo,emailid,name,Reasons,orderNumber1);
                                databaseReference.child(name).setValue(leavepojo);
                                Intent i= new Intent(getApplicationContext(),notification.class);
                                startActivity(i);
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
