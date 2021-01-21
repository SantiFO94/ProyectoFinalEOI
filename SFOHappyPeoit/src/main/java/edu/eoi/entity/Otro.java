package edu.eoi.entity;

public class Otro extends Mascota{

	public Otro(String imagen, String nombre, String ubicacion, String descripcion,
			String nombreResponsable, Integer telefonoResponsable, Integer edad) {
		super();
		this.tipoDeMascota = TipoDeMascota.OTRO;
	}

}
