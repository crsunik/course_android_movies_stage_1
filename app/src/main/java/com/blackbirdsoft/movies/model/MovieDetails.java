package com.blackbirdsoft.movies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetails {

    @Expose
    @SerializedName("adult")
    private Boolean adult;
    @Expose
    @SerializedName("backdrop_path")
    private String backdropPath;
    @Expose
    @SerializedName("belongs_to_collection")
    private BelongsToCollection belongsToCollection;
    @Expose
    @SerializedName("budget")
    private Integer budget;
    @Expose
    @SerializedName("genres")
    private List<Genre> genres = null;
    @Expose
    @SerializedName("homepage")
    private String homepage;
    @Expose
    @SerializedName("id")
    private Integer id;
    @Expose
    @SerializedName("imdb_id")
    private String imdbId;
    @Expose
    @SerializedName("original_language")
    private String originalLanguage;
    @Expose
    @SerializedName("original_title")
    private String originalTitle;
    @Expose
    @SerializedName("overview")
    private String overview;
    @Expose
    @SerializedName("popularity")
    private Double popularity;
    @Expose
    @SerializedName("poster_path")
    private String posterPath;
    @Expose
    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies = null;
    @Expose
    @SerializedName("production_countries")
    private List<ProductionCountry> productionCountries = null;
    @Expose
    @SerializedName("release_date")
    private String releaseDate;
    @Expose
    @SerializedName("revenue")
    private Integer revenue;
    @Expose
    @SerializedName("runtime")
    private Integer runtime;
    @Expose
    @SerializedName("spoken_languages")
    private List<Language> languages = null;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("tagline")
    private String tagline;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("video")
    private Boolean video;
    @Expose
    @SerializedName("vote_average")
    private Double voteAverage;
    @Expose
    @SerializedName("vote_count")
    private Integer voteCount;

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(BelongsToCollection belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDetails)) return false;

        MovieDetails that = (MovieDetails) o;

        if (getAdult() != null ? !getAdult().equals(that.getAdult()) : that.getAdult() != null)
            return false;
        if (getBackdropPath() != null ? !getBackdropPath().equals(that.getBackdropPath()) : that.getBackdropPath() != null)
            return false;
        if (getBelongsToCollection() != null ? !getBelongsToCollection().equals(that.getBelongsToCollection()) : that.getBelongsToCollection() != null)
            return false;
        if (getBudget() != null ? !getBudget().equals(that.getBudget()) : that.getBudget() != null)
            return false;
        if (getGenres() != null ? !getGenres().equals(that.getGenres()) : that.getGenres() != null)
            return false;
        if (getHomepage() != null ? !getHomepage().equals(that.getHomepage()) : that.getHomepage() != null)
            return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getImdbId() != null ? !getImdbId().equals(that.getImdbId()) : that.getImdbId() != null)
            return false;
        if (getOriginalLanguage() != null ? !getOriginalLanguage().equals(that.getOriginalLanguage()) : that.getOriginalLanguage() != null)
            return false;
        if (getOriginalTitle() != null ? !getOriginalTitle().equals(that.getOriginalTitle()) : that.getOriginalTitle() != null)
            return false;
        if (getOverview() != null ? !getOverview().equals(that.getOverview()) : that.getOverview() != null)
            return false;
        if (getPopularity() != null ? !getPopularity().equals(that.getPopularity()) : that.getPopularity() != null)
            return false;
        if (getPosterPath() != null ? !getPosterPath().equals(that.getPosterPath()) : that.getPosterPath() != null)
            return false;
        if (getProductionCompanies() != null ? !getProductionCompanies().equals(that.getProductionCompanies()) : that.getProductionCompanies() != null)
            return false;
        if (getProductionCountries() != null ? !getProductionCountries().equals(that.getProductionCountries()) : that.getProductionCountries() != null)
            return false;
        if (getReleaseDate() != null ? !getReleaseDate().equals(that.getReleaseDate()) : that.getReleaseDate() != null)
            return false;
        if (getRevenue() != null ? !getRevenue().equals(that.getRevenue()) : that.getRevenue() != null)
            return false;
        if (getRuntime() != null ? !getRuntime().equals(that.getRuntime()) : that.getRuntime() != null)
            return false;
        if (getLanguages() != null ? !getLanguages().equals(that.getLanguages()) : that.getLanguages() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null)
            return false;
        if (getTagline() != null ? !getTagline().equals(that.getTagline()) : that.getTagline() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null)
            return false;
        if (getVideo() != null ? !getVideo().equals(that.getVideo()) : that.getVideo() != null)
            return false;
        if (getVoteAverage() != null ? !getVoteAverage().equals(that.getVoteAverage()) : that.getVoteAverage() != null)
            return false;
        return getVoteCount() != null ? getVoteCount().equals(that.getVoteCount()) : that.getVoteCount() == null;
    }

    @Override
    public int hashCode() {
        int result = getAdult() != null ? getAdult().hashCode() : 0;
        result = 31 * result + (getBackdropPath() != null ? getBackdropPath().hashCode() : 0);
        result = 31 * result + (getBelongsToCollection() != null ? getBelongsToCollection().hashCode() : 0);
        result = 31 * result + (getBudget() != null ? getBudget().hashCode() : 0);
        result = 31 * result + (getGenres() != null ? getGenres().hashCode() : 0);
        result = 31 * result + (getHomepage() != null ? getHomepage().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getImdbId() != null ? getImdbId().hashCode() : 0);
        result = 31 * result + (getOriginalLanguage() != null ? getOriginalLanguage().hashCode() : 0);
        result = 31 * result + (getOriginalTitle() != null ? getOriginalTitle().hashCode() : 0);
        result = 31 * result + (getOverview() != null ? getOverview().hashCode() : 0);
        result = 31 * result + (getPopularity() != null ? getPopularity().hashCode() : 0);
        result = 31 * result + (getPosterPath() != null ? getPosterPath().hashCode() : 0);
        result = 31 * result + (getProductionCompanies() != null ? getProductionCompanies().hashCode() : 0);
        result = 31 * result + (getProductionCountries() != null ? getProductionCountries().hashCode() : 0);
        result = 31 * result + (getReleaseDate() != null ? getReleaseDate().hashCode() : 0);
        result = 31 * result + (getRevenue() != null ? getRevenue().hashCode() : 0);
        result = 31 * result + (getRuntime() != null ? getRuntime().hashCode() : 0);
        result = 31 * result + (getLanguages() != null ? getLanguages().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getTagline() != null ? getTagline().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getVideo() != null ? getVideo().hashCode() : 0);
        result = 31 * result + (getVoteAverage() != null ? getVoteAverage().hashCode() : 0);
        result = 31 * result + (getVoteCount() != null ? getVoteCount().hashCode() : 0);
        return result;
    }
}