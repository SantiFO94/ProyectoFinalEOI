package edu.eoi.main;

import java.util.ArrayList;
import java.util.List;

import edu.eoi.entity.Premio;
import edu.eoi.service.PremioRepository;

public class MainApp {
	
	public static void main(String[] args) {
				
		if (Menu.menuInicio()) {
			
			List<Premio> premiosPrincipales = new ArrayList<Premio>();
			List<Premio> premiosAdyacentes = new ArrayList<Premio>();
			
			PremioRepository.crearPremiosPrincipales(premiosPrincipales);
			
			PremioRepository.asignarPremiosAdyacentes(premiosAdyacentes);
			
			PremioRepository.imprimirPremios();
			PremioRepository.imprimirTodosLosNumerosPremiados(premiosPrincipales);
			
			switch(Menu.menuConsulta()) {
			case PREMIOS:
				PremioRepository.imprimirPremios();
				break;
			case NUMEROS:
				PremioRepository.imprimirTodosLosNumerosPremiados(premiosPrincipales);
				break;
			case COMPROBAR:
				
				Integer numeroAceptado = Menu.introducirNumero();
				
				PremioRepository.evaluarNumeroAceptado(numeroAceptado, premiosPrincipales);
				
				break;
			}
			
		}
	}

}
