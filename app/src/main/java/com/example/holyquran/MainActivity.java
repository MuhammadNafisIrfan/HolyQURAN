package com.example.holyquran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.holyquran.fragment.FragmentAlquran;
import com.example.holyquran.fragment.FragmentHome;
import com.example.holyquran.fragment.FragmentSholat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout frame;
    BottomNavigationView bottomNavigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame = findViewById(R.id.frame);
        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new FragmentHome());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment !=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame , fragment)
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment f = null;

        switch (menuItem.getItemId()){
            case R.id.Sholat:
                f = new FragmentSholat();
                break;

            case R.id.Quran:
                f = new FragmentAlquran();
                break;

            case R.id.Home:
                f = new FragmentHome();
                break;


        }

        return loadFragment(f);

    }
}
