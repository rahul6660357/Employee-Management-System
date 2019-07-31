package com.lcoa.ems.adminFrags;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lcoa.ems.Adapters.AttendanceAdapter;
import com.lcoa.ems.Adapters.LeaveAdapter;
import com.lcoa.ems.Attendance_fire_pojo;
import com.lcoa.ems.Leavepojo;
import com.lcoa.ems.R;

import java.util.ArrayList;


public class Attendance_emp extends Fragment {
    ArrayList<Attendance_fire_pojo> attendance_fire_pojos = new ArrayList<>();
    RecyclerView r;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_attendance_emp, container, false);
        firebaseAuth=FirebaseAuth.getInstance();

        r=v.findViewById(R.id.attendancerecycler);
        r.setHasFixedSize(true);


        final AttendanceAdapter myadapter1 = new AttendanceAdapter(attendance_fire_pojos, getActivity());
        r.setLayoutManager(new LinearLayoutManager(getActivity()));
        r.setAdapter(myadapter1);
        databaseReference= FirebaseDatabase.getInstance().getReference("Attendance");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                //  Attendance_fire_pojo add= dataSnapshot1.getValue(Attendance_fire_pojo.class);
                //  if(add.getStatus().equals("PRESENT"))
               //   {
                  //    attendance_fire_pojos.add(add);
                //  }

                }
                myadapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






        return v;
    }

}
