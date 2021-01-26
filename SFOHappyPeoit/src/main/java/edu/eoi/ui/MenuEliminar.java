package edu.eoi.ui;

import edu.eoi.service.MascotaService;
import edu.eoi.utils.InputUtilities;

public class MenuEliminar {

	static MascotaService MascotaService = new MascotaService();

	public static void entrarMenuEliminar() {

		System.out.println("ELIMINAR MASCOTA");
		Integer idIntroducido = InputUtilities.introducirId();
		try {
			MascotaService.delete(MascotaService.read(idIntroducido));

		}catch (NullPointerException e) {
			System.out.println("Mascota no encontrada.\n");
		}

		MenuInicio.printMenuInicio();
	}

}
