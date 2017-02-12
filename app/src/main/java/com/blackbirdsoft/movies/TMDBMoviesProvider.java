package com.blackbirdsoft.movies;

import android.content.Context;

import com.blackbirdsoft.movies.model.MovieList;
import com.blackbirdsoft.movies.preferences.MoviesPreferences;

import java.util.ArrayList;
import java.util.List;

class TMDBMoviesProvider implements TMDBMoviesLoadingTask.LoadingTaskListener {

    private final Context mContext;
    private final String mApiKey;
    private List<MoviesLoadingListener> mListeners;

    TMDBMoviesProvider(Context context, String apiKey) {
        this.mContext = context;
        this.mApiKey = apiKey;
        this.mListeners = new ArrayList<>();
    }

    void addMovieLoadingListener(MoviesLoadingListener loadingListener) {
        mListeners.add(loadingListener);
    }

    void loadMovies(MovieList movieList) {
        if (movieList == null) {
            new TMDBMoviesLoadingTask(this).execute(mApiKey, MoviesPreferences.getSorting(mContext));
        } else {
            onPostExecute(movieList);
        }
    }

    @Override
    public void onPreExecute() {
        for (MoviesLoadingListener listener : mListeners) {
            listener.onMovieLoadingBegin();
        }
    }

    @Override
    public void onPostExecute(MovieList movieList) {
        for (MoviesLoadingListener listener : mListeners) {
            listener.onMovieLoadingEnd(movieList);
        }
    }
}
