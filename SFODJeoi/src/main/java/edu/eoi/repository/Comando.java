package edu.eoi.repository;

public enum Comando {

	CREAR("Crear Melod�a", "Crear Melodia", "Crear"),
	LISTA("Lista Melod�as", "Lista Melodias", "Lista"),
	REPRODUCIR("Reproducir Melod�a", "Reproducir Melodia", "Reproducir"),
	ELIMINAR("eliminar melod�a", "eliminar melodia", "eliminar"),
	AYUDA("Ayuda", "help", "aide"),
	SALIR("salir", "salir", "salir");
	
	public final String comandoAcentuado;
	public final String comando;
	public final String comandoCorto;
	
	private Comando(String comandoAcentuado, String comando, String comandoCorto) {
		this.comandoAcentuado = comandoAcentuado;
		this.comando = comando;
		this.comandoCorto = comandoCorto;
	}

}
