package com.blackbirdsoft.movies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieList implements Parcelable {

    public static final Parcelable.Creator<MovieList> CREATOR = new Parcelable.Creator<MovieList>() {
        public MovieList createFromParcel(Parcel source) {
            return new MovieList(source);
        }

        public MovieList[] newArray(int size) {
            return new MovieList[size];
        }
    };

    @Expose
    @SerializedName("page")
    private Integer page;
    @Expose
    @SerializedName("results")
    private List<Movie> results = null;
    @Expose
    @SerializedName("total_results")
    private Integer totalResults;

    @Expose
    @SerializedName("total_pages")
    private Integer totalPages;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public MovieList() {
    }

    protected MovieList(Parcel in) {
        this.page = (Integer) in.readValue(Integer.class.getClassLoader());
        this.results = in.createTypedArrayList(Movie.CREATOR);
        this.totalResults = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalPages = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.page);
        dest.writeTypedList(results);
        dest.writeValue(this.totalResults);
        dest.writeValue(this.totalPages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieList movieList = (MovieList) o;

        if (page != null ? !page.equals(movieList.page) : movieList.page != null) return false;
        if (results != null ? !results.equals(movieList.results) : movieList.results != null)
            return false;
        if (totalResults != null ? !totalResults.equals(movieList.totalResults) : movieList.totalResults != null)
            return false;
        return totalPages != null ? totalPages.equals(movieList.totalPages) : movieList.totalPages == null;
    }

    @Override
    public int hashCode() {
        int result = page != null ? page.hashCode() : 0;
        result = 31 * result + (results != null ? results.hashCode() : 0);
        result = 31 * result + (totalResults != null ? totalResults.hashCode() : 0);
        result = 31 * result + (totalPages != null ? totalPages.hashCode() : 0);
        return result;
    }
}