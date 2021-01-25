package edu.eoi.repository;

import org.jfugue.player.Player;

import edu.eoi.controller.BuscarController;
import edu.eoi.entity.Melodia;
import edu.eoi.service.MelodiaService;

public class ReproductorRepository {

	private static final MelodiaService MelodiaService = new MelodiaService();
	private static final Player player = new Player();
	
	public void reproducirMelodia() {
		
		Melodia melodia = MelodiaService.buscarMelodia(BuscarController.comprobarID());
		player.play(melodia.getSecuenciaMusical());
		
	}
	
}
