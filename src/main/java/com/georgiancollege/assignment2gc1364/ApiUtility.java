package com.georgiancollege.assignment2gc1364;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * ApiUtility class
 *
 * @author Ji Hee Rhou
 */
public class ApiUtility {
    /**
     * This method will parse JSON data from a file
     * and create objects without storing it to the hard drive
     * @param filename
     * @return ApiResponse
     */
    public static ApiResponse getDataFromFile(String filename){
        ApiResponse response = null;
        Gson gson = new Gson();

        // try with resources block
        try(
                FileReader fileReader = new FileReader(filename);
                JsonReader jsonReader = new JsonReader(fileReader);
        ){
            response = gson.fromJson(jsonReader, ApiResponse.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    /**
     * This method will do a http request like we did in browser
     * and create objects without storing it to the hard drive
     * @param cuisine
     * @param searchText
     * @return ApiResponse
     */
    public static ApiResponse getDataFromApi(String cuisine, String searchText){
        searchText = searchText.replace(" ", "%20");
        String uri = "https://api.spoonacular.com/recipes/complexSearch?apiKey=f7d9fe0cb6904472b306acfcdf25d7a5";

        // When user entered search text
        if (!searchText.equals("")){
            uri += "&query=" + searchText;
        }
        // When user selected cuisine
        if (!cuisine.equals("All")) {
            uri += "&cuisine=" + cuisine;
        }

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ApiResponse.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This method will parse JSON data from a file
     * and create objects without storing it to the hard drive
     * @param filename
     * @return Recipe
     */
    public static Recipe getRecipeFromFile(String filename){
        Recipe response = null;
        Gson gson = new Gson();

        // try with resources block
        try(
                FileReader fileReader = new FileReader(filename);
                JsonReader jsonReader = new JsonReader(fileReader);
        ){
            response = gson.fromJson(jsonReader, Recipe.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    /**
     * This method will do a http request like we did in browser
     * and create objects without storing it to the hard drive
     * @param id
     * @return Recipe
     */
    public static Recipe getRecipeFromApi(int id){
        String uri = String.format("https://api.spoonacular.com/recipes/%s/information?apiKey=f7d9fe0cb6904472b306acfcdf25d7a5", Integer.toString(id));

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), Recipe.class);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
