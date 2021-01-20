package edu.eoi.pojo;

public class Alumno extends Persona {

	private String facultad;
	
	public Alumno(String nombre, String apellidos, String dni,
			String correoElectronico, String usuario, String password, String facultad) {
		super(nombre, apellidos, dni, correoElectronico, usuario, password);
		this.facultad = facultad;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	@Override
	public String toString() {
		return "Alumno " + this.nombre + ", dni=" + this.dni + ", usuario=" + this.usuario;
	}

	
}
