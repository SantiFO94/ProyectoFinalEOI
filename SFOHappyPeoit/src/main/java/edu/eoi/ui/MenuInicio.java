package edu.eoi.ui;

import edu.eoi.main.AccesoMenus;
import edu.eoi.main.Comando;
import edu.eoi.main.GestionComandos;

public class MenuInicio {

	public static void printMenuInicio() {
		
		System.out.println("HAPPY PEOIT\n");
		System.out.println("Elija una opcion:");
		System.out.println("-Alta mascota");
		System.out.println("-Buscar mascota");
		System.out.println("-Modificar mascota");
		System.out.println("-Eliminar mascota");
		System.out.println("-Generar Informes");
		System.out.println("-Salir");
		
		Comando comandoAceptado = GestionComandos.introducirComando();
		
		AccesoMenus.elegirMenu(comandoAceptado);
		
	}
	
}
