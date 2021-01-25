package edu.eoi.ui;

import edu.eoi.repository.MenuRepository;

public class MenuInicio {

	public static void mostrarMenuInicio() {
		
		System.out.println("Elija una opcion: ");
		System.out.println("-Crear Melodía");
		System.out.println("-Lista Melodías");
		System.out.println("-Reproducir Melodía");
		System.out.println("-Eliminar Melodía");
		System.out.println("-Ayuda");
		System.out.println("-SALIR");
		
		MenuRepository.elegirComando();
		
	}
}
