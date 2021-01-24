package edu.eoi.repository;

public enum Comando {
	
	ALTA("Alta mascota"),
	BUSCAR("Buscar mascota"),
	MODIFICAR("modificar mascota"),
	ELIMINAR("Eliminar mascota"),
	GENERAR("Generar informes"),
	HELP("ayuda"),
	SALIR("Salir");
	
	public final String comando;
	
	private Comando(String comando) {
		this.comando = comando;
	}
}
