package com.blackbirdsoft.movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.blackbirdsoft.movies.model.Movie;
import com.squareup.picasso.Picasso;

class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView mPosterImageView;
    private MoviesAdapter.MovieListItemClickListener mOnClickListener;
    private Movie mMovie;

    MovieViewHolder(View itemView, MoviesAdapter.MovieListItemClickListener onClickListener) {
        super(itemView);
        mPosterImageView = (ImageView) itemView.findViewById(R.id.iv_movie_poster);
        mOnClickListener = onClickListener;
        itemView.setOnClickListener(this);
    }

    void bind(Movie movie) {
        this.mMovie = movie;
        Picasso.with(mPosterImageView.getContext())
                .load(TMDBApi.createPosterUrl(movie))
                .error(R.drawable.ic_link_error)
                .placeholder(R.drawable.ic_photo)
                .into(mPosterImageView);
    }

    @Override
    public void onClick(View v) {
        mOnClickListener.onMovieListItemClick(mMovie);
    }
}
