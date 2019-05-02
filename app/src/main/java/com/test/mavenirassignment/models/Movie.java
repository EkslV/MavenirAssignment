package com.test.mavenirassignment.models;

import com.google.gson.annotations.SerializedName;

public class Movie extends BaseArt {
    @SerializedName("Actors")
    private String actors;

    public Movie() {
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
