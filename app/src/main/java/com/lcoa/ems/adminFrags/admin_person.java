package com.lcoa.ems.adminFrags;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.lcoa.ems.MainActivity;
import com.lcoa.ems.R;


public class admin_person extends Fragment {
    private static final int PICK_REQUEST=11;
Button updatephoto;
Button logoutAdmin;
  FirebaseAuth firebaseAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_person2, container, false);
        firebaseAuth=FirebaseAuth.getInstance();
        logoutAdmin=v.findViewById(R.id.logoutadmin);


        logoutAdmin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FirebaseAuth.getInstance().signOut();
            Intent intent= new Intent(getActivity(), MainActivity.class);

            startActivity(intent);

        }
        });

        updatephoto=container.findViewById(R.id.updatedp);
//             updatephoto.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              Intent intent= new Intent();
//              intent.setType("image/*");
//              intent.setAction(intent.ACTION_GET_CONTENT);
//           startActivityForResult(Intent.createChooser(intent,"select a image"),PICK_REQUEST);
//          }
//      });



       return v;
    }

}
