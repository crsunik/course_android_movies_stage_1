package com.blackbirdsoft.movies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ProductionCompany {

    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("id")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductionCompany)) return false;

        ProductionCompany that = (ProductionCompany) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
            return false;
        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}