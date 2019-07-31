package com.lcoa.ems.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lcoa.ems.ApplyLeave.Leave_status;
import com.lcoa.ems.Approve_leave;
import com.lcoa.ems.Leavepojo;
import com.lcoa.ems.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class LeavenotificationAdapter extends RecyclerView.Adapter<LeavenotificationAdapter.CourseViewHolder> {
    ArrayList<Leavepojo> mylist;
    public Context context;
    public LeavenotificationAdapter(ArrayList<Leavepojo> mylist, Context context)
    {
        this.context = context;
        this.mylist = mylist;
    }
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v= inflater.inflate(R.layout.leave_notification_task,parent,false);
        return new CourseViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Leavepojo leavepojo=mylist.get(position);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat ss = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String currentdate= ss.format(date);
      holder.textView.setText("  Leave Notification    " +currentdate);

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder{
TextView textView;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.myleavenot);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Leavepojo new_leave=mylist.get(getAdapterPosition());
                    Intent i= new Intent(context, Leave_status.class);
                    i.putExtra("LeaveFrom",new_leave.getDate1());
                    i.putExtra("LeaveTo",new_leave.getDate2());
                    i.putExtra("Reason",new_leave.getReason());
                    i.putExtra("Name",new_leave.getName());
                    i.putExtra("EmailId",new_leave.getEmailadd());
                    context.startActivity(i);
                }
            });
        }
    }
}
