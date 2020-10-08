package com.example.quizzywizzy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import static com.android.volley.Request.Method.GET;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String URL="https://opentdb.com/api.php?amount=5&category=23&difficulty=easy&type=multiple";

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest =new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response){
                        Log.d("myTag", response.toString());

                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error){

                        Log.d("myTag", error.toString());
                    }
                }





        );
        requestQueue.add(objectRequest);






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