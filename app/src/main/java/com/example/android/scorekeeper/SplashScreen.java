package com.example.android.scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        SplashScreen();



    }


    private void SplashScreen()
    {
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent in = new Intent(SplashScreen.this,MainActivity.class);

                startActivity(in);

                finish();

            }
        }, 2500);


    }

}



