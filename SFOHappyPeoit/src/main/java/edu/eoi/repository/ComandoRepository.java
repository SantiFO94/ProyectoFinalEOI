package edu.eoi.repository;

import java.util.Scanner;

import edu.eoi.ui.MenuInicio;

public class ComandoRepository {
	
	private static Scanner sctexto= new Scanner(System.in);

	public static Comando introducirComando() {
		
		Comando comando = null;
		String instruccion = null;
		try {
			instruccion = sctexto.nextLine();
			
			for(Comando comandoTemporal : Comando.values()) {
				if (instruccion.equalsIgnoreCase(comandoTemporal.toString())) {
					comando = comandoTemporal;
				}else {
					int i = 1/0;
				}
			}
		} catch (Exception e) {
			System.out.println("El comando ".concat(instruccion).concat(" no es válido.\n"));
			introducirComando();
		}
		return comando;
	}
	
	public static void help() {

		System.out.println("Puedes pedirme cualquiera de estas cosas:\n");
		for (Comando comando : Comando.values()) {
			System.out.println(comando.comando);
		}
		System.out.println();
		MenuInicio.printMenuInicio();
	}
}
