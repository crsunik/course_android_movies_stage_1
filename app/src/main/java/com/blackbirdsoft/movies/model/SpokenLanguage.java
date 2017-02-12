package com.blackbirdsoft.movies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpokenLanguage {

    @SerializedName("iso_639_1")
    @Expose
    private String iso6391;
    @SerializedName("name")
    @Expose
    private String name;

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpokenLanguage)) return false;

        SpokenLanguage that = (SpokenLanguage) o;

        if (getIso6391() != null ? !getIso6391().equals(that.getIso6391()) : that.getIso6391() != null)
            return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = getIso6391() != null ? getIso6391().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}