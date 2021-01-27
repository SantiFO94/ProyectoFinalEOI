package edu.eoi.ui;

import edu.eoi.enums.TipoUsuario;
import edu.eoi.utils.Input;

public class MenuCrear {

	public static TipoUsuario menuCrear(){
		
		System.out.println("Introduzca el tipo de usuario que quiere crear:\n"
				+ "-Profesor\n"
				+ "-Alumno\n"
				+ "-PAS\n");
		
		TipoUsuario tipoUsuario = Input.elegirTipoUsuario();
		
		return tipoUsuario;
		
	}
}
