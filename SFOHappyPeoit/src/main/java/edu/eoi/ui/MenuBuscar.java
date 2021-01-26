package edu.eoi.ui;

import edu.eoi.entity.Mascota;
import edu.eoi.entity.Responsable;
import edu.eoi.service.MascotaService;
import edu.eoi.service.ResponsableService;
import edu.eoi.utils.InputUtilities;

public class MenuBuscar {

	static ResponsableService ResponsableService = new ResponsableService();
	static MascotaService MascotaService = new MascotaService();

	public static void entrarMenuBuscar() {

		System.out.println("BUSCAR MASCOTA");
		Integer idMascotaIntroducido = InputUtilities.introducirId();

		Mascota mascotaEncontrada = MascotaService.read(idMascotaIntroducido);
		try {
			Responsable responsableEncontrado = ResponsableService.read(mascotaEncontrada.getIdResponsable());
	
			System.out.println("Mascota: ".concat(mascotaEncontrada.getId().toString()).concat(" ")
					.concat(mascotaEncontrada.getTipoDeMascota().toString()).concat(" ")
					.concat(mascotaEncontrada.getNombre()).concat(" ")
					.concat(mascotaEncontrada.getEdad()).concat(" ")
					.concat(mascotaEncontrada.getDescripcion()).concat(" ")
					.concat(mascotaEncontrada.getUbicacion()));
	
			System.out.println("Responsable: ".concat(responsableEncontrado.getId().toString()).concat(" ")
					.concat(responsableEncontrado.getNombre()).concat(" ")
					.concat(responsableEncontrado.getTelefono().toString()));
		}catch (NullPointerException e) {
			System.out.println("Mascota no encontrada.\n");
		}
		MenuInicio.printMenuInicio();

	}

}
