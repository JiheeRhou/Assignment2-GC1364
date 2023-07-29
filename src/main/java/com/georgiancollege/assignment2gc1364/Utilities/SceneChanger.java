package com.georgiancollege.assignment2gc1364.Utilities;

import com.georgiancollege.assignment2gc1364.Controllers.RecipeDetailsController;
import com.georgiancollege.assignment2gc1364.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Scene Changer class
 *
 * @author Ji Hee Rhou
 */
public class SceneChanger {

    /**
     * This is a method to change the scene
     * @param event
     * @param fxmlFile
     * @param id
     * @throws IOException
     */
    public static void changeScene(ActionEvent event, String fxmlFile, int id) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/" + fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        // When change the search recipe scene to recipe details scene with selected recipe id
        // Get the recipe details and display
        if(id > 0){
            RecipeDetailsController controller = fxmlLoader.getController();
            controller.displayRecipeDetails(id);
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
