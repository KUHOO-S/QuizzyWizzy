package com.example.quizzywizzy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText txt1,txt2,txt3,txt4;
    Button btn;
    FirebaseAuth f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        f=FirebaseAuth.getInstance();
        txt1=(EditText)findViewById(R.id.txtname);
        txt2=(EditText)findViewById(R.id.txtemail);
        txt3=(EditText)findViewById(R.id.txtphone);
        txt4=(EditText)findViewById(R.id.txtpassword);
        btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=txt1.getText().toString();
                String email=txt2.getText().toString();
                String phone=txt3.getText().toString();
                String password=txt4.getText().toString();

            f.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(),"Registered", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"You made an error", Toast.LENGTH_LONG).show();

                }
            });

            }
        });
    }
}