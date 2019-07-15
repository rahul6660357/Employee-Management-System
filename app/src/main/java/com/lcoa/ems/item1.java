package com.lcoa.ems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class item1 extends AppCompatActivity {
String str;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item1);
        Intent i=getIntent();
      str=  i.getStringExtra("useremail");
      textView=findViewById(R.id.empname);
      textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent i= new Intent(getApplicationContext(),Userprofile.class);
              i.putExtra("email",str);
              Toast.makeText(item1.this, str, Toast.LENGTH_SHORT).show();
              startActivity(i);
          }
      });




    }
}
