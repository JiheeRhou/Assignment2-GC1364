package com.georgiancollege.assignment2gc1364;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class
 *
 * @author Ji Hee Rhou
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/search-recipe-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Search Recipes!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}