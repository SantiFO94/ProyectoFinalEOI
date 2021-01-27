package edu.eoi.enums;

public enum Guia {

	INSTRUCCIONES("INSTRUCCIONES"),
	COMANDOS("COMANDOS"),
	TECLAS("TECLAS"),
	INSTRUMENTOS("INSTRUMENTOS"),
	TODO("TODO");
	
	public final String guia;

	private Guia(String guia) {
		this.guia = guia;
	}
	
}
