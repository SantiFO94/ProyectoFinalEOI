package edu.eoi.entity;

public class Perro extends Mascota {

	public Perro(String imagen, String nombre, String ubicacion, String descripcion,
			Integer idResponsable, String edad) {
		super(imagen, nombre, ubicacion, descripcion, idResponsable, edad);
		this.tipoDeMascota = TipoDeMascota.PERRO;
	}

}
