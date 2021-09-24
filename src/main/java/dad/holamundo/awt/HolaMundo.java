package dad.holamundo.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class HolaMundo {

	public static void main(String[] args) {

		// creamos la etiqueta para mostrar el saludo
		Label saludoLabel = new Label();
		saludoLabel.setText("Aqui saldra el saludo");
		saludoLabel.setBounds(20, 20, 120, 50);

		// creamo boton
		Button saludarButton = new Button();
		saludarButton.setLabel("Saludar");
		saludarButton.setBounds(20, 80, 120, 30);
		saludarButton.addActionListener(a -> saludoLabel.setText("Hola Mundo"));

		// panel que contiene la etiqueta y el boton
		Panel rootPanel = new Panel();
		rootPanel.setLayout(null);
		rootPanel.add(saludoLabel);
		rootPanel.add(saludarButton);

		// creamos la ventana
		Frame frame = new Frame();
		frame.setTitle("Hola mundo en awt");
		frame.setSize(320, 200);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(rootPanel);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		frame.setVisible(true);
	}
}
