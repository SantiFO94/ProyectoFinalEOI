package edu.eoi.pojo;

public class Profesor extends Persona {

	private String despacho;
	
	public Profesor(String nombre, String apellidos, String dni,
			String correoElectronico, String usuario, String password, String despacho) {
		super(nombre, apellidos, dni, correoElectronico, usuario, password);
		this.despacho = despacho;
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	@Override
	public String toString() {
		return "Profesor " + this.nombre + ", dni=" + this.dni + ", usuario=" + this.usuario;
	}
}
