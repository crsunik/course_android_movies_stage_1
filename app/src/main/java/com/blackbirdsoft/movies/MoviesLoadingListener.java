package com.blackbirdsoft.movies;

import com.blackbirdsoft.movies.model.MovieList;

public interface MoviesLoadingListener {
    void onMovieLoadingBegin();

    void onMovieLoadingEnd(MovieList movieList);
}
