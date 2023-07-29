package com.georgiancollege.assignment2gc1364.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Ingredient Model class
 *
 * @author Ji Hee Rhou
 */
public class Ingredient {
    @SerializedName("name")
    private String ingredient;

    // getters
    public String getIngredient() {
        return ingredient;
    }
}
