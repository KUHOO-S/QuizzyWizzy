package com.example.quizzywizzy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    DatabaseReference r;
    int played,won;
    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle extras = getIntent().getExtras();
        txt1=(TextView)findViewById(R.id.played);
        txt2=(TextView)findViewById(R.id.won);
        Button btn2=(Button)findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        played = extras.getInt("played");
        won = extras.getInt("won");
        txt1.setText(String.valueOf(played));
        txt2.setText(String.valueOf(won));

        FirebaseAuth F = FirebaseAuth.getInstance();
        FirebaseUser u = F.getCurrentUser();
        String input=u.getEmail();
        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1 = input1.reverse();

        String name = input1.substring(10);
        StringBuilder input2 = new StringBuilder();

        input2.append(name);
        input2 = input2.reverse();

        txt3=(TextView)findViewById(R.id.textView5);
        txt3.setText(input2);
    }

    public void quizFunction(View view)
    {
        Intent i = new Intent(getApplicationContext(), SearchBarActivity.class);
        startActivity(i);
    }
}