package edu.eoi.entity;

public class Gato extends Mascota{

	private String edad;

	public Gato(String imagen, String nombre, String ubicacion, String descripcion,
			Integer idResponsable, String edad) {
		super();
		this.tipoDeMascota = TipoDeMascota.GATO;
		this.edad = edad;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	
}
