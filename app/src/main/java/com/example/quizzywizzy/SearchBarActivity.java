package com.example.quizzywizzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchBarActivity extends AppCompatActivity {
    SearchView quizSearch;
    ListView quizList;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    ArrayList<String> urlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);

        quizSearch=(SearchView)findViewById(R.id.searchView);
        quizList=(ListView)findViewById(R.id.listView);

        list=new ArrayList<String>();
        urlList=new ArrayList<String>();

        list.add("Sports");
        urlList.add("x");

        list.add("Mathematics");
        urlList.add("x");

        list.add("Video Games");
        urlList.add("x");

        list.add("Science & Environment");
        urlList.add("x");

        list.add("Video Games");
        urlList.add("x");

        list.add("History");
        urlList.add("https://opentdb.com/api.php?amount=5&category=23&difficulty=easy&type=multiple");

        list.add("Art");
        urlList.add("x");

        list.add("Animals");
        urlList.add("x");


        adapter= new ArrayAdapter<>(this,R.layout.searchtextcolor,list);
        quizList.setAdapter(adapter);

        quizSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.getFilter().filter(s);
                return false;
            }
        });
        quizList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

    public void onItemClick(AdapterView<?> l, View v, int position, long id){
                Toast.makeText(getApplicationContext(), "You clicked Item:"+ id + " at position:" + position, Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), QuizActivity.class);
                //i.putExtra("Value1", "Android By Javatpoint");
                i.putExtra("Quiz", list.get(position));
                i.putExtra("URL",urlList.get(position));
                // Set the request code to any code you like, you can identify the
                // callback via this code
                startActivity(i);


    }
    });
}
}