package dad.holamundo.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HolaMundo {

	public static void main(String[] args) {
		//creamos un label
		JLabel saludoLabel= new JLabel();
		saludoLabel.setText("Aqui saldra un saludo");
		saludoLabel.setBounds(20, 20, 120, 50);
		
		//creamos el boton
		JButton saludoBoton = new JButton();
		saludoBoton.setText("Saludar");
		saludoBoton.setBounds(20, 80, 120, 30);
		saludoBoton.setToolTipText("Como me pulses te saludo");
		saludoBoton.addActionListener(w-> saludoLabel.setText("Hola Mundo"));
		
		//panel que contiene la etiqueta y el boton
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.add(saludoLabel);
		panel.add(saludoBoton);
		
		//creamos la ventana
		JFrame ventana = new JFrame();
		ventana.setTitle("Hola mundo con swing");
		ventana.setSize(320,200);
		ventana.setResizable(false);
		ventana.setContentPane(panel);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventana.setVisible(true);
	}

}
