package com.georgiancollege.assignment2gc1364;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDetailsButton.setVisible(false);
        titleLabel.setVisible(false);
        cuisineComboBox.getItems().addAll("All", "African", "Asian", "American", "British", "Cajun", "Caribbean", "Chinese", "Eastern European", "European", "French", "German", "Greek", "Indian", "Irish", "Italian", "Japanese", "Jewish", "Korean", "Latin American", "Mediterranean", "Mexican", "Middle Eastern", "Nordic", "Southern", "Spanish", "Thai", "Vietnamese");
        cuisineComboBox.setValue("All");
        cuisineListView.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldCuisine, newCuisine) -> {
            try {
                getDetailsButton.setVisible(true);
                titleLabel.setVisible(true);
                titleLabel.setText(newCuisine.getTitle());
                cuisineImageView.setImage(new Image(newCuisine.getImage()));
            } catch (Exception e) {
                cuisineImageView.setImage(new Image("https://static.wikia.nocookie.net/undead-unluck/images/2/22/No_Image_available.png/revision/latest?cb=20200119200005"));
            }
        }));
    }

    @FXML
    void searchButton_onClick(ActionEvent event) {
        cuisineListView.getItems().clear();
        String cuisine = cuisineComboBox.getSelectionModel().getSelectedItem();
        String searchText = searchTextField.getText();

        ApiResponse apiResponse = ApiUtility.getDataFromFile("C:\\GeorgianCollege\\Java\\Assignment2-GC1364\\apiResponse.json");
//        ApiResponse apiResponse = ApiUtility.getDataFromApi(cuisine, searchText);
        if (apiResponse != null) {
            cuisineListView.getItems().addAll(apiResponse.getCuisines());

        }

    }

    @FXML
    void getDetailsButton_onClick(ActionEvent event) {

    }
}
