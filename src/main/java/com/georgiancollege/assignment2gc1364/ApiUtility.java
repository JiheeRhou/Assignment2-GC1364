package com.georgiancollege.assignment2gc1364;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtility {
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
    /*
    This method will do a http request like we did in browser
    and create objects without storing it to the hard drive
     */
    public static ApiResponse getDataFromApi(String cuisine, String searchText){
        searchText = searchText.replace(" ", "%20");
        String uri = "https://api.spoonacular.com/recipes/complexSearch?apiKey=f7d9fe0cb6904472b306acfcdf25d7a5";

        if (!searchText.equals("")){
            uri += "&query=" + searchText;
        }
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
}
