package com.blackbirdsoft.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackbirdsoft.movies.model.Movie;
import com.squareup.picasso.Picasso;


public class DetailsActivity extends AppCompatActivity {

    public static final String MOVIE_DETAILS = BuildConfig.APPLICATION_ID + ".movieDetails";

    private static final String TAG = DetailsActivity.class.getName();

    private Movie mMovie;
    private TextView mTitle;
    private TextView mOverview;
    private TextView mReleaseDate;
    private TextView mRating;
    private ImageView mPoster;
    private ImageView mBackdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        }
        mTitle = (TextView) findViewById(R.id.tv_details_title);
        mOverview = (TextView) findViewById(R.id.tv_details_overview);
        mReleaseDate = (TextView) findViewById(R.id.tv_details_release_date);
        mRating = (TextView) findViewById(R.id.tv_details_user_rating);
        mPoster = (ImageView) findViewById(R.id.iv_details_poster);
        mBackdrop = (ImageView) findViewById(R.id.iv_details_backdrop);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(MOVIE_DETAILS)) {
            mMovie = intent.getParcelableExtra(MOVIE_DETAILS);
        }

        if (mMovie != null) {
            loadMovie(mMovie);
        }
    }

    private void loadMovie(Movie movie) {
        mTitle.setText(movie.getOriginalTitle());
        mOverview.setText(movie.getOverview());
        mReleaseDate.setText(movie.getReleaseDate());
        mRating.setText(String.valueOf(movie.getVoteAverage()));
        if (movie.getPosterPath() != null) {
            Picasso.with(this)
                    .load(TMDBApi.createPosterUrl(movie))
                    .error(R.drawable.ic_link_error)
                    .placeholder(R.drawable.ic_photo)
                    .into(mPoster);
        }
        if (movie.getBackdropPath() != null) {
            Picasso.with(this)
                    .load(TMDBApi.createBackdropUrl(movie))
                    .error(R.drawable.ic_link_error)
                    .placeholder(R.drawable.ic_photo)
                    .into(mBackdrop);
        }
        setTitle(movie.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(MOVIE_DETAILS, mMovie);
    }
}
