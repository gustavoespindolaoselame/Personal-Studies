 package micplayback;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		String styles = getClass().getResource("/styles.css").toExternalForm();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/index.xml"));
		Image icon = new Image("/icon.png");
		
		primaryStage.getIcons().add(icon);
		GridPane raiz = loader.load();
		Scene cena = new Scene(raiz, 240, 140);
		cena.getStylesheets().add(styles);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Mint Loopback");
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	public static void start(String[] args) {
		launch(args);
		Controller.onStartButtonOff();
	}
}
