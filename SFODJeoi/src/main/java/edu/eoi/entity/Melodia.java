package edu.eoi.entity;

public class Melodia {

	private Integer id;
	private String nombre;
	private String secuenciaIntroducida;
	private String secuenciaMusical;

	public Melodia(String nombre, String secuenciaIntroducida) {
		this.nombre = nombre;
		this.secuenciaIntroducida = secuenciaIntroducida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSecuenciaIntroducida() {
		return secuenciaIntroducida;
	}

	public void setSecuenciaIntroducida(String secuenciaIntroducida) {
		this.secuenciaIntroducida = secuenciaIntroducida;
	}

	public String getSecuenciaMusical() {
		return secuenciaMusical;
	}

	public void setSecuenciaMusical(String secuenciaMusical) {
		this.secuenciaMusical = secuenciaMusical;
	}

	@Override
	public String toString() {
		return "Melodia: " + this.nombre + " " + this.secuenciaMusical;
	}

	

}
