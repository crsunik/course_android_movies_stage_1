package com.blackbirdsoft.movies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BelongsToCollection {

    @Expose
    @SerializedName("id")
    private Integer id;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("poster_path")
    private String posterPath;
    @Expose
    @SerializedName("backdrop_path")
    private Object backdropPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Object getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(Object backdropPath) {
        this.backdropPath = backdropPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelongsToCollection)) return false;

        BelongsToCollection that = (BelongsToCollection) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
            return false;
        if (getPosterPath() != null ? !getPosterPath().equals(that.getPosterPath()) : that.getPosterPath() != null)
            return false;
        return getBackdropPath() != null ? getBackdropPath().equals(that.getBackdropPath()) : that.getBackdropPath() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPosterPath() != null ? getPosterPath().hashCode() : 0);
        result = 31 * result + (getBackdropPath() != null ? getBackdropPath().hashCode() : 0);
        return result;
    }

}