package edu.eoi.main;
import org.jfugue.player.Player;

import edu.eoi.ui.MenuInicio;
public class MainDJapp {

	static final Player player = new Player();

	public static void main(String[] args) {

		System.out.println("Bienvenido a la DJEOI app\n");
		MenuInicio.mostrarMenuInicio();

	}
}
