package com.example.quizzywizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    TextView quiz_title;
    JSONObject myObject=null;
    int n=0;            //variable for next question
    String APIResponse;
    int numberOfQuestions=5;

    int correctQuestions=0;
    int wrongQuestions=0;
    int missedQuestions=0;
    int optionSelected;
    String answer="null";
    //Button quiz_option_one=(Button)findViewById(R.id.quiz_option_one);
    //quiz_option_one.setOnClickListener(this);
   QuestionSet data;
   Button selected;
    Button quiz_option_one;
    Button quiz_option_two;
    Button quiz_option_three;
    Button quiz_option_four;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("Quiz");
        String URL = extras.getString("URL");

        quiz_title = (TextView) findViewById(R.id.quiz_title);
        quiz_title.setText(value1);

        quiz_option_one=(Button)findViewById(R.id.quiz_option_one);
        quiz_option_two=(Button)findViewById(R.id.quiz_option_two);
        quiz_option_three=(Button)findViewById(R.id.quiz_option_three);
        quiz_option_four=(Button)findViewById(R.id.quiz_option_four);

        callRequest(URL);
        //loadQuestion();
        // Intent i = new Intent(getApplicationContext(), ResultActivity.class);
        //startActivity(i);

    }

    public void callRequest(String URL){

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest =new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response){
                        Log.d("myTag", response.toString());
                        APIResponse=response.toString();
                        //data= new Gson().fromJson(APIResponse,QuestionSet.class);

                        loadQuestion();
                        //loadData(response.toString(),n);
                        //JSONObject myObject = null;
                        try {
                            myObject = new JSONObject(response.toString());

                            Log.d("myTag", myObject.getString("results"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

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

    public void loadQuestion(){
        int defaultColorValue = Color.parseColor("#454545");
        quiz_option_one.setBackgroundColor(defaultColorValue);
        quiz_option_two.setBackgroundColor(defaultColorValue);
        quiz_option_three.setBackgroundColor(defaultColorValue);
        quiz_option_four.setBackgroundColor(defaultColorValue);

        data= new Gson().fromJson(APIResponse,QuestionSet.class);

        Log.d("myTag",data.results[n].question);

        TextView quiz_question = (TextView) findViewById(R.id.quiz_question);
        quiz_question.setText(data.results[n].question);

        TextView quiz_question_number = (TextView) findViewById(R.id.quiz_question_number);
        quiz_question_number.setText(String.valueOf(n+1));



        quiz_option_one.setText(data.results[n].incorrect_answers[0]);
        quiz_option_one.setOnClickListener(this);

        quiz_option_two.setText(data.results[n].incorrect_answers[1]);
        quiz_option_two.setOnClickListener(this);

        quiz_option_three.setText(data.results[n].incorrect_answers[2]);
        quiz_option_three.setOnClickListener(this);

        quiz_option_four.setText(data.results[n].correct_answer);
        quiz_option_four.setOnClickListener(this);

    }

    public void nextQuestion(View view) {



            //Calculate marks

            Button selected=(Button)findViewById(optionSelected);
            answer=selected.getText().toString();
            System.out.println(data.results[n].correct_answer);
            System.out.println(answer);
            if(answer.equals(data.results[n].correct_answer)) {

                correctQuestions += 1;
                //Toast.makeText(getApplicationContext(), "hey", Toast.LENGTH_LONG).show();
            }
            else if(answer.equals("null"))
            {
                missedQuestions+=1;
            }
            else
            {
                wrongQuestions+=1;
            }



        if (n <numberOfQuestions-1)
        {
            n=n+1;
            answer="null";
            loadQuestion();


        }
        else
        {
            Intent i = new Intent(getApplicationContext(), ResultActivity.class);
            i.putExtra("correctQuestions",correctQuestions) ;
            i.putExtra("wrongQuestions",wrongQuestions) ;
            i.putExtra("missedQuestions",missedQuestions) ;
            startActivity(i);

        }
    }


    @Override
    public void onClick(View v) {

        selected=(Button)findViewById(v.getId());
        int defaultColorValue = Color.parseColor("#2D2D2E");
        quiz_option_one.setBackgroundColor(defaultColorValue);
        quiz_option_two.setBackgroundColor(defaultColorValue);
        quiz_option_three.setBackgroundColor(defaultColorValue);
        quiz_option_four.setBackgroundColor(defaultColorValue);

        int selectedColorValue = Color.parseColor("#ED85FF");
        selected.setBackgroundColor(selectedColorValue);


        optionSelected=v.getId();


        String answer=selected.getText().toString();

    }
}