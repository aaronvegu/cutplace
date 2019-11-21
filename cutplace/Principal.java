package cutplace;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JPanel implements ActionListener { //estamos extendiendo de JPanel para que tenga los atributos de la clase padre JPanel.
    
	private JFrame mainFrame;
	private JButton boton;
	public Usuario us; //Estamos declarando un usuario 
	
	
	public Principal principal_m(Usuario e, JFrame mainFrame){//Estamos generando un constructor, donde este recibira como parametro un objeto de tipo usuario
		
		this.mainFrame=mainFrame;
		us=e; //aqui estamos igualando nuestro "Usuario" con el usuario recibido 
		
		boton= new JButton("<html>"+"Nombre: "+us.getNombre()+"<br>"+"Producto: "+us.getProducto()+"</html>");//Estamos sacando el valor "nombre" y el correo de la variable "us"	HTML PARA EL ACOMODO DE LOS GET	
		boton.setIcon(null);/*CHECAR ESTO*/
		boton.setBorderPainted( false );
		boton.setBackground(new Color(204,222,145));
        boton.setLayout(new BorderLayout());
		boton.setBorderPainted( false );
		boton.setBackground(new Color(185,209,99));
		
		boton.addActionListener(this);
		add(boton);
		return this;
	} 
 public void addJFrameUser(JPanel panel, JFrame mainFrame) {
	 
	 ArrayList<Principal> listaprincipal= new ArrayList<Principal>(); //Creamos una variable de tipo lista el cual definimos que sera de tipo principal.
     ArrayList<Usuario> listausuarios;//pasa lo mismo de la linea de arriba pero con usuario
     
     DataBase coneccion= new DataBase();//creamos una clase de tipo database llamada coneccion
     coneccion.openConnection();
     listausuarios=coneccion.findall();  //mandamos a llamar sus metodos. (checar DataBase).
     coneccion.closeConnection();
     
     for(Usuario user: listausuarios) { /*este foreach tomara cada uno de los objetos que contiene lista usuarios en cada iteracion.
        
                                          el cual se le asignara a user*/
    	/* System.out.println(user.getNombre()); 
    	 System.out.println(user.getProducto());
    	 System.out.println(user.getDescripcion());  //estamos haciendo pruebas para ver si user contiene los datos.*/
    	 
    	 Principal obj= new Principal();
    	 
    	 listaprincipal.add(obj.principal_m(user,mainFrame));  //a la lista llamda "listaprincipal" le estamos agregndo un objeto de la clase "principal" el cual recibe de parametro un objeto de tipo usuario.
     }
  
     for(Principal e: listaprincipal) {  /*este foreach tomara cada uno de los objetos que contiene lista usuarios en cada iteracion.
                                           el cual se le asignara a user*/
    	 panel.add(e);//al frame la agregamos Principal que extiende de JPanel.
 
     }
 }
 
@Override
public void actionPerformed(ActionEvent e) {
	System.out.println(us.getNombre());
	
	mainFrame.dispose();
	Vendedor objVendedor= new Vendedor(us, mainFrame);
	/*reateSecond();*/
	//secondFrame.setVisible(true);

	
}
 
}
