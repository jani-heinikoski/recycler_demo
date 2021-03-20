package com.lut.recyclerdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/* Source: https://developer.android.com/guide/topics/ui/layout/recyclerview */
public final class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MovieViewHolder> {
    private ArrayList<String> movieNames;

    // ViewHolder (i.e. view that contains views, used as recyclerview's items)
    // Can be basically any view, CardViews usually yield the best looking results though
    public static final class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView movieName;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movie_name);
        }
    }

    public MainRecyclerAdapter(@NonNull ArrayList<String> movieNames) {
        this.movieNames = movieNames;
    }
    // Inflates the ViewHolder using parent's LayoutInflater
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_relativelayout, parent, false);
        return new MovieViewHolder(view);
    }
    // Binds the ViewHolder with data
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        if (position != RecyclerView.NO_POSITION) {
            String mn = movieNames.get(position);
            holder.movieName.setText(mn);
        }
    }

    @Override
    public int getItemCount() {
        if (movieNames == null) {
            return 0;
        } else {
            return movieNames.size();
        }
    }
}
