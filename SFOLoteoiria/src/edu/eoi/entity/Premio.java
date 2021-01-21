package edu.eoi.entity;

public class Premio {

	private Integer dinero;
	private Integer numeroPremiado;
	
	public Premio(Integer dinero, Integer numeroPremiado) {
		this.dinero = dinero;
		this.numeroPremiado = numeroPremiado;
	}

	public Integer getDinero() {
		return dinero;
	}

	public void setDinero(Integer dinero) {
		this.dinero = dinero;
	}

	public Integer getNumeroPremiado() {
		return numeroPremiado;
	}

	public void setNumeroPremiado(Integer numeroPremiado) {
		this.numeroPremiado = numeroPremiado;
	}

	@Override
	public String toString() {
		return "Premio: " + this.dinero + ", numero: " + this.numeroPremiado;
	}

}
