package edu.eoi.controller;

import edu.eoi.service.MelodiaService;

public class ValidarNombre {

	private static MelodiaService MelodiaService = new MelodiaService();

	public static boolean comprobarNombreExistente(String nombre) {
	boolean existe = false;
	
	if (MelodiaService.read(nombre).getNombre() != null) {
		existe= true;
	}
	
	return existe;
	}
}
