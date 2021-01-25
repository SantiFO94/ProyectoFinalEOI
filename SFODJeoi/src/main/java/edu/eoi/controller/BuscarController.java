package edu.eoi.controller;

import java.util.Scanner;

import edu.eoi.service.MelodiaService;

public class BuscarController {

	private static Scanner scnumero = new Scanner(System.in);
	private static MelodiaService MelodiaService = new MelodiaService();

	public static Integer comprobarID() {
		Integer id = null;
		try {
			System.out.println("Introduzca el id de la melodía deseada:");
			id = scnumero.nextInt();

			if (MelodiaService.buscarMelodia(id).getId().equals(null)) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Ese id no se encuentra en nuestra base de datos.\n");
			id = null;
		}
		return id;
	}
}
