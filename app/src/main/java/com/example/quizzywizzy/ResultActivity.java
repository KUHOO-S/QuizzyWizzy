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

import java.util.EventListener;

public class ResultActivity extends AppCompatActivity {

    User myuser;
    DatabaseReference r;
    int played,lost,won;

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


        r= FirebaseDatabase.getInstance().getReference().child("user");

        FirebaseAuth F = FirebaseAuth.getInstance();
        FirebaseUser u = F.getCurrentUser();
        System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        System.out.println(u.getEmail());
        String email =u.getEmail();
        String id=u.getUid();
        DatabaseReference r1 = FirebaseDatabase.getInstance().getReference().child("user").child(id);

        r1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                played= Integer.parseInt( dataSnapshot.child("played").getValue().toString());
                lost= Integer.parseInt( dataSnapshot.child("lost").getValue().toString());
                won= Integer.parseInt(dataSnapshot.child("won").getValue().toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        myuser=new User();
        myuser.setEmail(email);

        myuser.setPlayed(played+1);
        myuser.setLost(lost);
        myuser.setWon(won);
        r.child(id).setValue(myuser);

    }
    public void goHome(View view)
    {
        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);

        startActivity(i);


    }
}