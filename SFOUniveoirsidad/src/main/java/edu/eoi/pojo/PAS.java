package edu.eoi.pojo;

public class PAS extends Persona {

	private Unidad unidad;
	
	public PAS(String nombre, String apellidos, String dni,
			String correoElectronico, String usuario, String password, Unidad unidad) {
		super(nombre, apellidos, dni, correoElectronico, usuario, password);
		this.unidad = unidad;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	@Override
	public String toString() {
		return "PAS " + this.nombre + ", dni=" + this.dni + ", usuario=" + this.usuario;
	}
}
