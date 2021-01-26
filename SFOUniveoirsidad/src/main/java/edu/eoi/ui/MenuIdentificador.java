package edu.eoi.ui;

import edu.eoi.utils.Input;

public class MenuIdentificador {
		
	public static String menuIdentificador(String identificador){
		
		System.out.println("Introduzca el ".concat(identificador).concat(":"));
		identificador = Input.elegirIdentificador();
		
		return identificador;
	}

}
