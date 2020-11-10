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

import static java.lang.Thread.sleep;

public class ResultActivity extends AppCompatActivity {

    User myuser;
    DatabaseReference r;
    int played,lost,won,correctQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();

        correctQuestions=extras.getInt("correctQuestions") ;
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
        System.out.println(u.getEmail());

        String email =u.getEmail();
        String id=u.getUid();
        DatabaseReference r1 = FirebaseDatabase.getInstance().getReference().child("user").child(id);

        r1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                User dbuser = dataSnapshot.getValue(User.class);
                System.out.println(dbuser);
                System.out.println(dbuser.getEmail()+"hmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
                played= dbuser.getPlayed();
                lost= dbuser.getLost();
                won= dbuser.getWon();

                played+=1;
                if(correctQuestions>=3)
                    won+=1;
                else
                    lost+=1;

                System.out.println(played);
                System.out.println(lost);
                System.out.println(won);
                System.out.println("ghiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("ERORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");

            }
        });




    }
    public void goHome(View view)
    {


        FirebaseAuth F = FirebaseAuth.getInstance();
        FirebaseUser u = F.getCurrentUser();
        String email=u.getEmail();
        String id=u.getUid();
        DatabaseReference r1 = FirebaseDatabase.getInstance().getReference().child("user").child(id);


        myuser=new User();
        myuser.setEmail(email);

        myuser.setPlayed(played);
        myuser.setLost(lost);
        myuser.setWon(won);
        r1.setValue(myuser);

        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
        i.putExtra("played",played);
        i.putExtra("won",won);
        startActivity(i);


    }
}