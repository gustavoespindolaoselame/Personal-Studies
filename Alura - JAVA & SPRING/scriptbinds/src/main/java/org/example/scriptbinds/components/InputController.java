package org.example.scriptbinds.components;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.example.scriptbinds.AnsiKeyMapper;
import org.example.scriptbinds.JsonSingleton;

public class InputController {

    @FXML
    private TextField scriptField;
    private String currentHotkey;
    private Scene scene;

    public void setSceneForKeyListening(Scene scene) {
        this.scene = scene;
    }

    @FXML
    private void observeButton() {
        if (scene == null) return;

        System.out.println("Press a key to assign as hotkey...");
        scene.addEventHandler(KeyEvent.KEY_PRESSED, this::captureKeyOnce);
    }

    private void captureKeyOnce(KeyEvent event) {
        currentHotkey = AnsiKeyMapper.getAnsi(event.getCode(), event.getText());
        System.out.println("Captured hotkey: " + currentHotkey);
        scene.removeEventHandler(KeyEvent.KEY_PRESSED, this::captureKeyOnce);
    }

    @FXML
    private void handleSubmit() {
        JsonSingleton.saveToJson(currentHotkey, scriptField.getText());
        System.out.println("Successfully Saved");
    }
}
