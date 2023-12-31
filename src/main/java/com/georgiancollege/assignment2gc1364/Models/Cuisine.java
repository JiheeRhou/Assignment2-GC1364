package com.georgiancollege.assignment2gc1364.Models;

/**
 * Cuisine Model class
 *
 * @author Ji Hee Rhou
 */
public class Cuisine {
    private int id;

    private String title;

    private String image;

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

    @Override
    public String toString() {
        return title;
    }
}
