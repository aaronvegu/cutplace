package cutplace;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class main implements ActionListener
{
	JFrame mainFrame,secondFrame,thirdFrame;
	JButton b[],b2,b3[],next,back,backahora;
	JTextField ourField;
	JPanel newLab,newLab2,image1,newLab3,menu,panup,desc,env;
	String[] newString;
	JLabel label,label2,label3,lab[],label4,label5,label6[],label7[];
	Image image;
	ImageIcon taquitos,taquitos1;
	String comida1,comida2;
	JTextArea first,second[];



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
		
		newString = new String[] {"Login","Soporte"};
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
			
		String image4 = "D:\\Resources\\Images\\left.png";
		ImageIcon icon4 = new ImageIcon(image4); 
		/*label2.setIcon(icon4);*/
		
		String image5 = "D:\\Resources\\Images\\right.png";
		ImageIcon icon5 = new ImageIcon(image5); 
		label3.setIcon(icon5);

		
		newLab3.setLayout(new GridLayout(6,1));
		
		
		Principal obj= new Principal();
		mainFrame = new JFrame("Main");
		obj.addJFrameUser(newLab3,mainFrame);
		
		newLab.setBackground(new Color(204,222,145));
		newLab2.setBackground(new Color(204,222,145));
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
		back.setBorderPainted(false);
		back.setBackground(new Color(185,209,99));
		
		next = new JButton(">");
		next.setSize(28,60);
		next.addActionListener(this);
		next.setBorderPainted(false);
		next.setBackground(new Color(185,209,99));
		
		lab = new JLabel[2];
		label4 = new JLabel();
		label5 = new JLabel();
		

		String comida1 = "D:\\Resources\\Images\\test2.png";	
		ImageIcon taquitos = new ImageIcon(comida1); 
		label4.setIcon(taquitos);
		
		String comida2 = "D:\\Resources\\Images\\test3.png";
		ImageIcon taquitos1 = new ImageIcon(comida2); 
		label5.setIcon(taquitos1);
		
		label4.add(next);
		
		menu = new JPanel();
		menu.add(back);
		menu.add(next);
		
		
		//Text that must be modified by database Qrys		

		// third frame
		
		env = new JPanel();
		
		label7 = new JLabel[4];
		
		thirdFrame = new JFrame("Change info");
		thirdFrame.setVisible(false);
		thirdFrame.setSize(480,720);
		thirdFrame.setLayout(new BorderLayout());
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="Login") {
			
			
			Cutplace obj=new Cutplace(mainFrame);
			mainFrame.dispose();
		}
		
		else if(e.getActionCommand()== ">")
		{
			panup.remove(menu);
			panup.remove(label4);
			panup.add(label5);
			panup.add(menu);
			panup.revalidate();
			panup.repaint();
			System.out.println("Done");
		}
        else if(e.getActionCommand()=="<")
		{
			panup.remove(menu);
			panup.remove(label5);
			panup.add(label4);
			panup.add(menu);
			panup.revalidate();
			panup.repaint();
			System.out.println("Done");
		}

	}
	

	
	public static void main(String[] args)
	{
		main b = new main();
	}
	
	

	
	
}


