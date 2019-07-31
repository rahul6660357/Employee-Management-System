package com.lcoa.ems.Send_Gmail_by_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lcoa.ems.R;

import static android.provider.CalendarContract.CalendarCache.URI;

public class Send_Mail extends AppCompatActivity {
EditText Message;
Button SendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__mail);

        Message=findViewById(R.id.gmailmsg);
        SendButton=findViewById(R.id.sendgmail);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendemail();

            }
        });


    }
    public  void  sendemail()
    {
        try {
            Intent it=getIntent();
            String EmailId=it.getStringExtra("Email");

            String Messagegmail = Message.getText().toString();
            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] {EmailId });
//            if (URI != null) {
//                emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
//            }
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,Messagegmail);
            this.startActivity(Intent.createChooser(emailIntent,"Sending email..."));
            Toast.makeText(Send_Mail.this, "Sending email...", Toast.LENGTH_SHORT).show();
        }
        catch(Throwable t)
        {

        }
    }
}
