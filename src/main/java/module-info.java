module com.georgiancollege.assignment2gc1364 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.georgiancollege.assignment2gc1364 to javafx.fxml, com.google.gson;
    exports com.georgiancollege.assignment2gc1364;
    exports com.georgiancollege.assignment2gc1364.Controllers;
    opens com.georgiancollege.assignment2gc1364.Controllers to com.google.gson, javafx.fxml;
    exports com.georgiancollege.assignment2gc1364.Utilities;
    opens com.georgiancollege.assignment2gc1364.Utilities to com.google.gson, javafx.fxml;
    exports com.georgiancollege.assignment2gc1364.Models;
    opens com.georgiancollege.assignment2gc1364.Models to com.google.gson, javafx.fxml;
}