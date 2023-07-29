package com.georgiancollege.assignment2gc1364.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Recipe Model class
 *
 * @author Ji Hee Rhou
 */
public class Recipe {
    private int id;

    private String title;

    private String image;

    private int readyInMinutes;

    private int servings;

    @SerializedName("extendedIngredients")
    private Ingredient[] ingredients;

    @SerializedName("analyzedInstructions")
    private Instruction[] instructions;

    // getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public int getServings() {
        return servings;
    }

    public String getIngredients() {
        String ingredient = "";

        // concatenate ingredients with comma
        for (int i = 0; i < ingredients.length; i++) {
            ingredient += ingredients[i].getIngredient();
            if (i < ingredients.length-1) ingredient += ", ";
        }

        return ingredient;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }
}
