 package micplayback;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RunnableClass extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		String styles = this.getClass().getResource("/micplaybackresources/styles.css").toExternalForm();
		FXMLLoader index = new FXMLLoader(this.getClass().getResource("/micplaybackresources/index.xml"));
		Image icon = new Image("/micplaybackresources/icon.png");
		
		primaryStage.getIcons().add(icon);
		GridPane raiz = index.load();
		Scene cena = new Scene(raiz, 240, 140);
		cena.getStylesheets().add(styles);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Mint Loopback");
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	static void launchClass(String[] args) {
		launch(args);
	}
}
