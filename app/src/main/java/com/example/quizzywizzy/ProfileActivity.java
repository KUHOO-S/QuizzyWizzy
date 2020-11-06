package com.example.quizzywizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle extras = getIntent().getExtras();


    }
    public void quizFunction(View view)
    {
        Intent i = new Intent(getApplicationContext(), SearchBarActivity.class);
        i.putExtra("Quiz", "Simple Tutorial");
        startActivity(i);
    }
}