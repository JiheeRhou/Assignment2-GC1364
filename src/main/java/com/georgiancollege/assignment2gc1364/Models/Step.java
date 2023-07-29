package com.georgiancollege.assignment2gc1364.Models;

/**
 * Step Model class
 *
 * @author Ji Hee Rhou
 */
public class Step {
    private int number;

    private String step;

    // getters
    public int getNumber() {
        return number;
    }

    public String getStep() {
        return step;
    }

    @Override
    public String toString() {
        return String.format("%d. %s", number, step);
    }
}
