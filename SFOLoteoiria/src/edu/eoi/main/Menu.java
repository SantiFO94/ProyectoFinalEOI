package edu.eoi.main;

import java.util.Scanner;

public class Menu {

	private static final Scanner sctexto = new Scanner(System.in);

	public static boolean menuInicio() {
		boolean empezar = false;
		String instruccion = null;

		do {
			System.out.println("LOTEOIRIA: ¡SUERTE!\n");
			System.out.println("Introduzca \"Inicio\" para empezar el sorteo");
			System.out.println("Introduzca \"Salir\" para cerrar el programa");

			instruccion = sctexto.nextLine();

		} while (!instruccion.equalsIgnoreCase("Inicio") && !instruccion.equalsIgnoreCase("salir"));

		if (instruccion.equalsIgnoreCase("Inicio")) {
			empezar = true;
		} else {
			System.out.println("¡Hasta pronto!");
		}

		return empezar;
	}

	public static Consulta menuConsulta() {
		Consulta comando = null;
		boolean repetir = true;
		do {
			System.out.println("¿QUé quiere hacer?\n");
			System.out.println("-Consultar Premios (Introduzca: premios)");
			System.out.println("-Consultar Numeros Premiados (Introduzca: numeros)");
			System.out.println("-Comprobar Número (Introduzca: comprobar)");

			String comandoIntroducido = sctexto.nextLine();

			for (Consulta consulta : Consulta.values()) {
				if (comandoIntroducido.equalsIgnoreCase(consulta.toString())) {
					comando = consulta;
					repetir = false;
				}
			}
			if (comando == null) {
				System.out.println("Comando introducido incorrecto.\n");
			}
		} while (repetir);

		return comando;

	}

	public static Integer introducirNumero() {

		System.out.println("Introduzca su numero:");
		String numeroIntroducido = sctexto.nextLine();
		Integer numeroAceptado = null;
		System.out.println("COMPROBAR NÚMERO:".concat(numeroIntroducido));
		try {
			numeroAceptado = Integer.parseInt(numeroIntroducido);
			if (numeroAceptado < 0 || numeroAceptado > 99999) {

				@SuppressWarnings("unused")
				int provocarException = 1 / 0;
			}

		} catch (Exception e) {
			System.out.println("El numero introducido no es correcto, introduzca un número entre 0 y 99999.");
			introducirNumero();
		}

		return numeroAceptado;
	}

}
