package com.georgiancollege.assignment2gc1364.Controllers;

import com.georgiancollege.assignment2gc1364.Models.ApiResponse;
import com.georgiancollege.assignment2gc1364.Utilities.ApiUtility;
import com.georgiancollege.assignment2gc1364.Models.Cuisine;
import com.georgiancollege.assignment2gc1364.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * SearchRecipe Controller class
 *
 * @author Ji Hee Rhou
 */
public class SearchRecipeController implements Initializable {

    @FXML
    private ImageView cuisineImageView;

    @FXML
    private ListView<Cuisine> cuisineListView;

    @FXML
    private ComboBox<String> cuisineComboBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label titleLabel;

    @FXML
    private Button getDetailsButton;

    @FXML
    private Label errorLabel;

    /**
     * This is a method to initialize the scene
     * get the data from the api and display the scene
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // getDetailsButton set not visible
        getDetailsButton.setVisible(false);
        // titleLabel set not visible
        titleLabel.setVisible(false);
        // errorLabel set not visible
        errorLabel.setVisible(false);
        // cuisineImageView set not visible
        cuisineImageView.setVisible(false);
        // set cuisineComboBox items
        cuisineComboBox.getItems().addAll("All", "African", "Asian", "American", "British", "Cajun", "Caribbean", "Chinese", "Eastern European", "European", "French", "German", "Greek", "Indian", "Irish", "Italian", "Japanese", "Jewish", "Korean", "Latin American", "Mediterranean", "Mexican", "Middle Eastern", "Nordic", "Southern", "Spanish", "Thai", "Vietnamese");
        cuisineComboBox.setValue("All");
        // add Listener
        cuisineListView.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldCuisine, newCuisine) -> {
            // cuisineImageView set visible
            cuisineImageView.setVisible(true);

            try {
                // getDetailsButton set visible
                getDetailsButton.setVisible(true);
                // titleLabel set not visible
                titleLabel.setVisible(true);
                // titleLabel set title
                titleLabel.setText(newCuisine.getTitle());
                // cuisineImageView set image
                cuisineImageView.setImage(new Image(newCuisine.getImage()));
            } catch (Exception e) {
                // cuisineImageView set no-image
                cuisineImageView.setImage(new Image("https://static.wikia.nocookie.net/undead-unluck/images/2/22/No_Image_available.png/revision/latest?cb=20200119200005"));
            }
        }));
    }

    /**
     * This is a method for the event when the user click the 'Search' button
     * Calls cuisine with the parameters
     * @param event
     */
    @FXML
    void searchButton_onClick(ActionEvent event) {
        // clear the cuisineListView
        cuisineListView.getItems().clear();
        // getDetailsButton set not visible
        getDetailsButton.setVisible(false);
        // titleLabel set not visible
        titleLabel.setVisible(false);
        // errorLabel set not visible
        errorLabel.setVisible(false);
        // cuisineImageView set not visible
        cuisineImageView.setVisible(false);
        // get user's selected cuisine from the cuisineComboBox
        String cuisine = cuisineComboBox.getSelectionModel().getSelectedItem();
        // get user's search text from the searchTextField
        String searchText = searchTextField.getText();

//        ApiResponse apiResponse = ApiUtility.getDataFromFile("C:\\GeorgianCollege\\Java\\Assignment2-GC1364\\apiResponse.json");
        // get objects from Api response
        ApiResponse apiResponse = ApiUtility.getDataFromApi(cuisine, searchText);
        if (apiResponse.getTotalResults() > 0) {
            // set the cuisineListView with the objects
            cuisineListView.getItems().addAll(apiResponse.getCuisines());
            cuisineListView.getSelectionModel().selectFirst();
        } else {
            // errorLabel set visible
            errorLabel.setVisible(true);
        }

    }

    /**
     * This is a method for the event when the user click the 'Get Details' button
     * Change the search recipe scene to recipe details scene with selected recipe id
     * @param event
     * @throws IOException
     */
    @FXML
    void getDetailsButton_onClick(ActionEvent event) throws IOException {
        // get user's selected recipe id
        int SelectedRecipeId = cuisineListView.getSelectionModel().getSelectedItem().getId();
        SceneChanger.changeScene(event, "recipe-details-view.fxml", SelectedRecipeId);
    }
}
