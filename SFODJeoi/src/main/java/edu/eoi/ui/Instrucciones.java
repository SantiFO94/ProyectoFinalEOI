package edu.eoi.ui;

import edu.eoi.repository.Comando;
import edu.eoi.repository.Instrumento;
import edu.eoi.repository.MenuRepository;

public class Instrucciones {

	public static void mostrarGuias() {
		System.out.println("�Qu� necesita? \n"
						+ "-Instrucciones \n"
						+ "-Comandos \n"
						+ "-Teclas \n"
						+ "-Todo \n");
		
		MenuRepository.elegirGuia();
	}
	
	public static void mostrarInstrucciones() {
		System.out.println("Para usar esta app primero tiene que elegir qu� quiere hacer con sus melodias.\n"
						+ "Para ello dispone de varios comandos que puede ver eligiendo la opci�n COMANDOS en el men� AYUDA. \n"
						+ "Puede: crear melod�as, ver una lista de melod�as y modificar o eliminar melod�as existentes. \n"
						+ "Para crear melod�as solo tiene que seleccionar la opcion CREAR MELOD�A en el menu de inicio. \n"
						+ "Luego se le pedir� que introduzca una secuencia de letras con su teclado, separadas por espacios. \n"
						+ "Cada letra corresponder� a una nota con una duraci�n determinada. \n"
						+ "Si tiene dudas sobre la correspondencia entre letras y notas, seleccione TECLAS en el men� AYUDA. \n"
						+ "Espero que estas instrucciones le hayan sido de ayuda. \n"
						+ "Disfrute de la DJEoi app. \n");
	}
	
	public static void mostrarComandos() {
		System.out.println("Estos son los COMANDOS disponibles: \n");
		
		for(Comando comando : Comando.values()) {
			System.out.println(comando);
		}
		System.out.println();
	}
	
	public static void mostrarTeclasYNotasAsociadas() {
		System.out.println("Estas son las relaciones entre teclas y notas: \n");
		System.out.println("   NEGRAS (1) \n"
						+"TECLAS \t NOTAS \n"
						+ "  A \t   Do \n"
						+ "  S \t   Re \n"
						+ "  D \t   Mi \n"
						+ "  F \t   Fa \n"
						+ "  G \t   Sol \n"
						+ "  H \t   La \n"
						+ "  J \t   Si \n"
						+"   BLANCAS (2)\n"
						+"TECLAS \t NOTAS \n"
						+ "  Q \t   Do \n"
						+ "  W \t   Re \n"
						+ "  E \t   Mi \n"
						+ "  R \t   Fa \n"
						+ "  T \t   Sol \n"
						+ "  Y \t   La \n"
						+ "  U \t   Si \n"
						+"   CORCHEAS (0.5)\n"
						+"TECLAS \t NOTAS \n"
						+ "  Z \t   Do \n"
						+ "  X \t   Re \n"
						+ "  C \t   Mi \n"
						+ "  V \t   Fa \n"
						+ "  B \t   Sol \n"
						+ "  N \t   La \n"
						+ "  M \t   Si \n");
	}
	public static void mostrarInstrumentos() {
		System.out.println("Estos son los INSTRUMENTOS disponibles: \n");
		
		for(Instrumento instrumento : Instrumento.values()) {
			System.out.println(instrumento);
		}
		System.out.println();
	}
}
