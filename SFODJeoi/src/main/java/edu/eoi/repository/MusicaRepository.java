package edu.eoi.repository;

import edu.eoi.utils.InputMelodiaUtilities;

public class MusicaRepository {

	public String traducirSecuencia(String secuenciaIntroducida) {

		String secuenciaMusical = null;
		String[] secuenciaIntroducidaSeparada = secuenciaIntroducida.toLowerCase().split(" ");
		for (int i = 0; i < secuenciaIntroducidaSeparada.length; i++) {
			secuenciaIntroducidaSeparada[i] = "$".concat(secuenciaIntroducidaSeparada[i]);
		}
		secuenciaIntroducida = String.join(" ", secuenciaIntroducidaSeparada);

		for (NotaEnTeclado nota : NotaEnTeclado.values()) {
			secuenciaIntroducida = secuenciaIntroducida.replace("$".concat(nota.letra), nota.nota);
		}
		//revisar si este $ es necesario
		secuenciaMusical = secuenciaIntroducida.replace("$", "").concat(" ");
		secuenciaMusical = InputMelodiaUtilities.introducirInstrumento().concat(secuenciaMusical);
		return secuenciaMusical;
	}

	public String elegirInstrumento(String instrumentoIntroducido) {
		String instrumentoElegido = null;
		for (Instrumento instrumento : Instrumento.values()) {
			if (instrumentoIntroducido.equalsIgnoreCase(instrumento.toString())) {
				instrumentoElegido = instrumento.codigoInstrumento;
			}
		}
		return instrumentoElegido;
	}
}
