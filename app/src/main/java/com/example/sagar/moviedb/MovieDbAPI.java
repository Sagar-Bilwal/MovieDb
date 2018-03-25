package com.example.sagar.moviedb;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SAGAR on 25-03-2018.
 */

public interface MovieDbAPI
{
    final String API_Key="d7736b944015d9ad77241f6761abe09a";
    @GET("/3/movie/popular?api_key=d7736b944015d9ad77241f6761abe09a")
    Call<MovieResponse> getMovies();
}
