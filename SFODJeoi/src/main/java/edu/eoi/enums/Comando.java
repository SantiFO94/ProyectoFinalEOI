package edu.eoi.enums;

public enum Comando {

	CREAR("Crear Melodía", "Crear Melodia", "Crear"),
	LISTA("Lista Melodías", "Lista Melodias", "Lista"),
	REPRODUCIR("Reproducir Melodía", "Reproducir Melodia", "Reproducir"),
	MODIFICAR("Modificar Melodía", "Modificar Meodia", "Modificar"),
	ELIMINAR("eliminar melodía", "eliminar melodia", "eliminar"),
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
