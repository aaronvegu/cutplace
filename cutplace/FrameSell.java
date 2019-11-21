package cutplace;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrameSell extends JFrame implements ActionListener {

	private Usuario us;
	
	private JTextField nombre, producto, descripcion, telefono;
    private JLabel nombreE, productoE, descripcionE, telefonoE; //AGREGAR ETIQUETAS
    private JButton boton,boton2;
	
	public FrameSell(Usuario us){
		
		this.us=us;
		System.out.print("?"+us.getNombre());
		
		JButton boton= new JButton("Guardar Cambios");
		boton.addActionListener(this);
		JButton boton2=new JButton("Atras");
		boton2.addActionListener(this);
		
		
		
		
		nombre= new JTextField(us.getNombre());
		producto= new JTextField(us.getProducto());
	    descripcion= new JTextField(us.getDescripcion());
	   	telefono= new JTextField(us.getTelefono());
	   	
	   	nombreE= new JLabel("Nombre");
	   	nombreE.setFont(new Font("",Font.PLAIN,10));
	   	productoE= new JLabel("Producto");
	   	productoE.setFont(new Font("",Font.PLAIN,10));
	   	descripcionE= new JLabel("Descripcion de lo que vendes");
	   	descripcionE.setFont(new Font("",Font.PLAIN,10));
	   	telefonoE= new JLabel("Ingresar tu telefono (10 digitos, si se pasan de 10 caracteres no se realizara su registro)");
	   	telefonoE.setFont(new Font("",Font.PLAIN,10));
	   	
	   	setLayout(new GridLayout(12,1,2,2));
	   	
	   	add(nombreE);
	   	add(nombre);
	   	
	   	add(productoE);
	   	add(producto);
	   	
	   	add(descripcionE);
	   	add(descripcion);
	   	
	   	add(telefonoE);
	   	add(telefono);
	   	add(boton);
	   	add(boton2);
				
		setVisible(true);
		setSize(480,720);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==boton) {
		Usuario usuario= new Usuario();
		usuario.setIdregistros(us.getIdregistros());
		usuario.setCodigo(us.getCodigo());
		usuario.setContrasenia(us.getContrasenia());
		usuario.setEmail(us.getEmail());
		usuario.setNombre(nombre.getText());
		usuario.setProducto(producto.getText());
		usuario.setDescripcion(descripcion.getText());
		usuario.setTelefono(telefono.getText());
		
		DataBase coneccion= new DataBase();//creamos una clase de tipo database llamada coneccion
	     coneccion.openConnection();
	     coneccion.updateUser(usuario);  //mandamos a llamar sus metodos. (checar DataBase).
	     coneccion.closeConnection();
			System.out.println("se oprimio boton");
		}
		
		else if(e.getActionCommand()=="Atras") {
			System.out.println("se oprimio boton2");
			dispose();
		}
		

		
	}
	
	

}
