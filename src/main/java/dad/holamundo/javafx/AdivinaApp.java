package dad.holamundo.javafx;

import java.awt.event.ActionEvent;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class AdivinaApp extends Application {
	Random r = new Random();
	private Label saludoLabel;
	private TextField numeroText;
	private Button saludoBoton;
	private VBox rootPanel;
	public int numero;
	private int intentos = 0;

	public void start(Stage primaryStage) throws Exception {
		
		//generamos numero aleatorio
		numero = r.nextInt(100) + 1;
		
		// creamos la etiqueta
		saludoLabel = new Label();
		saludoLabel.setText("Introduce un número del 1 al 100");

		// creamos el cuadro de texto
		numeroText = new TextField();
		numeroText.setPromptText("Numero...");
		numeroText.setMaxWidth(150);

		// creamos un boton
		saludoBoton = new Button();
		saludoBoton.setText("Comprobar");
		saludoBoton.setOnAction(a -> onNumeroOcultoBoton(a));
		saludoBoton.setDefaultButton(true);

		// creamos el panel
		rootPanel = new VBox();
		rootPanel.setSpacing(15);
		rootPanel.setAlignment(Pos.CENTER);
		rootPanel.getChildren().addAll(saludoLabel, numeroText, saludoBoton);

		//creamos escena
		Scene scene = new Scene(rootPanel, 320, 200);

		primaryStage.setTitle("AdivinaApp");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	//funcion para comprobar si hay algun caracter
	private static boolean contieneSoloLetras(String numeroTexto) {
	    for (int x = 0; x < numeroTexto.length(); x++) {
	        char c = numeroTexto.charAt(x);
	        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
	            return false;
	        }
	    }
	    return true;
	}
	//funcion del evento del boton
	private void onNumeroOcultoBoton(javafx.event.ActionEvent e) {
		String numeroTexto = numeroText.getText();
		int numeroInt = 0;
		if (numeroTexto.length()!=0 && contieneSoloLetras(numeroTexto)==false) {
			numeroInt = Integer.parseInt(numeroTexto);
			if (numeroInt != numero && numeroInt < numero) {
				intentos++;
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Fallo");
				alert.setHeaderText("Vuelve a intentarlo");
				alert.setContentText("El numero es mayor a " + numeroInt + "\n" + "Llevas " + intentos + " intentos");

				alert.showAndWait();

			}

			if (numeroInt != numero && numeroInt > numero) {
				Alert alert = new Alert(AlertType.WARNING);
				intentos++;
				alert.setTitle("Fallo");
				alert.setHeaderText("Vuelve a intentarlo");
				alert.setContentText("El numero es menor a " + numeroInt + "\n" + "Llevas " + intentos + " intentos");

				alert.showAndWait();

			}
			if (numeroInt == numero) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinaApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText(
						"Solo has necesitado " + (intentos + 1) + " intentos" + "\n" + "Vuelve a jugar y hazlo mejor");

				alert.showAndWait();
			}
		}

		if (numeroTexto.length()==0 || contieneSoloLetras(numeroTexto)==true) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinaApp");
			alert.setHeaderText("Error");
			alert.setContentText("El numero introducido no es valido");

			alert.showAndWait();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
