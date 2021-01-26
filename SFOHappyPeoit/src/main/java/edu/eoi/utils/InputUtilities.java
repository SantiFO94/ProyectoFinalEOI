package edu.eoi.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.eoi.controller.ComprobacionID;
import edu.eoi.entity.Gato;
import edu.eoi.entity.Mascota;
import edu.eoi.entity.Perro;
import edu.eoi.entity.Responsable;
import edu.eoi.main.ControlTipoDeMascota;
import edu.eoi.service.ResponsableService;

public class InputUtilities {
	
	private static Scanner sctexto = new Scanner(System.in);
	private static Scanner scnumero = new Scanner(System.in);
	static ResponsableService ResponsableService = new ResponsableService();

	public static Responsable introducirDatosResponsable() {
		Responsable responsable = new Responsable(null, null, null);
		
		System.out.println("CREACIÓN DE RESPONSABLE");
		
		Integer idResponsableAceptado = aceptarId();
		
		responsable.setId(idResponsableAceptado);
		System.out.println("Introduzca el nombre:");
		responsable.setNombre(sctexto.nextLine());
		System.out.println("Introduzca el numero de telefono:");
		responsable.setTelefono(scnumero.nextInt());
		
		return responsable;
	}
	
	public static Integer introducirId() {
		Integer id = 0;
		try {
			System.out.println("Introduzca el numero de identificacion:");
			id = scnumero.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("El id tiene que ser un número.\n");
		}
		
		return id;
	}
	public static Integer aceptarId() {
		Integer idResponsableAceptado = null;
		if(ComprobacionID.comprobarIDResponsableExiste(introducirId())) {
			System.out.println("ID ya existente, pruebe otro ID.\n");
			idResponsableAceptado = aceptarId();
		}
		return idResponsableAceptado;
	}

	public static Mascota introducirDatosMascota(Integer idResponsable) {

		System.out.println("CREACIÓN DE MASCOTA");
		System.out.println("Introduzca el tipo de mascota:");
		String tipoIntroducido = sctexto.nextLine();
		Mascota mascota = ControlTipoDeMascota.instanciarMascota(
						ControlTipoDeMascota.elegirTipo(tipoIntroducido));
		System.out.println("Introduzca el enlace a la imagen:");
		mascota.setImagen(sctexto.nextLine());
		System.out.println("Introduzca el nombre:");
		mascota.setNombre(sctexto.nextLine());
		System.out.println("Introduzca la ubicacion:");
		mascota.setUbicacion(sctexto.nextLine());
		System.out.println("Introduzca la descripcion:");
		mascota.setDescripcion(sctexto.nextLine());
		mascota.setIdResponsable(idResponsable);
		System.out.println("Introduzca la edad:");

		switch (mascota.getTipoDeMascota()) {
			case PERRO:
				((Perro)mascota).setEdad(sctexto.nextLine());
				break;
			case GATO:
				((Gato)mascota).setEdad(sctexto.nextLine());
				break;
			default:
				break;
			}

		return mascota;
	}
}
