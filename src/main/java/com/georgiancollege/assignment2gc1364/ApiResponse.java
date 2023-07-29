package com.georgiancollege.assignment2gc1364;

import com.google.gson.annotations.SerializedName;

/**
 * ApiResponse class
 *
 * @author Ji Hee Rhou
 */
public class ApiResponse {
    @SerializedName("results")
    private Cuisine[] cuisines;

    private int totalResults;

    // getters
    public Cuisine[] getCuisines() {
        return cuisines;
    }

    public int getTotalResults() {
        return totalResults;
    }
}
