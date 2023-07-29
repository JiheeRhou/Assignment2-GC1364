package com.georgiancollege.assignment2gc1364.Controllers;

import com.georgiancollege.assignment2gc1364.Utilities.ApiUtility;
import com.georgiancollege.assignment2gc1364.Models.Recipe;
import com.georgiancollege.assignment2gc1364.Utilities.SceneChanger;
import com.georgiancollege.assignment2gc1364.Models.Step;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * RecipeDetails Controller class
 *
 * @author Ji Hee Rhou
 */
public class RecipeDetailsController {

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<String> instructionListView;

    @FXML
    private Text ingredientsText;

    @FXML
    private Label titleLabel;

    @FXML
    private Label readyInLabel;

    @FXML
    private Label servingsLabel;

    /**
     * This is a method for the event when change the search recipe scene to recipe details scene with selected recipe id
     * @param recipeId
     */
    public void displayRecipeDetails(int recipeId) {
//        Recipe recipe = ApiUtility.getRecipeFromFile("C:\\GeorgianCollege\\Java\\Assignment2-GC1364\\apiResponse2.json");
        Recipe recipe = ApiUtility.getRecipeFromApi(recipeId);
        if (recipe != null) {
            // set the title on the titleLabel
            titleLabel.setText(recipe.getTitle());

            // set the image on the imageView
            // if there is no image set no image
            try {
                imageView.setImage(new Image(recipe.getImage()));
            } catch (Exception e) {
                imageView.setImage(new Image("https://static.wikia.nocookie.net/undead-unluck/images/2/22/No_Image_available.png/revision/latest?cb=20200119200005"));
            }

            // set ready in on the readyInLabel
            readyInLabel.setText(String.format("%d min.", recipe.getReadyInMinutes()));
            // set serving for on the servingsLabel
            servingsLabel.setText(String.format("for %d ppl", recipe.getServings()));

            // set ingredients on the ingredientsText
            ingredientsText.setText(recipe.getIngredients());

            // get steps
            Step steps[] = recipe.getInstructions()[0].getSteps();
            // set the steps on the instructionListView
            for(int i = 0; i < steps.length; i++) {
                instructionListView.getItems().add(steps[i].toString());
            }
        }
    }

    /**
     * This is a method for the event when the user click the 'Go Back' button
     * Change recipe details scene to the search recipe scene
     * @param event
     * @throws IOException
     */
    @FXML
    void goBackButton_Onclick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "search-recipe-view.fxml", -1);
    }

}
