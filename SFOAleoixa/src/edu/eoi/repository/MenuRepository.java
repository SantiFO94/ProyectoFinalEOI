package edu.eoi.repository;

public class MenuRepository {

	public static void elegirComando() {

		switch (ComandosRepository.introducirComando()) {

		case DIA:
			ComandosRepository.decirFecha();
			elegirComando();
			break;

		case HORA:
			ComandosRepository.decirHora();
			elegirComando();
			break;

		case CHISTE:
			ComandosRepository.contarChiste();
			elegirComando();
			break;

		case CALCULADORA:
			ComandosRepository.calcular();
			elegirComando();
			break;

		case TRADUCTOR:
			ComandosRepository.traducir();
			elegirComando();
			break;

		case AYUDA:
			ComandosRepository.help();
			elegirComando();
			break;

		case SALIR:
			System.out.println("¡Hasta pronto!");
			LoguearRepository.loguear("ALEOIXA", "¡Hasta pronto!");
			break;
		}
	}
}
