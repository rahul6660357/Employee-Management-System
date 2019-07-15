package com.lcoa.ems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admin_assigning_work_to_emp extends AppCompatActivity {
    TextView textView;
    ImageView phonecall, messagesend, emailsent;


    Button btnrating, checkprofile, AssignWork;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_assigning_work_to_emp);
        Intent i = getIntent();
        textView = findViewById(R.id.myname);
        checkprofile = findViewById(R.id.checkprofile);
        AssignWork = findViewById(R.id.assignWork);
        phonecall = findViewById(R.id.phone);
        messagesend = findViewById(R.id.message);
        emailsent = findViewById(R.id.gmail);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        String username = i.getStringExtra("username");
        final String email=i.getStringExtra("email");
        textView.setText(username);


btnrating = findViewById(R.id.assignrating);
        btnrating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), giverating.class);
                startActivity(i);
            }
        });

        checkprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Userprofile.class);
                i.putExtra("email",email);
                startActivity(i);
            }
        });


        AssignWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Assignwork_by_admin_to_emp.class);
                startActivity(i);
            }
        });


        phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = firebaseDatabase.getReference("USERS");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                            Taskpojo taskpojo = dataSnapshot1.getValue(Taskpojo.class);
                            additional add = taskpojo.getAddi();

                            add.setNumber(add.getNumber());
                            Toast.makeText(admin_assigning_work_to_emp.this, ""+add.getNumber(), Toast.LENGTH_SHORT).show();
                            String str ="tel:"+ add.getNumber();

                            Intent i = new Intent(Intent.ACTION_CALL);
                            i.setData(Uri.parse(str));

                            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(admin_assigning_work_to_emp.this, new String[]{Manifest.permission.CALL_PHONE}, 10);

                            }
                            startActivity(i);
                        }
                    }
                    @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
        });
     }
});
messagesend.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        databaseReference = firebaseDatabase.getReference("USERS");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    Taskpojo taskpojo = dataSnapshot1.getValue(Taskpojo.class);
                    additional add = taskpojo.getAddi();

                    add.setNumber(add.getNumber());


                    if (checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(admin_assigning_work_to_emp.this, new String[]{Manifest.permission.SEND_SMS}, 10);
                    }
                    String str = add.getNumber();
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:" + str));
                    intent.putExtra("sms_body", "");
                    startActivity(intent);
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
