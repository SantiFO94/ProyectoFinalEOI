package edu.eoi.app;

import java.util.Scanner;

public class MenuTipoBusqueda {

public static TipoBusqueda menuTipoBusqueda(Scanner sctexto){
		
		TipoBusqueda tipoBusqueda = null;
		
		System.out.println("Quiere buscar por:\n"
				+ "-DNI\n"
				+ "-Usuario\n");
		
		String tipoSeleccionado = sctexto.nextLine();
		
		for(TipoBusqueda tipoTemporal : TipoBusqueda.values()) {
			if (tipoSeleccionado.equalsIgnoreCase(tipoTemporal.toString())) {
				tipoBusqueda = tipoTemporal;
			}
		}
		
		
		return tipoBusqueda;
		
	}
}
