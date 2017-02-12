package com.blackbirdsoft.movies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductionCountry {

    @Expose
    @SerializedName("iso_3166_1")
    private String iso31661;
    @Expose
    @SerializedName("name")

    private String name;

    public String getIso31661() {
        return iso31661;
    }

    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
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
        if (!(o instanceof ProductionCountry)) return false;

        ProductionCountry that = (ProductionCountry) o;

        if (getIso31661() != null ? !getIso31661().equals(that.getIso31661()) : that.getIso31661() != null)
            return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getIso31661() != null ? getIso31661().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}