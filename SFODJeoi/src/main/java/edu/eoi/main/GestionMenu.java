package edu.eoi.main;

import edu.eoi.controller.ValidarNombre;
import edu.eoi.service.MelodiaService;
import edu.eoi.ui.Instrucciones;
import edu.eoi.utils.InputEnum;
import edu.eoi.utils.InputMelodia;

public class GestionMenu {
	
	private static MelodiaService MelodiaService = new MelodiaService();
	
	public static void elegirComando() {
		boolean repetir = true;
		do {
			String nombreIntroducido;
			switch (InputEnum.introducirComando()) {
			case CREAR:
				MelodiaService.guardarMelodia(InputMelodia.introducirDatosMelodia());
				break;
			case LISTA:
				MelodiaService.recuperarMelodias();
				break;
			case REPRODUCIR:
				Reproductor.reproducirMelodia();
				break;
			case MODIFICAR:
				nombreIntroducido =InputMelodia.buscarNombre();
				if(ValidarNombre.comprobarNombreExistente(nombreIntroducido)) {
					MelodiaService.actualizarMelodia(MelodiaService.buscarMelodia(InputMelodia.buscarNombre()));
				}else {
					System.out.println("Ese nombre no existe. \n");
				}
				break;
			case ELIMINAR:
				nombreIntroducido =InputMelodia.buscarNombre();
				if(ValidarNombre.comprobarNombreExistente(nombreIntroducido)) {
					MelodiaService.borrarMelodia(MelodiaService.buscarMelodia(InputMelodia.buscarNombre()));
				}else {
					System.out.println("Ese nombre no existe. \n");
				}
				break;
			case AYUDA:
				Instrucciones.mostrarGuias();
				break;
			case SALIR:
				repetir=false;
				break;
			}
		}while (repetir);
	}

	public static void elegirGuia() {
		switch (InputEnum.introducirGuia()) {
		case INSTRUCCIONES:
			Instrucciones.mostrarInstrucciones();
			break;
		case COMANDOS:
			Instrucciones.mostrarComandos();
			break;
		case TECLAS:
			Instrucciones.mostrarTeclasYNotasAsociadas();
			break;
		case INSTRUMENTOS:
			Instrucciones.mostrarInstrumentos();
			break;
		case TODO:
			Instrucciones.mostrarInstrucciones();
			Instrucciones.mostrarComandos();
			Instrucciones.mostrarTeclasYNotasAsociadas();
			Instrucciones.mostrarInstrumentos();
			break;
		}
	}
}
