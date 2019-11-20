package comicut2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class main implements ActionListener
{
	JFrame mainFrame,secondFrame;
	JButton b[],b2,b3[],next,back,backahora;
	JTextField ourField;
	JPanel newLab,newLab2,image1,newLab3,menu,panup;
	String[] newString;
	JLabel label,label2,label3,lab[],label4,label5;
	Image image;
	ImageIcon taquitos,taquitos1;
	String comida1,comida2;
	JTextArea first;



	public main()
	{
		next = new JButton("Next");
		label3 = new JLabel();
		b3 = new JButton[40];
		b = new JButton[2];
		newLab = new JPanel();
		newLab.setLayout(new FlowLayout());
		 
		first = new JTextArea("Saluditos");
			
		String image = "D:/resources/images/logo1.png";
		ImageIcon icon = new ImageIcon(image); 
		JLabel label = new JLabel();
		label.setIcon(icon);
		
		
		
		newLab2 = new JPanel();
		newLab2.setLayout(new FlowLayout());
		
		newLab3 = new JPanel();
		newLab3.setLayout(new BorderLayout());
		newLab3.setSize(80,80);
		newLab3.setBackground(new Color(225,235,195));
		
		newString = new String[] {"",""};
		for(int i = 0; i < newString.length;i++)
		{
			b[i] = new JButton(newString[i]);
			b[i].addActionListener(this);
			if(i == 0)
				newLab.add(b[i]);
			else
			{
				newLab2.add(b[i]);
			}
		}
		
		String image2 = "C:\\Users\\Gustavo Quintero\\Downloads\\Sao\\menu\\BUTTON2.png";
		ImageIcon icon2 = new ImageIcon(image2); 
		String image3 = "C:\\Users\\Gustavo Quintero\\Downloads\\Sao\\menu\\BUTTON3.png";
		ImageIcon icon3 = new ImageIcon(image3); 
		b[1].setIcon(icon2);
		b[1].setBorderPainted( false );
		b[1].setBackground(new Color(204,222,145));
		b[0].setIcon(icon3);
		b[0].setBorderPainted( false );
		b[0].setBackground(new Color(204,222,145));
		
		
		label2 = new JLabel();
		b3[0] = new JButton("Taquitos don pepe");
		
		
		b3[0].setLayout(new BorderLayout());
		
		
		b3[0].add(label2, BorderLayout.WEST);
		b3[0].add(label3, BorderLayout.EAST);
		b3[0].addActionListener(this);
		b3[0].setBorderPainted( false );
		b3[0].setBackground(new Color(185,209,99));
		
		
		String image4 = "D:\\Resources\\Images\\left.png";
		ImageIcon icon4 = new ImageIcon(image4); 
		label2.setIcon(icon4);
		
		String image5 = "D:\\Resources\\Images\\right.png";
		ImageIcon icon5 = new ImageIcon(image5); 
		label3.setIcon(icon5);
		b3[0].setSize(new Dimension(280,100));
		
		
		
		newLab3.setLayout(new GridLayout(6,1));
		newLab3.add(b3[0]);
		newLab.setBackground(new Color(204,222,145));
		newLab2.setBackground(new Color(204,222,145));
		mainFrame = new JFrame("Main");
		mainFrame.setLayout (new BorderLayout());
		mainFrame.setSize(480,720);
		mainFrame.add(newLab3, BorderLayout.CENTER);
		
		
		mainFrame.add(label,BorderLayout.NORTH);
		mainFrame.add(newLab,BorderLayout.WEST);
		mainFrame.add(newLab2,BorderLayout.EAST);
		mainFrame.setVisible(true);
		
		//Segundo frame customer view aqui
		back = new JButton("<");
		back.setSize(28,60);
		back.addActionListener(this);
		
		next = new JButton(">");
		next.setSize(28,60);
		next.addActionListener(this);
		
		lab = new JLabel[2];
		label4 = new JLabel();
		label5 = new JLabel();
		
		panup = new JPanel();
		panup.setLayout(new GridLayout(1,2));
		
		String comida1 = "D:\\Resources\\Images\\test2.png";	
		ImageIcon taquitos = new ImageIcon(comida1); 
		label4.setIcon(taquitos);
		
		String comida2 = "D:\\Resources\\Images\\test3.png";
		ImageIcon taquitos1 = new ImageIcon(comida2); 
		label5.setIcon(taquitos1);
		
		label4.add(next);
		
		menu = new JPanel();
		panup.setLayout(new GridLayout(2,2));
		menu.add(back);
		menu.add(next);
		
		panup.add(label4);
		panup.add(menu);
		
		backahora = new JButton("Atras");
		backahora.addActionListener(this);
		
		secondFrame = new JFrame("Customer View");
		secondFrame.setVisible(false);
		secondFrame.setSize(480,720);
		secondFrame.setLayout(new BorderLayout());
		secondFrame.add(panup,BorderLayout.NORTH);
		secondFrame.add(backahora,BorderLayout.SOUTH);
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="Taquitos don pepe") 
		{
			mainFrame.setVisible(false);
			createSecond();
			secondFrame.setVisible(true);
		}
		if(e.getActionCommand()== ">")
		{
			panup.remove(menu);
			panup.remove(label4);
			panup.add(label5);
			panup.add(menu);
			panup.revalidate();
			panup.repaint();
			System.out.println("Done");
		}
		if(e.getActionCommand()=="<")
		{
			panup.remove(menu);
			panup.remove(label5);
			panup.add(label4);
			panup.add(menu);
			panup.revalidate();
			panup.repaint();
			System.out.println("Done");
		}
		if(e.getActionCommand()=="Atras")
		{
			secondFrame.setVisible(false);
			mainFrame.setVisible(true);
		}

	}
	
	public void createSecond()
	{
		
		
	}
	
	public static void main(String[] args)
	{
		main b = new main();
	}
	
	

	
	
}


