package com.lcoa.ems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.lcoa.ems.Forgetpassword.forgetpassword;

public class MainActivity extends AppCompatActivity {
Button login_button;
EditText user, pass;
TextView adminlogin, forgetpassword;
FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_button=findViewById(R.id.loginbtn);
        user=findViewById(R.id.myusername);
        pass=findViewById(R.id.mypassword);
        firebaseAuth=FirebaseAuth.getInstance();
        adminlogin=findViewById(R.id.loginadmin);
        forgetpassword=findViewById(R.id.forgetpass);
forgetpassword.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i= new Intent(MainActivity.this, com.lcoa.ems.Forgetpassword.forgetpassword.class);
        startActivity(i);
    }
});
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email=user.getText().toString();
                final String password= pass.getText().toString();

                if(!TextUtils.isEmpty(email)&& !TextUtils.isEmpty(password)) {
                    login();
                }
                else {
                    Toast.makeText(getApplicationContext(),"check your email address",Toast.LENGTH_LONG).show();
                }
            }
        });
        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(MainActivity.this,adminpersonal.class);
                startActivity(i);
            }
        });
    }

    public void login()
    {

        final String email=user.getText().toString();
        final String password= pass.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i= new Intent(MainActivity.this,personalactivity.class);
                            i.putExtra("email",user.getText().toString());

                            startActivity(i);


//                            Intent i2= new Intent(MainActivity.this, add_documents.class);
//                            i2.putExtra("email",user.getText().toString());
//
//                            startActivity(i2);


                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });

    }
}
