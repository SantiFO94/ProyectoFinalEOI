package edu.eoi.entity;

public class Perro extends Mascota {

	private Integer edad;

	public Perro(String imagen, String nombre, String ubicacion, String descripcion,
			String nombreResponsable, Integer telefonoResponsable, Integer edad) {
		super();
		this.tipoDeMascota = TipoDeMascota.PERRO;
		this.edad = edad;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
