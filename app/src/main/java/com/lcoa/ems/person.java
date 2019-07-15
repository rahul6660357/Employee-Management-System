package com.lcoa.ems;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.lcoa.ems.Forgetpassword.forgetpassword;


public class person extends Fragment {

    Button logout;
Button passwordchange;
TextView email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_person, container, false);


        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

FirebaseAuth firebaseAuth;
firebaseAuth=FirebaseAuth.getInstance();
email=getActivity().findViewById(R.id.emailaddress);
email.setText(firebaseAuth.getCurrentUser().getEmail());

        logout=getActivity().findViewById(R.id.logout1);
passwordchange=getActivity().findViewById(R.id.changepassword);
passwordchange.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i= new Intent(getActivity(), forgetpassword.class);
        startActivity(i);
   }
});
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(getActivity(),MainActivity.class);

                startActivity(intent);

            }
        });

    }
}
