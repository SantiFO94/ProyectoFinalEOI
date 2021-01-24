package edu.eoi.ui;

import java.util.Scanner;

import edu.eoi.service.MascotaService;

public class MenuEliminar {

	static MascotaService MascotaService = new MascotaService();
	private static Scanner scnumero = new Scanner(System.in);

	public static void entrarMenuEliminar() {

		System.out.println("Introduzca el id de la mascota que quiere eliminar:");
		Integer idIntroducido = scnumero.nextInt();
		MascotaService.delete(MascotaService.read(idIntroducido));

		MenuInicio.printMenuInicio();
	}

}
