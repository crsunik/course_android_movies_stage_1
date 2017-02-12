package com.blackbirdsoft.movies;

import com.blackbirdsoft.movies.model.MovieDetails;
import com.blackbirdsoft.movies.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface TMDBService {
    @GET(TMDBApi.MOST_POPULAR_URL)
    Call<MovieList> popular(@Query("api_key") String apiKey, @Query("page") int page, @Query("language") String language);

    @GET(TMDBApi.TOP_RATED_URL)
    Call<MovieList> topRated(@Query("api_key") String apiKey, @Query("page") int page, @Query("language") String language);

    @GET(TMDBApi.MOVIE_DETAILS_URL)
    Call<MovieDetails> details(@Query("api_key") String apiKey, @Part("movie_id") Integer movieId, @Query("language") String language);
}