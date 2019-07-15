package com.lcoa.ems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lcoa.ems.adminFrags.adminhome;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class personalactivity extends AppCompatActivity {
EditText  Name,Mobileno, address, workexp;
Button savebtn;
TextView datejoin;
String emailgot;
List<Taskpojo> gotlist=new ArrayList<>();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalactivity);
        datejoin=findViewById(R.id.datejoining);
        savebtn=findViewById(R.id.savebutton);
        Name=findViewById(R.id.empname);
        Mobileno=findViewById(R.id.empmobile);
        address=findViewById(R.id.empaddress);
        workexp=findViewById(R.id.experience);

        firebaseDatabase=FirebaseDatabase.getInstance();

        databaseReference= FirebaseDatabase.getInstance().getReference("USERS");

        datejoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat ss = new SimpleDateFormat("dd-MM-yyyy");
                Date date = new Date();
                String currentdate= ss.format(date);
                TextView editText =  findViewById(R.id.datejoining);
                editText.setText(currentdate);
            }
        });


        //fetching data from the database
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot d:dataSnapshot.getChildren()){
                    gotlist.add(d.getValue(Taskpojo.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
       Intent i=getIntent();
       emailgot=i.getStringExtra("email");

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String empname = Name.getText().toString();
                String Mobilenum = Mobileno.getText().toString();
                String Empaddress = address.getText().toString();
                String Experience = workexp.getText().toString();
                String dateofjoining = datejoin.getText().toString();
                //!TextUtils.isEmpty(empname) && !TextUtils.isEmpty(Mobilenum) && !TextUtils.isEmpty(Empaddress) && !TextUtils.isEmpty(Experience) && !TextUtils.isEmpty(dateofjoining)
                if (!TextUtils.isEmpty(empname)) {
                    for (Taskpojo t : gotlist) {

                        if (t.getEmail().equals(emailgot)) {



                                    t.setAddi(new additional(empname,
                                            Mobilenum,
                                            Empaddress,
                                            Experience,
                                            dateofjoining));

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
                else {
                    Toast.makeText(getApplicationContext(),"enter your details",Toast.LENGTH_LONG).show();
                }
            }


        });


    }

}
