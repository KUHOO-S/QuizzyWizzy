package com.example.quizzywizzy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Homeactivity extends AppCompatActivity implements MyAdapter.OnModelListener {
    ArrayList<Model> models = new ArrayList<>();

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, getMyList(),this);

        mRecyclerView.setAdapter(myAdapter);


    }
    ArrayList<String> urlList = new ArrayList<>();
    private ArrayList<Model> getMyList() {

        Model m = new Model();
        m.setTilte("Computer Science");
        m.setDescription("18BIT0143");
        m.setImg(R.drawable.saurabh);
        models.add(m);
        urlList.add("https://opentdb.com/api.php?amount=5&category=21&difficulty=easy&type=multiple");



        m = new Model();
        m.setTilte("Science");
        m.setDescription("18BIT0143");
        models.add(m);

        m = new Model();
        m.setTilte("Sagar");
        m.setDescription("18BIT0143");
        //m.setImg(R.drawable.sagar);
        models.add(m);

        m = new Model();
        m.setTilte("Tushar");
        m.setDescription("18BIT0143");
        //m.setImg(R.drawable.tushar);
        models.add(m);

        m = new Model();
        m.setTilte("Dog");
        m.setDescription("18BIT0143");
        //m.setImg(R.drawable.dog);
        models.add(m);


        return models;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public void OnModelClick(int position) {
        Toast.makeText(getApplicationContext(), " Quiz", Toast.LENGTH_LONG).show();

        Intent i = new Intent(getApplicationContext(), QuizActivity.class);

        i.putExtra("URL",urlList.get(position));

        startActivity(i);
    }
}


