package com.akvelon.yuriydubov.models;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("id")
    private String id;

    @SerializedName("abbreviation")
    private String abbreviation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}