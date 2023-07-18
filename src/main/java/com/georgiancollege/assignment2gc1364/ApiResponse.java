package com.georgiancollege.assignment2gc1364;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("results")
    private Cuisine[] cuisines;

    private int totalResults;

    public Cuisine[] getCuisines() {
        return cuisines;
    }

    public int getTotalResults() {
        return totalResults;
    }
}
