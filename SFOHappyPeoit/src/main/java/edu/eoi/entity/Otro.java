package edu.eoi.entity;

public class Otro extends Mascota{

	public Otro(String imagen, String nombre, String ubicacion, String descripcion,
			Integer idResponsable, String edad) {
		super(imagen, nombre, ubicacion, descripcion, idResponsable);
		this.tipoDeMascota = TipoDeMascota.OTRO;
		this.edad = "No disponible";
	}

}
