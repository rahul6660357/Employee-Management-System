package com.lcoa.ems.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lcoa.ems.AddUser;
import com.lcoa.ems.R;
import com.lcoa.ems.Taskpojo;
import com.lcoa.ems.admin_assigning_work_to_emp;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{
    ArrayList<Taskpojo> mylist;
    public Context context;
        public CourseAdapter(ArrayList<Taskpojo> mylist, Context context)
        {
            this.context = context;
            this.mylist = mylist;
        }

    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.activity_item1,parent,false);
        return new CourseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Taskpojo mytask = mylist.get(position);
        holder.name.setText(mytask.getUsername());
        holder.id.setText(mytask.getUserid());


    }

    @Override
    public int getItemCount() {

        return mylist.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder{
TextView name,id;
        public CourseViewHolder(@NonNull View itemview) {
            super(itemview);
            name=itemview.findViewById(R.id.empname);
            id=itemview.findViewById(R.id.empid);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Taskpojo new_task = mylist.get(getAdapterPosition());
                    Intent i = new Intent(context, admin_assigning_work_to_emp.class);
                    i.putExtra("userid",new_task.getUserid());
                    i.putExtra("username",new_task.getUsername());
                    i.putExtra("password",new_task.getPassword());
                    i.putExtra("email",new_task.getEmail());


                    context.startActivity(i);
                }
            });






        }
    }
}
