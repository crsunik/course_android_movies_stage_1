package com.blackbirdsoft.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackbirdsoft.movies.model.Movie;
import com.blackbirdsoft.movies.model.MovieList;

class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> implements MoviesLoadingListener {

    interface MovieListItemClickListener {
        void onMovieListItemClick(Movie movie);
    }

    private MovieListItemClickListener mOnClickListener;
    private MovieList mMovieList;

    public MoviesAdapter(MovieListItemClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override
    public void onMovieLoadingBegin() {
        this.mMovieList = null;
        notifyDataSetChanged();
    }

    @Override
    public void onMovieLoadingEnd(MovieList movieList) {
        this.mMovieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.movie_view, parent, false);
        return new MovieViewHolder(view, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(mMovieList.getResults().get(position));
    }

    @Override
    public int getItemCount() {
        return mMovieList == null || mMovieList.getResults() == null ? 0 : mMovieList.getResults().size();
    }
}
