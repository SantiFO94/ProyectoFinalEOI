package edu.eoi.main;

public class GestionMenu {

	public static void elegirComando() {

		switch (GestionComandos.introducirComando()) {

		case DIA:
			GestionComandos.decirFecha();
			elegirComando();
			break;

		case HORA:
			GestionComandos.decirHora();
			elegirComando();
			break;

		case CHISTE:
			GestionComandos.contarChiste();
			elegirComando();
			break;

		case CALCULADORA:
			GestionComandos.calcular();
			elegirComando();
			break;

		case TRADUCTOR:
			GestionComandos.traducir();
			elegirComando();
			break;

		case AYUDA:
			GestionComandos.help();
			elegirComando();
			break;

		case SALIR:
			System.out.println("¡Hasta pronto!");
			Loguear.loguear("ALEOIXA", "¡Hasta pronto!");
			break;
		}
	}
}
