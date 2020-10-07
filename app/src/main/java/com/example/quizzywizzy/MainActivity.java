package com.example.quizzywizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void loginFunction(View view){

        Toast.makeText(getApplicationContext(),"hey", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
        //i.putExtra("Value1", "Android By Javatpoint");
        i.putExtra("Quiz", "Simple Tutorial");
        // Set the request code to any code you like, you can identify the
        // callback via this code
        startActivity(i);

    }
    public void registerFunction(View view){
        Intent i = new Intent(getApplicationContext(), SearchBarActivity.class);
        startActivity(i);

    }
}