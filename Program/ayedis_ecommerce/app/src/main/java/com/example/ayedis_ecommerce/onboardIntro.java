package com.example.ayedis_ecommerce;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class onboardIntro extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard_intro);

        viewPager = findViewById(R.id.viewPager);

        onboardIntroAdapter adapter = new onboardIntroAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
