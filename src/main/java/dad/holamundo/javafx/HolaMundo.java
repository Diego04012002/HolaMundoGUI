package dad.holamundo.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HolaMundo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//creamos la etiqueta
		Label saludoLabel = new Label();
		saludoLabel.setText("Aqui saldra un saludo");
		saludoLabel.setLayoutX(20);
		saludoLabel.setLayoutY(20);
		
		//creamos el boton
		Button saludoBoton = new Button();
		saludoBoton.setText("Saludar");
		saludoBoton.setLayoutX(20);
		saludoBoton.setLayoutY(80);
		saludoBoton.setTooltip(new Tooltip("Cuando me pulses te saludo"));
		saludoBoton.setOnAction(e->saludoLabel.setText("Hola Mundo!!!!"));
		
		//creamos el panel
		Pane rootPanel= new Pane();
		rootPanel.getChildren().addAll(saludoBoton, saludoLabel);
		
		//creamos la ventana
		Scene scene = new Scene(rootPanel, 320, 200);
		
		//configurar la ventana
		primaryStage.setTitle("Hola mundo con JAVAFX");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
