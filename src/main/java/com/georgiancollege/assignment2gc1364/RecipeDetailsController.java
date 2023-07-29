package com.georgiancollege.assignment2gc1364;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class RecipeDetailsController {

    @FXML
    private ImageView imageView;

    @FXML
    private Text ingredientsText;

    @FXML
    private ListView<?> instructionListView;

    @FXML
    private Label readyInLabel;

    @FXML
    private Label servingsLabel;

    @FXML
    private Label titleLabel;

    @FXML
    void goBackButton_Onclick(ActionEvent event) {

    }

}
