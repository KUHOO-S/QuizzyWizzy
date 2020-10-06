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
        String value1 = extras.getString("Value1");
        TextView textbox = (TextView) findViewById(R.id.txtbox);
        textbox.setText(value1);

    }
    public void quizFunction(View view)
    {
        Intent i = new Intent(getApplicationContext(), QuizFragment.class);
        startActivity(i);
    }
}