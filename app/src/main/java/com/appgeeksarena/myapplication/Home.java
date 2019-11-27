package com.appgeeksarena.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.appgeeksarena.myapplication.fragments.HomeFrag;
import com.appgeeksarena.myapplication.fragments.TutorialsFrag;
import com.appgeeksarena.myapplication.fragments.VideosFrag;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        showFragment(new HomeFrag());
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(new HomeFrag());
                    getSupportActionBar().setTitle("Home");
                    return true;
                case R.id.navigation_tutorial:
                    showFragment(new TutorialsFrag());
                    getSupportActionBar().setTitle("Tutorials");
                    return true;
                case R.id.navigation_videos:
                    getSupportActionBar().setTitle("Videos");
                    showFragment(new VideosFrag());
                    return true;
            }
            return false;
        }
    };

    public void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_home, fragment);
        fragmentTransaction.commit();
    }
}
