package com.blackbirdsoft.movies;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blackbirdsoft.movies.model.Movie;
import com.blackbirdsoft.movies.model.MovieList;
import com.blackbirdsoft.movies.preferences.MoviesPreferences;

import static com.blackbirdsoft.movies.TMDBApi.MOST_POPULAR_SORTING;
import static com.blackbirdsoft.movies.TMDBApi.TOP_RATED_SORTING;

public class MoviesActivity extends AppCompatActivity implements MoviesAdapter.MovieListItemClickListener, MoviesLoadingListener {

    public static final String MOVIE_LIST = BuildConfig.APPLICATION_ID + ".movieList";

    private static final String TAG = MoviesActivity.class.getName();

    private TMDBMoviesProvider mMoviesProvider;
    private LayoutManager mMoviesLayoutManager;
    private RecyclerView mMoviesRecyclerView;
    private RecyclerView.Adapter mMoviesAdapter;
    private TextView mErrorMsg;
    private ProgressBar mLoadingProgressBar;
    private MovieList mMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        mMoviesProvider = createProvider();
        mMoviesLayoutManager = createLayoutManager();
        mMoviesAdapter = createAdapter();
        mMoviesRecyclerView = createView();
        mErrorMsg = (TextView) findViewById(R.id.tv_error_messsage);
        mLoadingProgressBar = (ProgressBar) findViewById(R.id.pb_movies_loading);
        restore(savedInstanceState);
    }

    private void restore(Bundle state) {
        mMoviesProvider.loadMovies(state == null ? null : (MovieList) state.getParcelable(MOVIE_LIST));
    }

    @NonNull
    private TMDBMoviesProvider createProvider() {
        TMDBMoviesProvider movieProvider = new TMDBMoviesProvider(this, BuildConfig.TMDB_API_KEY);
        movieProvider.addMovieLoadingListener(this);
        return movieProvider;
    }

    @NonNull
    private LayoutManager createLayoutManager() {
        return new GridLayoutManager(MoviesActivity.this, 2);
    }

    @NonNull
    private RecyclerView.Adapter createAdapter() {
        MoviesAdapter adapter = new MoviesAdapter(this);
        mMoviesProvider.addMovieLoadingListener(adapter);
        return adapter;
    }

    @NonNull
    private RecyclerView createView() {
        updateTitle(MoviesPreferences.getSorting(this));
        RecyclerView moviesRecyclerView = (RecyclerView) findViewById(R.id.rc_movie_list);
        moviesRecyclerView.setHasFixedSize(true);
        moviesRecyclerView.setLayoutManager(mMoviesLayoutManager);
        moviesRecyclerView.setAdapter(mMoviesAdapter);
        return moviesRecyclerView;
    }

    private void updateTitle(String sorting) {
        setTitle(MOST_POPULAR_SORTING.equals(sorting) ? R.string.most_popular : R.string.top_rated);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (R.id.action_show_most_popular == itemId) {
            MoviesPreferences.setSorting(this, MOST_POPULAR_SORTING);
            mMoviesProvider.loadMovies(null);
            updateTitle(MOST_POPULAR_SORTING);
            return true;
        } else if (R.id.action_show_top_rated == itemId) {
            MoviesPreferences.setSorting(this, TOP_RATED_SORTING);
            mMoviesProvider.loadMovies(null);
            updateTitle(TOP_RATED_SORTING);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onMovieListItemClick(Movie movie) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.MOVIE_DETAILS, movie);
        startActivity(intent);
    }

    boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onMovieLoadingBegin() {
        showLoading();
    }

    private void showLoading() {
        mMoviesRecyclerView.setVisibility(View.INVISIBLE);
        mErrorMsg.setVisibility(View.INVISIBLE);
        mLoadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onMovieLoadingEnd(MovieList movieList) {
        if (movieList == null) {
            Log.d(TAG, "got empty result response");
            showError(isNetworkAvailable() ? R.string.error_no_results : R.string.error_no_connection);
        } else {
            Log.d(TAG, "got response with " + movieList.getResults().size() + " movies");
            showMovies();
        }
        mMovieList = movieList;
    }

    private void showError(int msgId) {
        mMoviesRecyclerView.setVisibility(View.INVISIBLE);
        mLoadingProgressBar.setVisibility(View.INVISIBLE);
        mErrorMsg.setText(msgId);
        mErrorMsg.setVisibility(View.VISIBLE);
    }

    private void showMovies() {
        mErrorMsg.setVisibility(View.INVISIBLE);
        mLoadingProgressBar.setVisibility(View.INVISIBLE);
        mMoviesRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(MOVIE_LIST, mMovieList);
    }

}
