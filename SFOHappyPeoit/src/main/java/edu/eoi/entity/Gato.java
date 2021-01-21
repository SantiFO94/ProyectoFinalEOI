package edu.eoi.entity;

public class Gato extends Mascota{

	private Integer edad;

	public Gato(String imagen, String nombre, String ubicacion, String descripcion,
			String nombreResponsable, Integer telefonoResponsable, Integer edad) {
		super();
		this.tipoDeMascota = TipoDeMascota.GATO;
		this.edad = edad;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
}
