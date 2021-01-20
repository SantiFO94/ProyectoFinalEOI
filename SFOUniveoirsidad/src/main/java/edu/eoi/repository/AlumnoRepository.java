package edu.eoi.repository;

import java.util.List;
import java.util.Scanner;

import edu.eoi.pojo.Alumno;
import edu.eoi.pojo.Persona;

public class AlumnoRepository implements CRUDable {

	private static final Scanner sctexto = new Scanner(System.in);
	
	public void crear(List<Persona> personas) {
		
		Persona persona = PersonaRepository.introducirDatos(personas, false, null, null);
		//repo general
		System.out.println("Introduzca la facultad:");
		String facultad = sctexto.nextLine();
		
		Alumno alumno=new Alumno(persona.getNombre(), persona.getApellidos(), persona.getDni(),
				persona.getCorreoElectronico(), persona.getUsuario(), persona.getPassword(), facultad);
		personas.add(alumno);

	}
	//general
	public int buscar(List<Persona> alumnos, String dni, String usuario) {

		int indice = -1;
		
		for(int i = 0; i < alumnos.size(); i++) {
			if(alumnos.get(i).getDni().equalsIgnoreCase(dni)) {
				indice = i;
			}else if (alumnos.get(i).getUsuario().equalsIgnoreCase(usuario)) {
				indice = i;
			}
		}
		return indice;

	}

	public void modificar(List<Persona> alumnos, String dni, String usuario) {
		int indice = buscar(alumnos, dni, usuario);
		
		System.out.println("Introduzca los nuevos datos:");
		
		Persona persona =  PersonaRepository.introducirDatos(alumnos, true, alumnos.get(indice).getDni(), alumnos.get(indice).getUsuario());
		System.out.println("Introduzca la facultad:");
		String facultad = sctexto.nextLine();
		Alumno alumno=new Alumno(persona.getNombre(), persona.getApellidos(), persona.getDni(),
				persona.getCorreoElectronico(), persona.getUsuario(), persona.getPassword(), facultad);
		
		alumnos.set(indice, alumno);
		
	}
	//general
	public void borrar(List<Persona> alumnos, String dni, String usuario) {
		
		int indice = buscar(alumnos, dni, usuario);
		
		if(indice >= 0) {
			alumnos.remove(indice);
		}
				
	}
	//general
	public void mostrar(List<Persona> personas, String dni, String usuario, String clase) {
		// TODO Auto-generated method stub
		
	}

}
