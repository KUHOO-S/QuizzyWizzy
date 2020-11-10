package com.example.quizzywizzy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    TextView txt1;
    EditText text1,text2;
    FirebaseAuth F;
    User myuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(TextView)findViewById(R.id.txt1);
        text1=(EditText)findViewById(R.id.emailtext);
        text2=(EditText)findViewById(R.id.passwordtext);
        F=FirebaseAuth.getInstance();
    }
    public void loginFunction(View view){

        String email=text1.getText().toString();
        String password=text2.getText().toString();

        F.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Welcome", Toast.LENGTH_LONG).show();
                    FirebaseUser u = F.getCurrentUser();
                    System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
                    String email=u.getEmail();


                    FirebaseAuth F = FirebaseAuth.getInstance();

                    String id=u.getUid();
                    DatabaseReference r1 = FirebaseDatabase.getInstance().getReference().child("user").child(id);


                    myuser=new User();
                    myuser.setEmail(email);

                    myuser.setPlayed(0);
                    myuser.setLost(0);
                    myuser.setWon(0);
                    r1.setValue(myuser);





                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                    i.putExtra("played",0);
                    i.putExtra("won",0);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"Incorrect Email or Password", Toast.LENGTH_LONG).show();
            }
        });


    }
    public void registerFunction(View view){
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);

    }


}