package com.lcoa.ems.Forgetpassword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.lcoa.ems.R;

public class forgetpassword extends AppCompatActivity {
EditText email;
Button resetbtn;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        email=findViewById(R.id.myemail);
        firebaseAuth=FirebaseAuth.getInstance();
        resetbtn=findViewById(R.id.resetpassword);




        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String MyEmail=email.getText().toString();
                firebaseAuth.sendPasswordResetEmail(MyEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            AlertDialog.Builder builder= new AlertDialog.Builder(forgetpassword.this);
                            builder.setTitle("Forget Password");
                            builder.setMessage("are you really want to change the password");
                            builder.setCancelable(false);
                            builder.setPositiveButton("Ok", null);

                            AlertDialog alertDialog=builder.create();
                            alertDialog.show();
                            Toast.makeText(forgetpassword.this,"Password is sent to your email address",Toast.LENGTH_LONG).show();


                        }
                        else{
                            Toast.makeText(getApplicationContext(),"please check your email address",Toast.LENGTH_LONG);
                            Toast.makeText(forgetpassword.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });

    }
}
