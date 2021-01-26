package edu.eoi.ui;

import java.util.Scanner;

import edu.eoi.controller.ComprobacionID;
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
		Integer idResponsableIntroducido = 0;
		Integer idResponsableAceptado = 0;
		
		System.out.println("¿Responsable existente? (Si/No)");
		String existente = sctexto.nextLine();

		if (existente.equalsIgnoreCase("si")) {
			
			idResponsableIntroducido = InputUtilities.introducirId();
			
			if(!ComprobacionID.comprobarIDResponsableExiste(idResponsableIntroducido)) {
				System.out.println("ID no encontrado.\n");
			}else {
				idResponsableAceptado = idResponsableIntroducido;
			}
			
		} else if (existente.equalsIgnoreCase("no")) {
			responsable = InputUtilities.introducirDatosResponsable();
			ResponsableService.save(responsable);

			idResponsableAceptado = responsable.getId();

		} else {
			System.out.println("Respuesta invalida, por favor introduzca \"SI\" o \"NO\".\n");
			entrarMenuCrear();
		}
		if (idResponsableAceptado == 0) {
			System.out.println("Creacion anulada.\n");
		} else {
			mascota = InputUtilities.introducirDatosMascota(idResponsableAceptado);
			MascotaService.save(mascota);
		}

		MenuInicio.printMenuInicio();
	}

}
