package edu.eoi.main;

import java.util.ArrayList;
import java.util.List;

import edu.eoi.domain.GestionPremio;
import edu.eoi.entity.Premio;
import edu.eoi.ui.Menu;

public class MainApp {
	
	public static void main(String[] args) {
				
		if (Menu.menuInicio()) {
			
			List<Premio> premiosPrincipales = new ArrayList<Premio>();
			
			GestionPremio.crearPremiosPrincipales(premiosPrincipales);
						
			GestionPremio.imprimirPremios();
			GestionPremio.imprimirTodosLosNumerosPremiados(premiosPrincipales);
			
			switch(Menu.menuConsulta()) {
			case PREMIOS:
				
				GestionPremio.imprimirPremios();
				break;
			case NUMEROS:
				
				GestionPremio.imprimirTodosLosNumerosPremiados(premiosPrincipales);
				break;
			case COMPROBAR:
				
				Integer numeroAceptado = Menu.introducirNumero();
				GestionPremio.evaluarNumeroAceptado(numeroAceptado, premiosPrincipales);
				break;
			}
			
		}
	}

}
