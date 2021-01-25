package edu.eoi.utils;

import java.util.Scanner;

import edu.eoi.entity.Gato;
import edu.eoi.entity.Mascota;
import edu.eoi.entity.Perro;
import edu.eoi.entity.Responsable;
import edu.eoi.repository.TipoDeMascotaRepository;
import edu.eoi.service.ResponsableService;

public class InputUtilities {
	
	private static Scanner sctexto = new Scanner(System.in);
	private static Scanner scnumero = new Scanner(System.in);
	static ResponsableService ResponsableService = new ResponsableService();

	public static Responsable introducirDatosResponsable() {

		Responsable responsable = new Responsable(null, null, null);
		System.out.println("CREACIÓN DE RESPONSABLE");
		System.out.println("Introduzca el numero de identificacion:");
		responsable.setId(scnumero.nextInt());
		System.out.println("Introduzca el nombre:");
		responsable.setNombre(sctexto.nextLine());
		System.out.println("Introduzca el numero de telefono:");
		responsable.setTelefono(scnumero.nextInt());

		return responsable;
	}
	
	
	public static Mascota introducirDatosMascota(Integer idResponsable) {

		System.out.println("CREACIÓN DE MASCOTA");
		System.out.println("Introduzca el tipo de mascota:");
		String tipoIntroducido = sctexto.nextLine();
		Mascota mascota = TipoDeMascotaRepository.instanciarMascota(
						TipoDeMascotaRepository.elegirTipo(tipoIntroducido));
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
	//esto iria a controller?
	public static Integer comprobarIDResponsable() {
		Integer idResponsableIntroducido = null;
		try {
			System.out.println("Introduzca el id del responsable:");
			idResponsableIntroducido = scnumero.nextInt();

			if (ResponsableService.read(idResponsableIntroducido).getId().equals(null)) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Ese id no se encuentra en nuestra base de datos.\n");
			idResponsableIntroducido = null;
		}
		return idResponsableIntroducido;
	}
}
