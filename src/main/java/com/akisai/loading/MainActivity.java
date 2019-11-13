package com.akisai.loading;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;

    ProgressBar SplashProgress;
    int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);

        SplashProgress = findViewById(R.id.SplashProgress);
        playProgress();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myintent = new Intent(MainActivity.this, ActivityHome.class);
                startActivity(myintent);
                finish();
            }
        }, SPLASH_TIME);
    }

        private void playProgress () {
            ObjectAnimator.ofInt(SplashProgress, "progress", 100)
                    .setDuration(3000)
                    .start();
        }
    }




