package com.lcoa.ems.ApplyLeave;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.lcoa.ems.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ApplyLeave extends AppCompatActivity {
TextView fromdate, todate;
private Calendar mycalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_leave);


mycalender=Calendar.getInstance();
        fromdate=findViewById(R.id.datefrom);
        todate=findViewById(R.id.todate);

        final DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                mycalender.set(Calendar.YEAR,i);
                mycalender.set(Calendar.MONTH,i1);
                mycalender.set(Calendar.DAY_OF_MONTH,i2);
                updatetable();
                updatetable1();
            }
        };



        fromdate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    new DatePickerDialog(ApplyLeave.this,date,mycalender.get(Calendar.YEAR),mycalender.get(Calendar.MONTH),mycalender.get(Calendar.DAY_OF_MONTH)).show();
                }


                return false;
            }
        });


        todate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    new DatePickerDialog(ApplyLeave.this,date,mycalender.get(Calendar.YEAR),mycalender.get(Calendar.MONTH),mycalender.get(Calendar.DAY_OF_MONTH)).show();
                }


                return false;
            }
        });
    }

    private void updatetable1() {

        String myformat="MM/dd/yy";
        SimpleDateFormat sdf=new SimpleDateFormat(myformat, Locale.US);


        todate.setText(sdf.format(mycalender.getTime()));

    }

    private void updatetable() {
        String myformat="MM/dd/yy";
        SimpleDateFormat sdf=new SimpleDateFormat(myformat, Locale.US);

            fromdate.setText(sdf.format(mycalender.getTime()));



    }
}
