package org.example.scriptbinds.components;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.scriptbinds.JsonSingleton;

public class InputController {

    @FXML
    private TextField hotkeyField;

    @FXML
    private TextField scriptField;

    @FXML
    private void handleSubmit() {
        JsonSingleton.saveToJson(hotkeyField.getText(), scriptField.getText());
        System.out.println("Successfully Saved");
    }
}
