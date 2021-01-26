package edu.eoi.controller;

import edu.eoi.service.ResponsableService;

public class ComprobacionID {
	
	static ResponsableService ResponsableService = new ResponsableService();
	
	public static boolean comprobarIDResponsableExiste(Integer id) {
		boolean existente = true;
		try {
			
			if (ResponsableService.read(id).getId().equals(null)) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Ese id no se encuentra en nuestra base de datos.\n");
			id = null;
			existente = false;
		}
		return existente;
	}
}
