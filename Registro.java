package cutplace;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;


public class Registro implements ActionListener, EventListener, KeyListener {  
 
  private JFrame windP;
  private JPanel box1;
  private JPanel boxP;
  private JPanel ceye;//:)
  private Label txt1;
  
  private JTextField user;
  private JTextField mail;
  private JTextField pass;
  
  private Choice correo_e; 
  private Label space0;
  private Label space1;
  private Label space2;
  private Label space3;
  private Label space4;
  private JButton go;
  
  private String correoT;
  private String codigoT;
  private String contraseniaT;
  

  public Registro (){
    //Creacion de variable
	
   correo_e= new Choice();	 
   
   String correos_e[]={"@hotmail.com","@outlook.com","@outlook.es","@gmail.com"};  
   for(int i=0; i<correos_e.length;i++) {
	   correo_e.add(correos_e[i]);
   }

   windP = new JFrame("  Registro  ");
   boxP = new JPanel();
   box1 = new JPanel();
   ceye= new JPanel();//panel para agregar email y lo demas 
   ceye.setLayout(new GridLayout (1,2));
   txt1 =  new Label("  Bienvenido a el Regsitro de Vendedor :)");
   user = new JTextField();
   user.addKeyListener(this);
   mail = new JTextField();
   mail.addKeyListener(this);
   user.addKeyListener(this);
   pass = new JTextField();
   space0 = new Label("");
   space1 = new Label(" Codigo de Alumno ");
   space2 = new Label(" Correo electronico ");
   space3 = new Label(" Contrasena ");
   space4 = new Label("");
   go = new JButton ("OK");
   go.addActionListener(this);
   



    //Acomodo

   box1.setLayout(new GridLayout(11,1));
   box1.add(txt1);

   box1.add(space0);
   boxP.add(box1);
   box1.add(space1);
   box1.add(user);
   box1.add(space2);
   box1.add(ceye);
   ceye.add(mail);
   ceye.add(correo_e);
   box1.add(space3);
   box1.add(pass);
   box1.add(space4);
   box1.add(go);

   windP.add(boxP);

   //Configuracion de fuentes etc.
   txt1.setFont(new Font("Dialog",Font.BOLD, 20));
   space0.setFont(new Font("",Font.BOLD, 15));
   space1.setFont(new Font("",Font.BOLD, 15));
   space2.setFont(new Font("",Font.BOLD, 15));
   space3.setFont(new Font("",Font.BOLD, 15));
   user.setFont(new Font("Dialog",Font.BOLD, 15));
   mail.setFont(new Font("Dialog",Font.BOLD, 15));
   pass.setFont(new Font("Dialog",Font.BOLD, 15));
   go.setFont(new Font("Dialog",Font.BOLD, 20));
   correo_e.setFont(new Font("Dialog",Font.BOLD, 20));
   
   //Choice
   

   windP.setSize(480,720);
   windP.setBackground(new Color(24,191,189));
   windP.setVisible(true);

 }
   public void actionPerformed(ActionEvent eve){
	  
	  System.out.println("Se oprimio ready :)");
	  
	  codigoT=user.getText();
	  correoT=mail.getText();
	  correoT=correoT+correo_e.getSelectedItem();
	  contraseniaT=pass.getText();
	  
     System.out.println(correoT);
	  
	  DataBase conexion= new DataBase();
	  
	  if(conexion.openConnection()) {
		 
		  conexion.addUser(codigoT, correoT, contraseniaT);
		  
		  conexion.closeConnection();
		  
		  JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO, ESPERAR QUE SE DE DE ALTA LA CUENTA.");
		  
		  windP.dispose();
		  
	  }
	  
	 
  }
@Override
public void keyTyped(KeyEvent e) {

	System.out.println(e.getKeyChar());

	

	 
	 if(e.getSource().equals(user)) {
	
	   if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar()!=KeyEvent.VK_BACK_SPACE  ){
		
	  JOptionPane.showMessageDialog(null, "PORFAVOR, SOLO DIGITAR NUMEROS");
	 
	   e.setKeyChar('\0');
	   }
	}
	/* else if (e.getSource().equals(mail)) {
			
		   if(!Character.isAlphabetic(e.getKeyChar()) && e.getKeyChar()!=KeyEvent.VK_BACK_SPACE && !Character.is(e.getKeyChar())  ){
			
		  JOptionPane.showMessageDialog(null, "PORFAVOR, SOLO DIGITAR NUMEROS");
		 
		   e.setKeyChar('\0');
		   }
		}*/

		
 }
	
@Override
public void keyPressed(KeyEvent e) {

	
}
@Override
public void keyReleased(KeyEvent e) {
	
}

}
