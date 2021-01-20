package edu.eoi.app;

import java.util.Scanner;

public class MenuCrear {

	public static TipoUsuario menuCrear(Scanner sctexto){
		
		TipoUsuario tipoUsuario = null;
		
		System.out.println("Quiere crear un:\n"
				+ "-Profesor\n"
				+ "-Alumno\n"
				+ "-PAS\n");
		
		String tipoSeleccionado = sctexto.nextLine();
		
		for(TipoUsuario tipoTemporal : TipoUsuario.values()) {
			if (tipoSeleccionado.equalsIgnoreCase(tipoTemporal.toString())) {
				tipoUsuario = tipoTemporal;
			}
		}
		
		
		return tipoUsuario;
		
	}
}
