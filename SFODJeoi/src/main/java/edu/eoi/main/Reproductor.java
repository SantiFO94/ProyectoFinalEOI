package edu.eoi.main;

import org.jfugue.player.Player;

import edu.eoi.controller.ValidarNombre;
import edu.eoi.entity.Melodia;
import edu.eoi.service.MelodiaService;
import edu.eoi.utils.InputMelodia;

public class Reproductor {

	private static final MelodiaService MelodiaService = new MelodiaService();
	private static final Player player = new Player();
	
	public static void reproducirMelodia() {
		String nombreIntroducido = InputMelodia.buscarNombre();
		if(ValidarNombre.comprobarNombreExistente(nombreIntroducido)) {
			Melodia melodia = MelodiaService.buscarMelodia(nombreIntroducido);
			player.play(GeneracionDeMusica.traducirSecuencia(melodia.getSecuenciaIntroducida()));
		}else {
			System.out.println("Nombre no encontrado.");
		}
			
		
	}
	
}
