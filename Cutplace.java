package cutplace;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Cutplace  implements ActionListener {
  
  private JFrame ingreso;  //presentacion de las variables (globales para que asi pueda utilizar mi constructor.
  private JLabel vendedor, iniciar, aviso, paraP;
  private JPanelBackground panelp,paneln;
  private JPanel panel1,panel2;
  private JButton ok, crear, atras;
  private JTextField us;
  private JPasswordField join;
  
  private String contrasena;
  private String user;
  
  
  public Cutplace() {
	
    ingreso=new JFrame("INGRESO A VENDEDORES");//el frame sera nuestra ventana que alojara todos los componentes que 
    vendedor=new JLabel("¿Eres vendedor?\n ");
    iniciar=new JLabel("    Iniciar sesion");
    us =new JTextField("Codigo de Alumno");
    paraP=new JLabel(" ");
    aviso= new JLabel("¿No tienes cuenta?");
    
   
    ok=new JButton("Ingresar");
    ok.addActionListener(this);
    crear= new JButton("Registrate");
    crear.setBorderPainted(false);
    atras= new JButton("volver");
    
    atras.setOpaque(false);
    atras.setContentAreaFilled(false);
    atras.setBorderPainted(false);
    atras.addActionListener(this);
    crear.addActionListener(this);
    
    join= new JPasswordField("Conseña");
    
    panelp=new JPanelBackground("C:\\Users\\slowe\\eclipse-workspace\\cutplace\\bin\\cutplace\\fcec1f167e1a454be1024b8e57928ace.jpg");
    panel1=new JPanel();
    panel2=new JPanel();
    paneln= new JPanelBackground("C:\\Users\\slowe\\eclipse-workspace\\cutplace\\bin\\cutplace\\orig_508096.jpg");
    
    paraP.setFont(new Font("", Font.BOLD,70));
    iniciar.setFont(new Font("", Font.ITALIC,15));
    vendedor.setFont(new Font("", Font.PLAIN,15));
    atras.setFont(new Font("",Font.PLAIN,30));
       
    panel1.setLayout(new GridLayout(5,1));   
    panel1.add(vendedor); 
    panel1.add(iniciar);
    panel1.add(us);
    panel1.add(join);
    panel1.add(ok);
    
    panel2.setLayout(new GridLayout(1,2));
    panel2.add(aviso);
    panel2.add(crear);
    
    panelp.add(panel1);
    
    paneln.setLayout(new GridLayout(1,3));
    paneln.add(paraP);
    paneln.add(atras);
    
    
    ingreso.setSize(480,720);
    ingreso.add(paneln,BorderLayout.NORTH);
    ingreso.add(panelp,BorderLayout.CENTER);
    ingreso.add(panel2,BorderLayout.SOUTH);
    ingreso.setVisible(true);
    ingreso.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    
  }
  
  @SuppressWarnings("deprecation")
 public void actionPerformed(ActionEvent eve) {
	  
	  System.out.println("se presiono un boton");
	  contrasena=join.getText();
	  user=us.getText();
	  
	  System.out.println("la contraseña digitada es: "+contrasena);
	
      
	  
	  if(eve.getSource().equals(crear)) {
		  Registro registro = new Registro();
	  }
	  
	  else if (eve.getSource().equals(atras)) {
		 ingreso.dispose();
	 }
	  else if (eve.getSource().equals(ok)) {
		  DataBase conexion= new DataBase();
		  
		  if(conexion.openConnection()) {
			 
			  if(conexion.loginUser(user,contrasena)) {
				  
				  JOptionPane.showMessageDialog(ingreso, "Si inicio sesion correctamente, Bienvenido",user, 3);
				  ingreso.dispose();
				  
				  Registro prueba= new Registro();
			  }
			  else { JOptionPane.showMessageDialog(ingreso, "Usuario o contraseña incorrecta", "ERROR AL INGRESO", JOptionPane.INFORMATION_MESSAGE);
			  }
			  
			  conexion.closeConnection();
			  
		  } 
	  }
 }
  
  
 public static void main (String ourArgs[]) {
  Cutplace obj=new Cutplace();
}

}