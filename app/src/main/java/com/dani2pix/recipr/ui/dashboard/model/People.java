package com.dani2pix.recipr.ui.dashboard.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Domnica on 2/18/2017.
 */

public class People {
    @SerializedName("profile_path")
    private String profilePath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("id")
    private int id;
    @SerializedName("known_for")
    private List<KnownFor> knownFor;
    @SerializedName("name")
    private String name;
    @SerializedName("popularity")
    private float popularity;

    public String getProfilePath() {
        return profilePath;
    }

    public boolean isAdult() {
        return adult;
    }

    public int getId() {
        return id;
    }

    public List<KnownFor> getKnownFor() {
        return knownFor;
    }

    public String getName() {
        return name;
    }

    public float getPopularity() {
        return popularity;
    }
}
