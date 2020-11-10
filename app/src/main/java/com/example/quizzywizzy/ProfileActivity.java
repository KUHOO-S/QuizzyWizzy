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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle extras = getIntent().getExtras();
  TextView txt1=(TextView)findViewById(R.id.played);
  TextView txt2=(TextView)findViewById(R.id.won);

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
                System.out.println(played);
                System.out.println(lost);
                System.out.println(won);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



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