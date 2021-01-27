package edu.eoi.controller;

import edu.eoi.service.ResponsableService;

public class ComprobacionID {
	
	static ResponsableService ResponsableService = new ResponsableService();
	
	public static boolean comprobarIDResponsableExiste(Integer id) {
		boolean existente = true;
			
		if (null == ResponsableService.read(id).getId()) {
			System.out.println("Ese id no se encuentra en nuestra base de datos.\n");
			existente = false;
		}else {
			System.out.println("Ese id ya existe.\n");

		}
		return existente;
	}
}
