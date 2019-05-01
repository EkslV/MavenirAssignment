package com.test.mavenirassignment.models;

import java.util.List;

public class Movie extends BaseArt {
    private List<String> actors;

    public Movie() {
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }
}
