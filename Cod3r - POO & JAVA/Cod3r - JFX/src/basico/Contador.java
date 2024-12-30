package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application{

	private Integer value = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label labelTitulo = new Label("Contador: ");
		labelTitulo.getStyleClass().add("titulo");
		
		Label labelNumero = new Label(this.getValue().toString());
		labelNumero.getStyleClass().add("numero");
		
		Button botaoIncremento = new Button("+");
		botaoIncremento.getStyleClass().add("botoes");
		
		Button botaoDecremento = new Button("-");
		botaoDecremento.getStyleClass().add("botoes");
		
		HBox boxBotoes = new HBox();
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		boxBotoes.getChildren().add(botaoDecremento);
		boxBotoes.getChildren().add(botaoIncremento);

		VBox boxConteudo = new VBox();
		boxConteudo.getStyleClass().add("conteudo");
		boxConteudo.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		boxConteudo.getChildren().add(labelTitulo);
		boxConteudo.getChildren().add(labelNumero);
		boxConteudo.getChildren().add(boxBotoes);
		
		botaoIncremento.setOnAction(e -> {
			this.changeValue(+1, labelNumero);
		});
		botaoDecremento.setOnAction(e -> {
			this.changeValue(-1, labelNumero);
		});
		
		String caminhoDoCss = getClass().getResource("/basico/Contador.css").toExternalForm();
		Scene cenaPrincipal = new Scene(boxConteudo, 400, 400);
		
		cenaPrincipal.getStylesheets().add(caminhoDoCss);
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");

		primaryStage.setScene(cenaPrincipal);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public void changeValue(Integer change, Label label) {
		this.setValue(this.getValue()+change);
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");
		
		if(this.getValue() < 0) {
			label.getStyleClass().add("vermelho");
		} 
		
		if(this.getValue() > 0){
			label.getStyleClass().add("verde");
		}
		
		label.setText(value.toString());
	}

}
