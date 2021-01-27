package edu.eoi.main;

import edu.eoi.enums.Instrumento;
import edu.eoi.enums.NotaEnTeclado;
import edu.eoi.utils.InputMelodia;

public class GeneracionDeMusica {

	public static String traducirSecuencia(String secuenciaIntroducida) {

		String secuenciaMusical = null;
		String[] secuenciaIntroducidaSeparada = secuenciaIntroducida.toLowerCase().split("");

		for (int i = 0; i < secuenciaIntroducidaSeparada.length; i++) {
			if (secuenciaIntroducidaSeparada[i].matches("\\D+") && secuenciaIntroducidaSeparada[i].matches("\\w+")) {
				secuenciaIntroducidaSeparada[i] = "$".concat(secuenciaIntroducidaSeparada[i]);
			} else {
				secuenciaIntroducidaSeparada[i] = "";
			}

		}
		secuenciaIntroducida = String.join(" ", secuenciaIntroducidaSeparada);

		for (NotaEnTeclado nota : NotaEnTeclado.values()) {
			secuenciaIntroducida = secuenciaIntroducida.replace("$".concat(nota.letra), nota.nota);
		}
		// revisar si este $ es necesario
		secuenciaMusical = secuenciaIntroducida.replace("$", "").concat(" ");
		String instrumento = InputMelodia.introducirInstrumento();
		if (null != instrumento) {
			secuenciaMusical = instrumento.concat(secuenciaMusical);
		}
		
		return secuenciaMusical;
	}

	public static String elegirInstrumento(String instrumentoIntroducido) {
		String instrumentoElegido = null;
		for (Instrumento instrumento : Instrumento.values()) {
			if (instrumentoIntroducido.equalsIgnoreCase(instrumento.toString())) {
				instrumentoElegido = instrumento.codigoInstrumento;
			}
		}
		if (null != instrumentoElegido) {
			System.out.println("Ese instrumento no está disponible.");
		}
		return instrumentoElegido;
	}
}
