package com.lcoa.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminpersonal extends AppCompatActivity {
Button savebtn;
EditText email,password,mobile,company,name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpersonal);
        savebtn=findViewById(R.id.savebutton);
        email=findViewById(R.id.adminemail);
        String Email=email.getText().toString();
        password=findViewById(R.id.adminpassword);
        name=findViewById(R.id.adminname);
        mobile=findViewById(R.id.adminmobile);
        company=findViewById(R.id.nameofcompany);

final String Name=name.getText().toString();
final String Mobile= mobile.getText().toString();
final String Company= company.getText().toString();

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // (email.getText().toString().equals("rahulsharma6660357@gmail.com"))&& password.getText().toString().equals("rahulsharma")&& TextUtils.isEmpty(Name) && TextUtils.isEmpty(Mobile) && TextUtils.isEmpty(Company)
                if (TextUtils.isEmpty(Name)){
                    Toast.makeText(getApplicationContext(), "Login as admin", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(adminpersonal.this, adminhomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Check your details", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
