package com.example.quizzywizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    TextView quiz_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("Quiz");
        quiz_title=(TextView)findViewById(R.id.quiz_title);

        quiz_title.setText(value1);
    }
}