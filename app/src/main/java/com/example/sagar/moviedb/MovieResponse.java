package com.example.sagar.moviedb;

import java.util.ArrayList;

/**
 * Created by SAGAR on 25-03-2018.
 */

public class MovieResponse
{
    private ArrayList<Movie> results;

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }
}
