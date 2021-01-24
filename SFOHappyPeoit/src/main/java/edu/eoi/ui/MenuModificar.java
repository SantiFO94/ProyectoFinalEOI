package edu.eoi.ui;

import java.util.Scanner;

import edu.eoi.entity.Mascota;
import edu.eoi.service.MascotaService;

public class MenuModificar {

	static MascotaService MascotaService = new MascotaService();
	private static Scanner scnumero = new Scanner(System.in);

	public static void entrarMenuModificar() {

		System.out.println("Introduzca el id de la mascota que quiere modificar:");
		Integer idIntroducido = scnumero.nextInt();
		Mascota mascotaModificada = MascotaService.update(MascotaService.read(idIntroducido));

		System.out.println("La mascota modificada es:");
		System.out.println(mascotaModificada);

		MenuInicio.printMenuInicio();
	}

}
