package edu.eoi.ui;

import edu.eoi.main.GestionMenu;

public class MenuInicio {

	public static void mostrarMenuInicio() {
		
		System.out.println("Elija una opcion: ");
		System.out.println("-Crear Melod�a");
		System.out.println("-Lista Melod�as");
		System.out.println("-Modificar Melod�a");
		System.out.println("-Reproducir Melod�a");
		System.out.println("-Eliminar Melod�a");
		System.out.println("-Ayuda");
		System.out.println("-SALIR");
		
		GestionMenu.elegirComando();
		
	}
}
