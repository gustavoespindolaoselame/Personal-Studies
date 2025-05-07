package org.example.scriptbinds;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.scriptbinds.components.InputController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("input.fxml"));
        Parent root = loader.load();

        InputController controller = loader.getController();
        Scene scene = new Scene(root);

        // Pass the scene (or just its key listener) to the controller
        controller.setSceneForKeyListening(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
