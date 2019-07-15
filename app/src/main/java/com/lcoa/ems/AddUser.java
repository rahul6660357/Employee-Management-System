package com.lcoa.ems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lcoa.ems.adminFrags.adminhome;

public class AddUser extends AppCompatActivity {
EditText username, password, userid,email;
Button submit;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
FirebaseAuth firebaseAuth;
EditText designation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_add_user);
        userid=findViewById(R.id.userid);
        username=findViewById(R.id.username);
        email=findViewById(R.id.emailid);
        designation=findViewById(R.id.designation);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.submitbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserId = userid.getText().toString();
                String UserName= username.getText().toString();
                String Password=password.getText().toString();
                String Email=email.getText().toString();
                String designat=designation.getText().toString();
addemp(UserId,UserName,Password,Email,designat);
            }
        });

    }
    public void  addemp(final String userid, final String username, final String password, final String Email, final String design)
    {

        firebaseAuth.createUserWithEmailAndPassword(Email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"registered Successfully",Toast.LENGTH_LONG).show();
                          //  FirebaseUser user = firebaseAuth.getCurrentUser();

                            //on success
                            additional a=new additional();

                            Taskpojo mytask=new Taskpojo(userid,username,password,Email,design,a);
                            databaseReference.child("USERS").child(userid).setValue(mytask).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(AddUser.this, "User added", Toast.LENGTH_SHORT).show();
                                   Intent i= new Intent(AddUser.this, adminhome.class);
                                   i.putExtra("username",username);

                                    startActivity(i);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(AddUser.this,"error",Toast.LENGTH_LONG).show();
                                        }
                                    });

                        } else {


                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });

    }
}
