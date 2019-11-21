package cutplace;

public class Usuario {//Almacena los datos de la base de datos (checar Clase database), estos objetos deberian de llamarse como a la tabla que hacemos referencia.

	private int idregistros;
	private String codigo;
	private String email;
	private String contrasenia;
	private String nombre;
	private String producto; //Variables de los campos de la base de datos (checar base de datos en heidi para mayor comprension)
	private String descripcion;
	private String telefono;
	
	public Usuario() {
		
	}

	public Usuario(int idregistros, String codigo, String email, String contrasenia, String nombre, String producto,
			String descripcion, String telefono) { //Este constructor nos esta tomando las variables de la base de datos(checar comentario de arriba)

		this.idregistros = idregistros;
		this.codigo = codigo;
		this.email = email;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.producto = producto;
		this.descripcion = descripcion;
		this.telefono = telefono;
		

	}

	public int getIdregistros() {
		return idregistros;
	}

	public void setIdregistros(int idregistros) {
		this.idregistros = idregistros;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {                         //Retornamos los valores que tenemos en privado <3
		                                              //apodaka es un crack
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
