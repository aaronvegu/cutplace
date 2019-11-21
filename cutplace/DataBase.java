package cutplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


 public class DataBase {
	
  private Connection apodaka=null;
  private Statement hola;
  final private String usuario="UUrVskyie9";
  final private String contrasena="aJKGskLkLr";
  final private String urlhost="jdbc:mysql://remotemysql.com/UUrVskyie9";
  
  private ResultSet resultado;
  
  protected boolean openConnection(){   //ESTE METODO BOOLEANO (PARA DEVOLVER TRUE OR FALSE) NOS HACE LA CONEXION DE LA BASE DE DATOS A LA APLICACION 
	  
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		  apodaka= DriverManager.getConnection(urlhost,usuario,contrasena);//en esta parte, estamos abriendo la conexion con los respectivos datos de la base de datos (checar linea 16 a 18)
		 
	      return true;/*Este return nos sirve como un break que nos brinca todo lo de abajo, ademas de que nos servira para cuando
		  lo utilizemos en el if que tenemos en la llamada de esta variable, ya que si es true, nos mandara directo a lo demas)*/
	  } 
	   catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		 e.printStackTrace();	//este catch nos lanzara la excepcion en consola si esta fallando, al igual que el otro catch que tenemos abajo.
	   } 
	   catch (SQLException e) {
		// TODO Auto-generated catch block
		 e.printStackTrace(); //si entra aqui, me manda error en consola y vale popo todo jaja salu2 
		JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION", "ERROR", JOptionPane.WARNING_MESSAGE);//este JOptionPane nos mandara un aviso al usuario diciendonos que hay un error en la conexion.
	    }  
	  return false;//si entra en los catch, nos retornara false y de esta manera no entrara lo demas, porque no tiene caso ya que no sirve :)
	  
  }
  
  
  protected void closeConnection(){//este metodo nada mas es para cerrar la conexion, ya que todo lo que abrimos lo tenemos que cerrar.
	  try {
		apodaka.close();//<-- linea para cerrar conexion:)
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  protected boolean addUser (String codigo, String mail, String pass){ //Metodo para agregar los usuarios a la base de datos, dandole que va a recibir como parametro Codigo de estudiante, email y contraseña, de igual manera, booleano (PARA DEVOLVER TRUE OR FALSE)
	  
	  try {
		  hola= apodaka.createStatement();
		  hola.executeUpdate("INSERT INTO registros(codigo, email, contrasenia) VALUES('"+codigo+"','"+mail+"','"+pass+"')"); 
		
		
		  /*Esta linea nos esta diciendo que insertemos EN la tabla llamada registros (y las columnas con su nombre)
		  * Los valores que recibio como parametro nuestro metodo (que son codigo, mail y pass)
		  */
		  hola.close();//cerramos el statement
		
		
	  } 
	   catch (SQLException e) {//si lo del try no funciona, caemos a nuestro bonito catch y nos mandara error 
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		return false;

	}//Crear/borrar/buscar/modificar (INVESTIGAR PARA NO VALER PITO DESPUES)
      
      
      //usar cuando vaya a usar para Crear/borrar/buscar/modificar
	  //INSERT INTO registros VALUES(null,'apodaka','apodaka123','teamoapodaka')
	  //INSERT INTO registros(nombre, usuario, contrasenia) VALUES('asdgñldfglfdld','sdaaskdskjfdf','teamlksdflkdsloapodaka')//FORMA DE AGREGAR EN CITA DE HEDDY :)
	  
	return true; //si en dado caso si crea todo y sale bien, nos lo dejara en true
	  
  }
 
 protected Usuario loginUser(String codigo, String pass) {//ahora si viene lo chidoooo (ingreso de usuarios)
	 
	 try {
		 hola= apodaka.createStatement();//comenzamos con un bonito statment 
		
	      resultado=hola.executeQuery("SELECT *  FROM registros WHERE codigo='"+codigo+"' AND contrasenia='"+pass+"'"); 
	     
	      /*esta linea nos permite BUSCAR en nuestra base de datos las cosas solicitadas
	       * Seleccionar *(todo) desde la tabla de registros, donde codigo(que esta en la tabla) es igual a el codigo que recibimos en parametros
	       * Y contrasenia(que esta en la tabla) es igual a el pass que recibimos en nuestros parametros.
	       */
	     
	       // while(resultado.next()){
	      if(resultado.next()) {
	    	  
	    	  Usuario usuario= new Usuario();
	    	  /*System.out.println(resultado.getInt(1));
	    	  System.out.println(resultado.getString(2));
	    	  System.out.println(resultado.getString(3));
	    	  System.out.println(resultado.getString(4));*/
	    		
	    	/*Resultado actúa como una lista con los datos encontrados de la base de datos, y con el next va tomando cada uno de los indices*/
	    		
	    	  System.out.println(resultado.getInt("idregistros"));
	    	  System.out.println(resultado.getString("codigo"));
	    	  System.out.println(resultado.getString("contrasenia"));
	    	  System.out.println(resultado.getString("email"));
	    	  
	    	  usuario.setIdregistros(resultado.getInt("idregistros"));//en esta parte estamos asignar cada valor del objeto "usuario" (checar clase Usuario) con un set, tomando el valor de la variable resultado y tomando el valor mediante el nombre del campo.
	    	  usuario.setCodigo(resultado.getString("codigo"));
	    	  usuario.setContrasenia(resultado.getString("contrasenia"));
	    	  usuario.setEmail(resultado.getString("email"));           /* TODO FUNCIONA IGUAL, CHECAR LINEA 144*/
	    	  usuario.setNombre(resultado.getString("nombre"));         /*NOTA MENTAL: en el get, especificar el dato que vamos a traer, si no dara error y chales*/
	    	  usuario.setProducto(resultado.getString("producto"));
	    	  usuario.setDescripcion(resultado.getString("descripcion"));
	    	  usuario.setTelefono(resultado.getString("telefono"));
	    	  
	    	  hola.close();
	    	  
	    	  return usuario;
	      }
	      
		
		
		
	}
	 catch (SQLException e) {
    		// TODO Auto-generated catch block
	    	e.printStackTrace();
		
	}//Crear/borrar/buscar/modificar (INVESTIGAR PARA NO VALER PITO DESPUES)
	 

   	return null;
 }
 
 protected ArrayList<Usuario> findall() { //Estamos haciendo un metodo que va a retornar una lista. (Este metodo busca toda la informacion en la tabla registros.
	 
	 ArrayList<Usuario> listausuarios= new ArrayList<Usuario>();//creamos la lista
	 
	 try { 
		 hola= apodaka.createStatement();//comenzamos con un bonito statment 
		
	      resultado=hola.executeQuery("SELECT *  FROM registros "); //esta query selecciona todo de la tabla registros. (el asterisco hace referencia a todo)
	      
	      while(resultado.next()) {  //resultado es una variable ResultSet, nos almacena cada uno de los renglones de la base de datos en forma de lista. con el next, recorre cada uno de los valores.
	    	  
	    	  Usuario usuario= new Usuario(); //creamos el objeto y lo invocamos juasjuas
	    	  
	    	  usuario.setIdregistros(resultado.getInt("idregistros"));//en esta parte estamos asignar cada valor del objeto "usuario" (checar clase Usuario) con un set, tomando el valor de la variable resultado y tomando el valor mediante el nombre del campo.
	    	  usuario.setCodigo(resultado.getString("codigo"));
	    	  usuario.setContrasenia(resultado.getString("contrasenia"));
	    	  usuario.setEmail(resultado.getString("email"));           /* TODO FUNCIONA IGUAL, CHECAR LINEA 144*/
	    	  usuario.setNombre(resultado.getString("nombre"));         /*NOTA MENTAL: en el get, especificar el dato que vamos a traer, si no dara error y chales*/
	    	  usuario.setProducto(resultado.getString("producto"));
	    	  usuario.setDescripcion(resultado.getString("descripcion"));
	    	  usuario.setTelefono(resultado.getString("telefono"));
	    	  
	    	  listausuarios.add(usuario);//En cada de iteracion del while, agregamos un nuevo usuario de esta lista
	      }
	      
	      hola.close();//cerramos statement 
		
	}
	 catch (SQLException e) {
 
	    	e.printStackTrace();  	
	 }
	 return listausuarios; //retornamos la lista (objeto)
 }
 


 
 protected Boolean updateUser(Usuario user) {
	 try {
		  hola= apodaka.createStatement();
		  hola.executeUpdate("UPDATE registros SET nombre='"+user.getNombre()+"',producto='"+user.getProducto()+"',descripcion='"+user.getDescripcion()+"',telefono='"+user.getTelefono()+"' WHERE idregistros='"+user.getIdregistros()+"'"); 
		  
		  hola.close();
		
		
	  } 
	   catch (SQLException e) {
		e.printStackTrace();
		
		return false;

	}
	  
	return true;
 }
	 
 }

