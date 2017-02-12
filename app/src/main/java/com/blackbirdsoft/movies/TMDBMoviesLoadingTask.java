package com.blackbirdsoft.movies;

import android.os.AsyncTask;
import android.util.Log;

import com.blackbirdsoft.movies.model.MovieList;

class TMDBMoviesLoadingTask extends AsyncTask<String, Void, MovieList> {

    private static final String TAG = TMDBMoviesLoadingTask.class.getName();

    interface LoadingTaskListener {

        void onPreExecute();

        void onPostExecute(MovieList movieList);

    }

    private final LoadingTaskListener mLoadingTaskListener;

    TMDBMoviesLoadingTask(LoadingTaskListener loadingTaskListener) {
        this.mLoadingTaskListener = loadingTaskListener;
    }

    @Override
    protected void onPreExecute() {
        if (mLoadingTaskListener != null)
            mLoadingTaskListener.onPreExecute();
    }

    @Override
    protected void onPostExecute(MovieList movieList) {
        if (mLoadingTaskListener != null)
            mLoadingTaskListener.onPostExecute(movieList);
    }

    @Override
    protected MovieList doInBackground(String... params) {
        String apiKey = params[0];
        String sorting = params[1];
        Log.d(TAG, "Loading with params: " + params[0] + ", " + params[1]);
        switch (sorting) {
            case TMDBApi.TOP_RATED_SORTING:
                return new TMDBApi(apiKey).topRated();
            default:
                return new TMDBApi(apiKey).popular();
        }
    }
}
