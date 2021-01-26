package edu.eoi.ui;

import edu.eoi.entity.Mascota;
import edu.eoi.service.MascotaService;
import edu.eoi.utils.InputUtilities;

public class MenuModificar {

	static MascotaService MascotaService = new MascotaService();

	public static void entrarMenuModificar() {

		System.out.println("MODIFICAR MASCOTA");
		Integer idIntroducido = InputUtilities.introducirId();
		try {
			Mascota mascotaModificada = MascotaService.update(MascotaService.read(idIntroducido));
	
			System.out.println("La mascota modificada es:");
			System.out.println(mascotaModificada);
		}catch (NullPointerException e) {
			System.out.println("Mascota no encontrada.\n");
		}
		MenuInicio.printMenuInicio();
	}

}
