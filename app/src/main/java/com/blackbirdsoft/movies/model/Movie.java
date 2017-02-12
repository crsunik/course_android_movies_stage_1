package com.blackbirdsoft.movies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Expose
    @SerializedName("poster_path")
    private String posterPath;
    @Expose
    @SerializedName("adult")
    private Boolean adult;
    @Expose
    @SerializedName("overview")
    private String overview;
    @Expose
    @SerializedName("release_date")
    private String releaseDate;
    @Expose
    @SerializedName("genre_ids")
    private List<Integer> genreIds = null;
    @Expose
    @SerializedName("id")
    private Integer id;
    @Expose
    @SerializedName("original_title")
    private String originalTitle;
    @Expose
    @SerializedName("original_language")
    private String originalLanguage;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("backdrop_path")
    private String backdropPath;
    @Expose
    @SerializedName("popularity")
    private Double popularity;
    @Expose
    @SerializedName("vote_count")
    private Integer voteCount;
    @Expose
    @SerializedName("video")
    private Boolean video;
    @Expose
    @SerializedName("vote_average")
    private Double voteAverage;

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }


    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.posterPath = in.readString();
        this.adult = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.genreIds = new ArrayList<>();
        in.readList(this.genreIds, List.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.originalTitle = in.readString();
        this.originalLanguage = in.readString();
        this.title = in.readString();
        this.backdropPath = in.readString();
        this.popularity = (Double) in.readValue(Double.class.getClassLoader());
        this.voteCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.video = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.voteAverage = (Double) in.readValue(Double.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.posterPath);
        dest.writeValue(this.adult);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeList(this.genreIds);
        dest.writeValue(this.id);
        dest.writeString(this.originalTitle);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.title);
        dest.writeString(this.backdropPath);
        dest.writeValue(this.popularity);
        dest.writeValue(this.voteCount);
        dest.writeValue(this.video);
        dest.writeValue(this.voteAverage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (posterPath != null ? !posterPath.equals(movie.posterPath) : movie.posterPath != null)
            return false;
        if (adult != null ? !adult.equals(movie.adult) : movie.adult != null) return false;
        if (overview != null ? !overview.equals(movie.overview) : movie.overview != null)
            return false;
        if (releaseDate != null ? !releaseDate.equals(movie.releaseDate) : movie.releaseDate != null)
            return false;
        if (genreIds != null ? !genreIds.equals(movie.genreIds) : movie.genreIds != null)
            return false;
        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (originalTitle != null ? !originalTitle.equals(movie.originalTitle) : movie.originalTitle != null)
            return false;
        if (originalLanguage != null ? !originalLanguage.equals(movie.originalLanguage) : movie.originalLanguage != null)
            return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (backdropPath != null ? !backdropPath.equals(movie.backdropPath) : movie.backdropPath != null)
            return false;
        if (popularity != null ? !popularity.equals(movie.popularity) : movie.popularity != null)
            return false;
        if (voteCount != null ? !voteCount.equals(movie.voteCount) : movie.voteCount != null)
            return false;
        if (video != null ? !video.equals(movie.video) : movie.video != null) return false;
        return voteAverage != null ? voteAverage.equals(movie.voteAverage) : movie.voteAverage == null;

    }

    @Override
    public int hashCode() {
        int result = posterPath != null ? posterPath.hashCode() : 0;
        result = 31 * result + (adult != null ? adult.hashCode() : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (genreIds != null ? genreIds.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (originalTitle != null ? originalTitle.hashCode() : 0);
        result = 31 * result + (originalLanguage != null ? originalLanguage.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (backdropPath != null ? backdropPath.hashCode() : 0);
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        result = 31 * result + (voteAverage != null ? voteAverage.hashCode() : 0);
        return result;
    }
}
