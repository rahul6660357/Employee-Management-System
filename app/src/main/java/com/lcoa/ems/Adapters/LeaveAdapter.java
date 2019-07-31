package com.lcoa.ems.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lcoa.ems.Approve_leave;
import com.lcoa.ems.Leavepojo;
import com.lcoa.ems.R;

import java.util.ArrayList;

public class LeaveAdapter extends RecyclerView.Adapter<LeaveAdapter.CourseViewHolder> {
    ArrayList<Leavepojo> mylist;
    public Context context;
    public LeaveAdapter(ArrayList<Leavepojo> mylist, Context context)
    {
        this.context = context;
        this.mylist = mylist;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v= inflater.inflate(R.layout.task_leave,parent,false);
        return new CourseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
Leavepojo leavepojo=mylist.get(position);
holder.Name.setText("   "+leavepojo.getName());

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public  class CourseViewHolder extends RecyclerView.ViewHolder {
TextView Name;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.Empname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Leavepojo new_leave=mylist.get(getAdapterPosition());
                    Intent i= new Intent(context, Approve_leave.class);
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
