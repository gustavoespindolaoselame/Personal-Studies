module org.example.scriptbinds {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens org.example.scriptbinds to javafx.fxml;
    exports org.example.scriptbinds;
    exports org.example.scriptbinds.components;
    opens org.example.scriptbinds.components to javafx.fxml;
}