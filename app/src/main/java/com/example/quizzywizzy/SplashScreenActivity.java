package com.example.quizzywizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread t =new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    sleep(5000);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
                catch (Exception e)
                {
                    e.printStackTrace();;
                }
            }
        });
        t.start();
    }
}