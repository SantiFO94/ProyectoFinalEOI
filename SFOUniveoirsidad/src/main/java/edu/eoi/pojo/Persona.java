package edu.eoi.pojo;

public class Persona {

	protected String nombre;
	protected String apellidos;
	protected String dni;
	protected String correoElectronico;
	protected String usuario;
	protected String password;
	
	public Persona(String nombre, String apellidos, String dni,
			String correoElectronico, String usuario, String password) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.correoElectronico = correoElectronico;
		this.usuario = usuario;
		this.password = password;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public String getUsuario() {
		return usuario;
	}
	
	

}
