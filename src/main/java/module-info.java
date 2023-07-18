module com.georgiancollege.assignment2gc1364 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.georgiancollege.assignment2gc1364 to javafx.fxml, com.google.gson;
    exports com.georgiancollege.assignment2gc1364;
}