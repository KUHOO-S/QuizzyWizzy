package com.example.quizzywizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();
        int score = extras.getInt("Quiz");
        TextView results_percent=(TextView)findViewById(R.id.results_percent);
        results_percent.setText(String.valueOf(score));

    }
    public void goHome(View view)
    {
        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);

        startActivity(i);


    }
}