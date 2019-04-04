package com.example.babyanaconda.ayedis_project;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OnBoard extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        viewPager = findViewById(R.id.viewPager);

        onboardAdapter adapter = new onboardAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
