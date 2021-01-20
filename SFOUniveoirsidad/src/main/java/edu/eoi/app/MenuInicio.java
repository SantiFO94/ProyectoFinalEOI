package edu.eoi.app;

import java.util.Scanner;

public class MenuInicio {

	public static Accion menuInicio(Scanner sctexto){
		Accion accion = null;
		
		System.out.println("¿Qué quiere hacer con su usuario?\n"
				+ "-Crear\n"
				+ "-Consultar\n"
				+ "-Modificar\n"
				+ "-Eliminar\n"
				+ "-Salir\n");
		
		String seleccion = sctexto.nextLine();
		
		for(Accion accionTemporal : Accion.values()) {
			if (seleccion.equalsIgnoreCase(accionTemporal.toString())) {
				accion = accionTemporal;
			}
		}
		return accion;
		
	}
}
