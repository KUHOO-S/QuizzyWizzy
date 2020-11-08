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

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    TextView txt1;
    JSONObject myObject=null;
    EditText text1,text2;
    Button button;
    FirebaseAuth F;


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
                    System.out.println(u.getEmail());
                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
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