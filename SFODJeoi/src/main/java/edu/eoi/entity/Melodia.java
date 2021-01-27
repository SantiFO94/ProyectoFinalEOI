package edu.eoi.entity;

public class Melodia {

	private String nombre;
	private String secuenciaIntroducida;

	public Melodia(String nombre, String secuenciaIntroducida) {
		this.nombre = nombre;
		this.secuenciaIntroducida = secuenciaIntroducida;
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

	@Override
	public String toString() {
		return "Melodia: " + this.nombre + " " + this.secuenciaIntroducida;
	}

	

}
