package edu.eoi.repository;

import java.util.List;
import java.util.Scanner;

import edu.eoi.pojo.Persona;
import edu.eoi.pojo.Profesor;

public class ProfesorRepository{

	private static final Scanner sctexto = new Scanner(System.in);

	public void guardar(List<Profesor> profesores, List<Persona> personas) {
		boolean repetir = true;

		String dni;
		String usuario;
		
		System.out.println("Introduzca el nombre:");
		String nombre = sctexto.nextLine();
		System.out.println("Introduzca los apellidos:");
		String apellidos = sctexto.nextLine();
		System.out.println("Introduzca el correo electrónico:");
		String correoElectronico = sctexto.nextLine();
		System.out.println("Introduzca la contraseña:");
		String password = sctexto.nextLine();
		System.out.println("Introduzca la despacho:");
		String despacho = sctexto.nextLine();
		
		do{
			
			System.out.println("Introduzca el dni:");
			dni = sctexto.nextLine();
			System.out.println("Introduzca el nombre de usuario (no podrá modificarlo):");
			usuario = sctexto.nextLine();

			repetir = PersonaRepository.comprobarExistencia(personas, dni, usuario);

		}while (repetir);

		Profesor profesor=new Profesor(nombre, apellidos, dni,
				correoElectronico, usuario, password, despacho);
		
		profesores.add(profesor);
		personas.add((Persona)profesor);
		
	}

	public int buscar(List<Profesor> profesores, String dni, String usuario) {

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

	public void borrar(List<Profesor> profesores, List<Persona> personas, String dni, String usuario) {
		try {
			int indice = buscar(profesores, dni, usuario);
	
			if(indice >= 0) {
				profesores.remove(indice);
			}
			PersonaRepository.borrar(personas, dni, usuario);
		}catch (NullPointerException e) {
			System.out.println("No se ha encontrado el profesor.");
		}
		
	}
	
	public void modificar(List<Profesor> profesores, List<Persona> personas, int indicePropio) {
		try {
	
			System.out.println("Introduzca los nuevos datos:");
			
			System.out.println("Introduzca el nombre:");
			String nombre = sctexto.nextLine();
			System.out.println("Introduzca los apellidos:");
			String apellidos = sctexto.nextLine();
			System.out.println("Introduzca el correo electrónico:");
			String correoElectronico = sctexto.nextLine();
			System.out.println("Introduzca la contraseña:");
			String password = sctexto.nextLine();
			System.out.println("Introduzca la despacho:");
			String despacho = sctexto.nextLine();
			
			Profesor profesor=new Profesor(nombre, apellidos, profesores.get(indicePropio).getDni(),
					correoElectronico, profesores.get(indicePropio).getUsuario(), password, despacho);
			
			profesores.set(indicePropio, profesor);
			
			int indicePersonas = PersonaRepository.buscar(personas, profesor.getDni(), null);
			personas.set(indicePersonas, (Persona)profesor);
			
		}catch (NullPointerException e) {
			System.out.println("No se ha encontrado el profesor.");
		}
	}
	
	public void mostrar(List<Profesor> profesores, String dni, String usuario) {
		try {
			int indice = buscar(profesores, dni, usuario);
			
			System.out.println("Profesor: " + profesores.get(indice).getNombre() + " " + profesores.get(indice).getApellidos() + " ");
			System.out.println("DNI: "+ profesores.get(indice).getDni() + ". Despacho: " + profesores.get(indice).getDespacho());
			System.out.println("Correo: "+ profesores.get(indice).getCorreoElectronico() + ". Usuario: " + profesores.get(indice).getUsuario());		
		}catch(IndexOutOfBoundsException e) {
			
		}
	}

}
