package com.dani2pix.recipr.ui.dashboard.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Domnica on 2/18/2017.
 */

public class TvShow {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("popularity")
    private float popularity;
    @SerializedName("id")
    private int id;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("overview")
    private String overview;
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("origin_country")
    private List<String> originCountry;
    @SerializedName("genres_ids")
    private List<Integer> genresIds;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("name")
    private String name;
    @SerializedName("original_name")
    private String originalName;

    public String getPosterPath() {
        return posterPath;
    }

    public float getPopularity() {
        return popularity;
    }

    public int getId() {
        return id;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public List<Integer> getGenresIds() {
        return genresIds;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }
}
