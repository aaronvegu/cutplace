package cutplace;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrameSell extends JFrame implements ActionListener {

	private Usuario us;
	
	private JTextField nombre, producto, descripcion, telefono;
    private JLabel nombreE, productoE, descripcionE, telefonoE; //AGREGAR ETIQUETAS
    private JButton boton;
	
	public FrameSell(Usuario us){
		
		this.us=us;
		System.out.print("?"+us.getNombre());
		
		JButton boton= new JButton("Guardar Cambios");
		boton.addActionListener(this);
		
		nombre= new JTextField(us.getNombre());
		producto= new JTextField(us.getProducto());
	    descripcion= new JTextField(us.getDescripcion());
	   	telefono= new JTextField(us.getTelefono());
	   	
	   	setLayout(new GridLayout(8,1,5,5));
	   	
	   	
	   	add(nombre);
	   	add(producto);
	   	add(descripcion);
	   	add(telefono);
	   	add(boton);
		
		
		
		
		
		
		setVisible(true);
		setSize(480,720);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
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

		
	}
	
	

}
