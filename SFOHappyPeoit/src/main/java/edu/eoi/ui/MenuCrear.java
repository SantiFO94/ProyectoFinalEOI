package edu.eoi.ui;

import java.util.Scanner;

import edu.eoi.entity.Mascota;
import edu.eoi.entity.Responsable;
import edu.eoi.service.MascotaService;
import edu.eoi.service.ResponsableService;
import edu.eoi.utils.InputUtilities;

public class MenuCrear {

	private static Scanner sctexto = new Scanner(System.in);
	static ResponsableService ResponsableService = new ResponsableService();
	static MascotaService MascotaService = new MascotaService();

	public static void entrarMenuCrear() {

		Responsable responsable = new Responsable(null, null, null);
		Mascota mascota;
		Integer idResponsableIntroducido = null;

		System.out.println("¿Responsable existente? (Si/No)");
		String existente = sctexto.nextLine();

		if (existente.equalsIgnoreCase("si")) {
			idResponsableIntroducido = InputUtilities.comprobarIDResponsable();

		} else if (existente.equalsIgnoreCase("no")) {
			responsable = InputUtilities.introducirDatosResponsable();
			ResponsableService.save(responsable);

			idResponsableIntroducido = responsable.getId();

		} else {
			System.out.println("Respuesta invalida, por favor introduzca \"SI\" o \"NO\".\n");
			entrarMenuCrear();
		}
		if (idResponsableIntroducido == null) {
			entrarMenuCrear();
		} else {
			mascota = InputUtilities.introducirDatosMascota(idResponsableIntroducido);
			MascotaService.save(mascota);
		}

		MenuInicio.printMenuInicio();
	}

}
