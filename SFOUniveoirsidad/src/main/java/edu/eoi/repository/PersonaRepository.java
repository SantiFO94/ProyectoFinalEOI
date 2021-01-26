package edu.eoi.repository;

import java.util.List;

import edu.eoi.pojo.Persona;

public class PersonaRepository{

//recoger el indice de la persona deseada en la lista
	public static int buscar(List<Persona> personas, String dni, String usuario) {
		int indice = -1;
		
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getDni().equalsIgnoreCase(dni)) {
				indice = i;
			}
		}
		if(indice == -1) {
			System.out.println("No se ha encontrado el usuario.");
		}
		return indice;
	}

	public static void borrar(List<Persona> personas, String dni, String usuario) {

		int indice = buscar(personas, dni, usuario);
		
		if(indice >= 0) {
			personas.remove(indice);
		}
	}

	public static boolean comprobarExistencia(List<Persona> personas, String dni, String usuario) {
		boolean repetir = false;
		for(Persona personaTemporal : personas) {
			if(personaTemporal.getDni().equalsIgnoreCase(dni)) {
				System.out.println("DNI ya existente.");
				repetir = true;
			}else if (personaTemporal.getUsuario().equalsIgnoreCase(usuario)) {
				System.out.println("Usuario ya existente.");
				repetir = true;
			}
		}
		return repetir;
	}
}
