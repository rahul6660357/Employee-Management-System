package com.lcoa.ems.adminFrags;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lcoa.ems.Adapters.CourseAdapter;
import com.lcoa.ems.AddUser;
import com.lcoa.ems.R;
import com.lcoa.ems.Taskpojo;

import java.util.ArrayList;

public class adminhome extends Fragment {
    ArrayList<Taskpojo> alltask = new ArrayList<>();
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    EditText editTextSearch;
    RecyclerView r;
String str;
    FloatingActionButton button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

firebaseAuth=FirebaseAuth.getInstance();
        View v = inflater.inflate(R.layout.fragment_home2, container, false);
        r = v.findViewById(R.id.myrecyclerviewhome);

        r.setHasFixedSize(true);
        button = v.findViewById(R.id.myfabbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddUser.class);
                startActivity(i);

            }
        });
        Intent i=getActivity().getIntent();
        str=i.getStringExtra("useremail");
editTextSearch=v.findViewById(R.id.editTextSearch);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });


        final CourseAdapter myadapter = new CourseAdapter(alltask, getActivity());
        r.setLayoutManager(new LinearLayoutManager(getActivity()));
        r.setAdapter(myadapter);
        databaseReference = FirebaseDatabase.getInstance().getReference("USERS");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Taskpojo mytask = dataSnapshot1.getValue(Taskpojo.class);
                    alltask.add(mytask);
                    r.setHasFixedSize(true);
                }
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return v;
    }

    private void filter(String toString) {

        ArrayList<String> filterdNames = new ArrayList<>();

//        for (String s : ) {
//            if (s.toLowerCase().contains(toString.toLowerCase()))
//            {
//
//                filterdNames.add(s);
//
//           adapter.filterList(filterdNames);

   }
}
