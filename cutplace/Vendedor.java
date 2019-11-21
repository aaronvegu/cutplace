package cutplace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Vendedor extends JFrame implements ActionListener {
	
	private JPanel panup, desc;
	private JButton backahora;
	JLabel label,label2,label3,lab[],label4,label5,label6[],label7[];
	JTextArea first,second[];
	JFrame mainFrame;
	
	
	public Vendedor(Usuario us, JFrame mainFrame) {
				
		this.mainFrame=mainFrame;
		
		String[] opciones = {"Nombre del vendedor : ","Descripcion del vendedor : ","Telefono : "};
		String[] descripciones= {us.getNombre(),us.getDescripcion(),us.getTelefono()}; 
				
		setTitle("Custom View");
		
		setVisible(false);
		setSize(480,720);
		setLayout(new BorderLayout());
		
		panup = new JPanel();
		panup.setLayout(new GridLayout(1,2));
		label6 = new JLabel[opciones.length];
		second = new JTextArea[opciones.length];
		
		desc = new JPanel();
		desc.setLayout(new GridLayout(4,2));
		desc.setBackground(new Color(204,222,145));
		
		for(int i = 0; i < opciones.length;i++)
		{
			label6[i] = new JLabel(opciones[i]);
			label6[i].setBackground(new Color(204,222,145));
			second[i] = new JTextArea(descripciones[i]);
			second[i].setBackground(new Color(204,222,145));
			second[i].setEditable(false);
			desc.add(label6[i]);
			desc.add(second[i]);
			
			
		}
		
		backahora = new JButton("Atras");
		backahora.addActionListener(this);
		backahora.setBorderPainted(false);
		backahora.setBackground(new Color(185,209,99));
		
		add(panup,BorderLayout.NORTH);
		
		add(backahora,BorderLayout.SOUTH);
		add(desc,BorderLayout.CENTER);
		setBackground(new Color(204,222,145));
		setSize(480,720);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		mainFrame.setVisible(true);
		dispose();

		
	}
	

}
