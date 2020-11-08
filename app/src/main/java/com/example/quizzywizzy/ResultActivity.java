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

        int correctQuestions=extras.getInt("correctQuestions") ;
        int wrongQuestions=extras.getInt("wrongQuestions") ;
        int missedQuestions=extras.getInt("missedQuestions") ;


        TextView results_percent=(TextView)findViewById(R.id.results_percent);
        results_percent.setText(String.valueOf(correctQuestions));

        TextView val1=(TextView)findViewById(R.id.correctQuestions);
        val1.setText(String.valueOf(correctQuestions));

        TextView val2=(TextView)findViewById(R.id.wrongQuestions);
        val2.setText(String.valueOf(wrongQuestions));

        TextView val3=(TextView)findViewById(R.id.missedQuestions);
        val3.setText(String.valueOf(missedQuestions));



    }
    public void goHome(View view)
    {
        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);

        startActivity(i);


    }
}