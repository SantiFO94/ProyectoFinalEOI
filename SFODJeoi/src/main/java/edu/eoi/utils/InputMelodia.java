package edu.eoi.utils;

import java.util.Scanner;

import edu.eoi.controller.ValidarNombre;
import edu.eoi.entity.Melodia;
import edu.eoi.enums.Instrumento;
import edu.eoi.main.GeneracionDeMusica;
import edu.eoi.main.Reproductor;
import edu.eoi.service.MelodiaService;

public class InputMelodia {

	private static Scanner sctexto = new Scanner(System.in);
	private static MelodiaService MelodiaService = new MelodiaService();

	public static void crearMelodia() {

		Melodia melodia = introducirDatosMelodia();
		boolean repetir = true;
		String eleccion = "";
		do {
			System.out.println("¿Quiere guardar la melodia? Si/No");
			eleccion = sctexto.nextLine();
		
			if (eleccion.equalsIgnoreCase("si")) {
				MelodiaService.guardar(melodia);
				repetir = false;

			} else if (eleccion.equalsIgnoreCase("no")) {
				repetir = false;
			} else {
				System.out.println("No te he entendido, por favor introduce SI o NO.");
			}
		} while (repetir);

		repetir = true;
		do {
			System.out.println("¿Quiere escuchar la melodia? Si/No");
			eleccion = sctexto.nextLine();
			
			if (eleccion.equalsIgnoreCase("si")) {
				Reproductor.reproducirMelodia(melodia);
				repetir = false;
			
			} else if (eleccion.equalsIgnoreCase("no")) {
				repetir = false;
			} else {
				System.out.println("No te he entendido, por favor introduce SI o NO.");
			}
		} while (repetir);

	}

	public static Melodia introducirDatosMelodia() {

		Melodia melodia = new Melodia(null, null);
		System.out.println("CREACIÓN DE MELODÍA");
		System.out.println("Introduzca el nombre de la melodía:");
		String nombre = sctexto.nextLine();
		
		if (!ValidarNombre.comprobarNombreExistente(nombre)) {
			melodia.setNombre(nombre);
			melodia.setSecuenciaIntroducida(introducirSecuencia());
		
		} else {
			System.out.println("Ese nombre ya existe, escoja otro por favor.\n");
			melodia = introducirDatosMelodia();
		}

		return melodia;
	}

	public static String introducirNombre() {
		
		System.out.println("Introduzca el nombre de la melodía:");
		String nombreIntroducido = sctexto.nextLine();

		return nombreIntroducido;
	}

	public static String introducirSecuencia() {
		
		System.out.println("Introduzca la secuencia de letras:");
		String secuenciaIntroducida = sctexto.nextLine();
		
		if (secuenciaIntroducida.length() > 200) {
			System.out.println("Su secuencia es demasiado larga," + " solo puede tener 200 caracteres. \n"
					+ "Introduzca una secuencia más corta, por favor. \n");
			secuenciaIntroducida = introducirSecuencia();
		}

		return secuenciaIntroducida;
	}

	public static String introducirInstrumento() {

		System.out.println("¿Quiere elegir instrumento? SI/NO");
		String eleccion = sctexto.nextLine();
		String instrumentoElegido = " ";
		
		if (eleccion.equalsIgnoreCase("si")) {
			System.out.println("¿Qué instrumento quiere?");
			
			for (Instrumento instrumento : Instrumento.values()) {
				System.out.print(instrumento.toString().concat(" "));
			}
			System.out.println();
			String instrumentoIntroducido = sctexto.nextLine();
			instrumentoElegido = GeneracionDeMusica.elegirInstrumento(instrumentoIntroducido);
		
		} else if (!eleccion.equalsIgnoreCase("no")) {
			System.out.println("No te he entendido, por favor introduce SI o NO.");
			instrumentoElegido = introducirInstrumento();
		}

		return instrumentoElegido;
	}

}
