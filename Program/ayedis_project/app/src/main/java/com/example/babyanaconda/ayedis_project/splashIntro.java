package com.example.babyanaconda.ayedis_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class splashIntro extends AppCompatActivity implements View.OnClickListener{

    private Button tempLoginButton;
    private Button tempSignupButton;
    ImageView imageWelcome;

    final int durationConstant = 2000;
    final int delayConstant = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_intro);

        tempLoginButton = findViewById(R.id.loginButton);
        tempSignupButton = findViewById(R.id.signupButton);

        tempLoginButton.setOnClickListener(this);
        tempSignupButton.setOnClickListener(this);

        imageWelcome = (ImageView) findViewById(R.id.imageWelcome);

        imageWelcome.animate().alpha(0).setDuration(durationConstant).setStartDelay(delayConstant);
        //buttonsLS.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(600);
    }

    @Override
    public void onClick(View v) {
        Intent intentSplashIntro = null;
        if(v.getId() == R.id.loginButton)
        {
            intentSplashIntro = new Intent(this, login.class);
        }
        else
        {
            intentSplashIntro = new Intent(this, signup.class);
        }

        startActivity(intentSplashIntro);
    }

}
