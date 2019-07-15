package com.lcoa.ems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lcoa.ems.adminFrags.admin_notification;
import com.lcoa.ems.adminFrags.admin_person;
import com.lcoa.ems.adminFrags.admin_search;
import com.lcoa.ems.adminFrags.adminhome;

public class adminhomeActivity extends AppCompatActivity {




    private boolean Loadfrag(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout2, fragment).commit();
            return true;
        }
        return false;

    }
        private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home2:

                        fragment = new adminhome();
                        break;
                    case R.id.search2:

                        fragment = new admin_search();
                        break;

                    case R.id.notification2:

                        fragment = new admin_notification();
                        break;
                    case R.id.person2:

                        fragment = new admin_person();
                        break;

                }
                return Loadfrag(fragment);
            }
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);

        BottomNavigationView navView = findViewById(R.id.nav_view2);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Loadfrag(new adminhome());
    }
}
