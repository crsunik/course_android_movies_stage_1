package com.blackbirdsoft.movies.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.blackbirdsoft.movies.TMDBApi.MOST_POPULAR_SORTING;

public class MoviesPreferences {
    private static final String SORTING = "sorting";

    public static void setSorting(Context context, String choice) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        pref.edit().putString(SORTING, choice).apply();
    }

    public static String getSorting(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(SORTING, MOST_POPULAR_SORTING);
    }
}
