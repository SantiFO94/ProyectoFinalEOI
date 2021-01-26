package edu.eoi.ui;

import edu.eoi.utils.Input;

public class MenuTipoBusqueda {

	public static TipoBusqueda menuTipoBusqueda(){

		System.out.println("Quiere buscar por:\n"
				+ "-DNI\n"
				+ "-Usuario\n");

		TipoBusqueda tipoBusqueda = Input.elegirTipoBusqueda();
		return tipoBusqueda;

	}
}
