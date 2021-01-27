package edu.eoi.enums;

public enum Comando {

	DIA("¿Qué día es?"),
	HORA("¿Qué hora es?"),
	CHISTE("Cuentame un chiste"),
	CALCULADORA("Calcula"),
	TRADUCTOR("Traduce"),
	AYUDA("Ayuda"),
	SALIR("Salir");
	
	public final String comando;
	
	private Comando(String comando) {
		this.comando = comando;
	}
	
}
