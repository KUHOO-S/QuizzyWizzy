package com.example.quizzywizzy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.Request.Method.GET;

public class MainActivity extends AppCompatActivity {
    TextView txt1;
    JSONObject myObject=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(TextView)findViewById(R.id.txt1);


    }
    public void loginFunction(View view){

        Toast.makeText(getApplicationContext(),"Welcome", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
        //i.putExtra("Value1", "Android By Javatpoint");
        i.putExtra("Quiz", "Simple Tutorial");
        // Set the request code to any code you like, you can identify the
        // callback via this code
        startActivity(i);

    }
    public void registerFunction(View view){
        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);

    }


}