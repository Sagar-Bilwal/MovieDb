package com.example.sagar.moviedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    MovieRecyclerAdapter movieRecyclerAdapter;
    ArrayList<Movie> Movies = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        movieRecyclerAdapter=new MovieRecyclerAdapter(this,Movies);
        progressBar=findViewById(R.id.progressbar);
        fetchMovies();
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    private void fetchMovies()
    {
        Call<MovieResponse> call=ApiClient.getInstance().getMovieDbAPI().getMovies() ;
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movies=response.body();
                progressBar.setVisibility(View.GONE);
                if(movies!=null) {
                    Movies.clear();
                    Movies.addAll(movies.getResults());
                    movieRecyclerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("error", t.getMessage());
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"No Connection",Toast.LENGTH_LONG);
            }
        });
    }
}
