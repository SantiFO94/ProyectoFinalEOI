package edu.eoi.repository;

import edu.eoi.controller.BuscarController;
import edu.eoi.service.MelodiaService;
import edu.eoi.service.ReproductorService;
import edu.eoi.ui.Instrucciones;
import edu.eoi.ui.MenuInicio;
import edu.eoi.utils.InputUtilities;

public class MenuRepository {
	
	private static MelodiaService MelodiaService = new MelodiaService();
	private static ReproductorService ReproductorService = new ReproductorService();
	public static void elegirComando() {
		
		switch (InputUtilities.introducirComando()) {
		case CREAR:
			MelodiaService.guardarMelodia(MelodiaService.introducirDatosMelodia());
			MenuInicio.mostrarMenuInicio();
			break;
		case LISTA:
			MelodiaService.recuperarMelodias();
			MenuInicio.mostrarMenuInicio();
			break;
		case REPRODUCIR:
			ReproductorService. reproducirMelodia();
			MenuInicio.mostrarMenuInicio();
			break;
		case ELIMINAR:
			MelodiaService.borrarMelodia(MelodiaService.buscarMelodia(BuscarController.comprobarID()));
			MenuInicio.mostrarMenuInicio();
			break;
		case AYUDA:
			Instrucciones.mostrarGuias();
			MenuInicio.mostrarMenuInicio();
			break;
		case SALIR:

			break;
		}
	}

	public static void elegirGuia() {
		switch (InputUtilities.introducirGuia()) {
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
