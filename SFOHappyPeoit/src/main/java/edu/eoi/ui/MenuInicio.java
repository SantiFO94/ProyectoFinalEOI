package edu.eoi.ui;

import edu.eoi.repository.Comando;
import edu.eoi.repository.ComandoRepository;
import edu.eoi.repository.MenuRepository;

public class MenuInicio {

	public static void printMenuInicio() {
		
		System.out.println("HAPPY PEOIT\n");
		System.out.println("Elija una opcion:");
		System.out.println("-Alta mascota");
		System.out.println("-Busca mascota");
		System.out.println("-Modifica mascota");
		System.out.println("-Eliminar mascota");
		System.out.println("-Generar Informes");
		System.out.println("-Salir");
		
		Comando comandoAceptado = ComandoRepository.introducirComando();
		
		MenuRepository.elegirMenu(comandoAceptado);
		
	}
	
}
