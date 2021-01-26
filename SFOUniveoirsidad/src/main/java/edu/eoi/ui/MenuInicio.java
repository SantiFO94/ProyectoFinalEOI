package edu.eoi.ui;

import edu.eoi.utils.Input;

public class MenuInicio {

	public static Accion menuInicio(){
		
		System.out.println("¿Qué quiere hacer con su usuario?\n"
				+ "-Crear\n"
				+ "-Consultar\n"
				+ "-Modificar\n"
				+ "-Eliminar\n"
				+ "-Salir\n");
		Accion accion = Input.elegirAccion();
		
		return accion;
			
	}
}
