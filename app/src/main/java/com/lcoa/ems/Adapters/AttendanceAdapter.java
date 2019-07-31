package com.lcoa.ems.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lcoa.ems.Attendance_fire_pojo;
import com.lcoa.ems.R;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.CourseViewHolder> {
    ArrayList<Attendance_fire_pojo> mylist;
    public Context context;
    public AttendanceAdapter(ArrayList<Attendance_fire_pojo> mylist, Context context)
    {
        this.context = context;
        this.mylist = mylist;
    }
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v= inflater.inflate(R.layout.attendance_task_xml,parent,false);
        return new CourseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Attendance_fire_pojo attend= mylist.get(position);
        holder.Empname.setText("   "+attend.getUserid());
        holder.AttendanceStatus.setText(attend.getStatus());

    }


    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder
    {
TextView Empname, AttendanceStatus;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            Empname=itemView.findViewById(R.id.Empname);
            AttendanceStatus=itemView.findViewById(R.id.status);

        }
    }
}
