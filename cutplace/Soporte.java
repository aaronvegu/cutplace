package cutplace;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Soporte implements ActionListener {
	
	// Declaracion de Variables
	JFrame frame;
	JPanel layout1, layout2, layout3, layoutP;
	JLabel titulo, desc, desc2;
	JTextArea ta;
	JTextField nombre, correo;
	JButton boton, back;
	File archivo;
	Choice parametro;
	String correos[] = {"@gmail.com", "@outlook.com", "@outlook.es", "@hotmail.com"};
	
	
	// Creacion del constructor
	public Soporte() {
		
		// Creacion de las variables
		frame = new JFrame("Soporte");
		layout1 = new JPanel();
		layout2 = new JPanel();
		layout3 = new JPanel();
		back = new JButton("Volver");
		//em = new JLabel("prueba");
		titulo = new JLabel("¿Algun Problema con la Aplicacion?");
		desc = new JLabel("Envianos un mensaje para ayudarte :)");
		ta = new JTextArea("Describe el problema o mensaje");
		nombre = new JTextField("Ingresa tu nombre"); 
		correo = new JTextField("Ingresa tu correo");
		boton = new JButton("Enviar");
		desc2 = new JLabel("Tambien puedes enviarnos comentarios, sugerencias y/o notas");
		parametro = new Choice();
		layoutP = new JPanel();
		 
		// Acomodo
		frame.setLayout(new GridLayout(3, 1));
		//layout0.setLayout(new GridLayout(1, 3));
		//layout1.setLayout(new GridLayout(3, 1));
		layout2.setLayout(new GridLayout(3, 1, 20, 5));
		//layout3.setLayout(new GridLayout(2, 1));
		layoutP.setLayout(new GridLayout(1, 2));
		frame.add(layout1);
		frame.add(layout2);
		frame.add(layout3);
		//layout1.add(em);
		layout1.add(titulo);
		layout1.add(desc);
		layout2.add(ta);
		layout2.add(nombre);
		layout2.add(layoutP);
		layoutP.add(correo);
		layoutP.add(parametro);
		layout3.add(back);
		layout3.add(boton);
		layout3.add(desc2);
		
		for (int i = 0; i < correos.length; i++) 	
			parametro.add(correos[i]);
		
		boton.addActionListener(this);
		back.setOpaque(false);
		
		// Personalizacion
		layout1.setBackground(new Color(225, 235, 195));
		layout2.setBackground(new Color(225, 235, 195));
		layout3.setBackground(new Color(225, 235, 195));
		layoutP.setBackground(new Color(225, 235, 195));
		titulo.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
		desc.setFont(new Font("", Font.ITALIC, 14));
		correo.setSize(235, 40);
		parametro.setSize(235, 40);
		
		// Configuracion del Frame
		frame.setSize(480, 720);
		frame.setVisible(true);
		frame.setResizable(false);
		//frame.setBackground(new Color(225, 235, 195));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(boton)) { // Boton Enviar
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Texto", "txt", "rtf", "csv");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showSaveDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				archivo = chooser.getCurrentDirectory();
				archivo = new File(archivo.getPath() + "/" + chooser.getSelectedFile().getName() + ".txt");
			}
			String info = "//Mensaje enviado a soporte//\nCorreo: " + correo.getText() + parametro.getSelectedItem() + "\nNombre: " + nombre.getText() +
					"\nMensaje:\n" + ta.getText();
			guardar(archivo, info);
		}
	}
	
	public void guardar(File archivo, String texto) {
		BufferedWriter buffer;
		try {
			buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo)));
			buffer.write(texto);
			buffer.close();
		} catch(IOException e) {
			System.out.println("Error al guardar el archivo");
		}
	}
	
	
	
	
}
