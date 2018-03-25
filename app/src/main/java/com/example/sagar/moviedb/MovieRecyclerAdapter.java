package com.example.sagar.moviedb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by SAGAR on 25-03-2018.
 */



public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder>
{
    ArrayList<Movie> movies;
    Context context;
    MovieRecyclerAdapter(Context context,ArrayList<Movie> movies)
    {
        this.movies=movies;
        this.context=context;
    }
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.row_movie,parent,false);
        MovieViewHolder viewHolder=new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieRecyclerAdapter.MovieViewHolder holder, int position)
    {
        Movie movie=movies.get(position);
        holder.overview.setText(movie.getOverview());
        holder.title.setText(movie.getTitle());
        holder.vote_average.setText(movie.getVote_average()+"");
        Picasso.get().load("http://image.tmdb.org/t/p/original"+movie.getPoster_path()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder
    {
        View itemView;
        ImageView poster;
        TextView vote_average;
        TextView title;
        TextView overview;
        public MovieViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            poster=itemView.findViewById(R.id.poster);
            vote_average=itemView.findViewById(R.id.vote_average);
            title=itemView.findViewById(R.id.title);
            overview =itemView.findViewById(R.id.overview);
        }
    }
}
