package com.lcoa.ems;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.lcoa.ems.ApplyLeave.ApplyLeave;
import com.lcoa.ems.RatingEmp.emp_rating_activity;


public class home extends Fragment {
Button applyLeave;
Button  rating;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        applyLeave=view.findViewById(R.id.applyleave);

rating=view.findViewById(R.id.ratingemp);
rating.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i= new Intent(getActivity(), emp_rating_activity.class);
        startActivity(i);
    }
});
applyLeave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(getActivity(), ApplyLeave.class));
    }
});



      return view;
    }

}
