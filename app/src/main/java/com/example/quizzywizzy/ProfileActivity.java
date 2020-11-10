package com.example.quizzywizzy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    User myuser;
    DatabaseReference r;
    int played,lost,won;
TextView txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle extras = getIntent().getExtras();
        txt1=(TextView)findViewById(R.id.played);
        txt2=(TextView)findViewById(R.id.won);

        played = extras.getInt("played");
        won = extras.getInt("won");


        txt1.setText(played);
        txt2.setText(won);
    }

    public void quizFunction(View view)
    {
        Intent i = new Intent(getApplicationContext(), SearchBarActivity.class);
        i.putExtra("Quiz", "Simple Tutorial");
        startActivity(i);
    }
}