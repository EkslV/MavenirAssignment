package com.test.mavenirassignment.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("data")
    private List<BaseArt> artList;

    public Data() {
    }

    public List<BaseArt> getArtList() {
        return artList;
    }

    public void setArtList(List<BaseArt> artList) {
        this.artList = artList;
    }
}
