package edu.eoi.ui;

import java.util.Scanner;

import edu.eoi.entity.Mascota;
import edu.eoi.entity.Responsable;
import edu.eoi.service.MascotaService;
import edu.eoi.service.ResponsableService;

public class MenuBuscar {

	private static Scanner scnumero = new Scanner(System.in);
	static ResponsableService ResponsableService = new ResponsableService();
	static MascotaService MascotaService = new MascotaService();

	public static void entrarMenuBuscar() {

		System.out.println("BUSCAR MASCOTA");
		System.out.println("Introduzca el id de la mascota:");
		Integer idMascotaIntroducido = scnumero.nextInt();

		Mascota mascotaEncontrada = MascotaService.read(idMascotaIntroducido);
		Responsable responsableEncontrado = ResponsableService.read(mascotaEncontrada.getIdResponsable());

		System.out.println("Mascota: ".concat(mascotaEncontrada.getId().toString()).concat(" ")
				.concat(mascotaEncontrada.getTipoDeMascota().toString()).concat(" ")
				.concat(mascotaEncontrada.getNombre()).concat(" ").concat(mascotaEncontrada.getDescripcion())
				.concat(" ").concat(mascotaEncontrada.getUbicacion()));

		System.out.println("Responsable: ".concat(responsableEncontrado.getId().toString()).concat(" ")
				.concat(responsableEncontrado.getNombre()).concat(" ")
				.concat(responsableEncontrado.getTelefono().toString()));

		MenuInicio.printMenuInicio();

	}

}
