package com.blackbirdsoft.movies;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.blackbirdsoft.movies.model.Movie;
import com.blackbirdsoft.movies.model.MovieList;

import java.io.IOException;
import java.util.Locale;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TMDBApi {

    private static final String TAG = TMDBApi.class.getName();

    public static final String TOP_RATED_SORTING = "TOP_RATED";
    public static final String MOST_POPULAR_SORTING = "MOST_POPULAR";

    public static final String BASE_URL = "http://api.themoviedb.org";
    public static final String MOST_POPULAR_URL = "/3/movie/popular";
    public static final String TOP_RATED_URL = "/3/movie/top_rated";
    public static final String POSTER_BASE_URL = "https://image.tmdb.org/t/p";
    public static final String POSTER_WIDTH_185 = "w185";
    public static final String POSTER_WIDTH_780 = "w780";
    public static final String MOVIE_DETAILS_URL = "/3/movie/{movie_id}";

    private final TMDBService mService;
    private final String mApiKey;

    public TMDBApi(String apiKey) {
        this.mApiKey = apiKey;
        Retrofit mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        this.mService = mRetrofit.create(TMDBService.class);
    }

    MovieList popular() {
        return popular(Locale.getDefault().toString(), 1);
    }

    MovieList popular(String language, int page) {
        Response<MovieList> response = null;
        try {
            response = mService.popular(mApiKey, page, language).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resolve("popular movies", response);
    }

    MovieList topRated() {
        return topRated(Locale.getDefault().toString(), 1);
    }

    MovieList topRated(String language, int page) {
        Response<MovieList> response = null;
        try {
            response = mService.topRated(mApiKey, page, language).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resolve("topRated movies", response);
    }

    private <T> T resolve(String operation, Response<T> response) {
        if (response == null) {
            Log.d(TAG, operation + " response is null");
            return null;
        }
        if (response.isSuccessful()) {
            return response.body();
        }
        Log.d(TAG, operation + " response is unsuccessful, error code: " + response.code());
        try {
            Log.d(TAG, operation + " response is unsuccessful, error body: " + response.errorBody().string());
        } catch (IOException e) {
            Log.d(TAG, operation + " response is unsuccessful, IOException: ");
            e.printStackTrace();
        }
        return null;
    }

    static String createPosterUrl(Movie movie) {
        return createImageUrl(POSTER_WIDTH_185, movie.getPosterPath());
    }

    static String createBackdropUrl(Movie movie) {
        return createImageUrl(POSTER_WIDTH_780, movie.getBackdropPath());
    }

    @Nullable
    private static String createImageUrl(String size, String path) {
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        return Uri.parse(POSTER_BASE_URL)
                .buildUpon()
                .appendPath(size)
                .appendPath(path)
                .build()
                .toString();
    }
}
