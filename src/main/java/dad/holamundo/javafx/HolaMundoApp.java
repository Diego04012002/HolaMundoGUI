package dad.holamundo.javafx;

import javax.management.loading.PrivateClassLoader;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
public class HolaMundoApp extends Application {

	private Label saludoLabel;
	private Label saludoLabelNumeros;
	private Button saludoBoton;
	private TextField nombreText;
	private VBox rootPanel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//creamos el cuadro de texto
		nombreText=new TextField();
		nombreText.setPromptText("Introduce tu nombre");
		nombreText.setMaxWidth(150);
		
		//creamos la etiqueta
		saludoLabel=new Label();
		saludoLabel.setText("Aqui saldra el saludo");

		
		//creamos  un boton
		saludoBoton=new Button();
		saludoBoton.setText("Saludar");
		
		//creamos el panel
		rootPanel=new VBox();
		rootPanel.setSpacing(15);
		rootPanel.setAlignment(Pos.CENTER);
		rootPanel.getChildren().addAll(nombreText, saludoBoton, saludoLabel);
		
		Scene scene=new Scene(rootPanel, 320, 200);
		
		primaryStage.setTitle("Hola Mundo Mejorado");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
