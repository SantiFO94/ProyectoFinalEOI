package edu.eoi.repository;

public enum Comando {
	
	ALTA("Alta mascota"),
	BUSCAR("Busca mascota"),
	MODIFICAR("modifica mascota"),
	ELIMINAR("Elimina mascota"),
	GENERAR("Genera informes"),
	HELP("ayuda"),
	SALIR("Salir");
	
	public final String comando;
	
	private Comando(String comando) {
		this.comando = comando;
	}
}
