package edu.eoi.repository;

import edu.eoi.ui.MenuBuscar;
import edu.eoi.ui.MenuCrear;
import edu.eoi.ui.MenuEliminar;
import edu.eoi.ui.MenuModificar;

public class MenuRepository {

	public static void elegirMenu(Comando comandoAceptado) {
		
		switch(comandoAceptado) {
			case ALTA:
				MenuCrear.entrarMenuCrear();
				break;
				
			case BUSCAR:
				MenuBuscar.entrarMenuBuscar();
				break;
				
			case MODIFICAR:
				MenuModificar.entrarMenuModificar();
				break;
				
			case ELIMINAR:
				MenuEliminar.entrarMenuEliminar();
				break;
				
			case GENERAR:
	
				break;
			
			case HELP:
				ComandoRepository.help();
				break;
			case SALIR:
				break;
		}	
	}
}
