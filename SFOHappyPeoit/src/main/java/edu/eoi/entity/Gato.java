package edu.eoi.entity;

public class Gato extends Mascota{


	public Gato(String imagen, String nombre, String ubicacion, String descripcion,
			Integer idResponsable, String edad) {
		super(imagen, nombre, ubicacion, descripcion, idResponsable, edad);
		this.tipoDeMascota = TipoDeMascota.GATO;
	}

	
}
