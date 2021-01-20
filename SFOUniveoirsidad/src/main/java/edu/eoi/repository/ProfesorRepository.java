package edu.eoi.repository;

import java.util.List;
import java.util.Scanner;

import edu.eoi.pojo.Persona;
import edu.eoi.pojo.Profesor;

public class ProfesorRepository implements CRUDable {

	private static final Scanner sctexto = new Scanner(System.in);

	public void crear(List<Persona> personas) {
		Persona persona = PersonaRepository.introducirDatos(personas, false, null, null);
		
		System.out.println("Introduzca el despacho:");
		String despacho = sctexto.nextLine();
		
		Profesor profesor=new Profesor(persona.getNombre(), persona.getApellidos(), persona.getDni(),
				persona.getCorreoElectronico(), persona.getUsuario(), persona.getPassword(), despacho);
		personas.add(profesor);
		
	}
	//general
	public int buscar(List<Persona> profesores, String dni, String usuario) {

		int indice = -1;
		
		for(int i = 0; i < profesores.size(); i++) {
			if(profesores.get(i).getDni().equalsIgnoreCase(dni)) {
				indice = i;
			}else if (profesores.get(i).getUsuario().equalsIgnoreCase(usuario)) {
				indice = i;
			}
		}
		return indice;
	}
	//general
	public void borrar(List<Persona> profesores, String dni, String usuario) {
		int indice = buscar(profesores, dni, usuario);
		
		if(indice >= 0) {
			profesores.remove(indice);
		}
		
	}
	
	public void modificar(List<Persona> profesores, String dni, String usuario) {
		int indice = buscar(profesores, dni, usuario);
		
		System.out.println("Introduzca los nuevos datos:");
		
		Persona persona =  PersonaRepository.introducirDatos(profesores, true, profesores.get(indice).getDni(), profesores.get(indice).getUsuario());
		System.out.println("Introduzca el despacho:");
		String despacho = sctexto.nextLine();
		Profesor profesor=new Profesor(persona.getNombre(), persona.getApellidos(), persona.getDni(),
				persona.getCorreoElectronico(), persona.getUsuario(), persona.getPassword(), despacho);
		
		profesores.set(indice, profesor);
	}
	//general
	public void mostrar(List<Persona> personas, String dni, String usuario, String clase) {
		
	}

}
