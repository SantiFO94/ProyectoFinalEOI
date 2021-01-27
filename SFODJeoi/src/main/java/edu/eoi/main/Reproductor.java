package edu.eoi.main;

import org.jfugue.player.Player;

import edu.eoi.entity.Melodia;

public class Reproductor {

	private static final Player player = new Player();

	public static void reproducirMelodia(Melodia melodia) {
		
		if (null != melodia) {
			String secuenciaIntroducida = melodia.getSecuenciaIntroducida();
			String secuenciaMusical = GeneracionDeMusica.traducirSecuencia(secuenciaIntroducida);
			player.play(secuenciaMusical);
		}
		

	}

}
