package edu.eoi.main;

import edu.eoi.service.MelodiaService;
import edu.eoi.ui.Instrucciones;
import edu.eoi.ui.MenuInicio;
import edu.eoi.utils.InputEnum;
import edu.eoi.utils.InputMelodia;

public class GestionMenu {
	
	private static MelodiaService MelodiaService = new MelodiaService();
	
	public static void elegirComando() {
			
		switch (InputEnum.introducirComando()) {
			case CREAR:
				InputMelodia.crearMelodia();
				MenuInicio.mostrarMenuInicio();
				break;
				
			case LISTA:
				GestionMelodias.mostrarMelodias(MelodiaService.recuperarMelodias());
				MenuInicio.mostrarMenuInicio();
				break;
				
			case REPRODUCIR:
				Reproductor.reproducirMelodia(GestionMelodias.buscarMelodia());
				MenuInicio.mostrarMenuInicio();
				break;
				
			case MODIFICAR:
				GestionMelodias.modificarMelodia();
				MenuInicio.mostrarMenuInicio();
				break;
				
			case ELIMINAR:
				GestionMelodias.eliminarMelodia();
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
