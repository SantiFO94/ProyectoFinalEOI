package edu.eoi.app;

import java.util.Scanner;

public class MenuIdentificador {
		
	public static String menuIdentificador(Scanner sctexto, String identificador){
		System.out.println("Introduzca el ".concat(identificador).concat(":"));
		identificador = sctexto.nextLine();
		return identificador;
	}

}
