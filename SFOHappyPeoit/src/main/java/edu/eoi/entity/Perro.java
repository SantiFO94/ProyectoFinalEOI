package edu.eoi.entity;

public class Perro extends Mascota {

	private String edad;

	public Perro(String imagen, String nombre, String ubicacion, String descripcion,
			Integer idResponsable, String edad) {
		super();
		this.tipoDeMascota = TipoDeMascota.PERRO;
		this.edad = edad;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

}
