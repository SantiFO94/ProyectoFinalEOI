package edu.eoi.repository;

import java.util.List;
import java.util.Scanner;

import edu.eoi.pojo.Alumno;
import edu.eoi.pojo.Persona;

public class AlumnoRepository {

	private static final Scanner sctexto = new Scanner(System.in);
	
	public void guardar(List<Alumno> alumnos, List<Persona> personas) {
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
		System.out.println("Introduzca la facultad:");
		String facultad = sctexto.nextLine();
		
		do{
			
			System.out.println("Introduzca el dni:");
			dni = sctexto.nextLine();
			System.out.println("Introduzca el nombre de usuario (no podrá modificarlo):");
			usuario = sctexto.nextLine();
			repetir = PersonaRepository.comprobarExistencia(personas, dni, usuario);
			
		}while (repetir);
		
		Alumno alumno = new Alumno(nombre, apellidos, dni, correoElectronico, usuario, password, facultad);

		alumnos.add(alumno);
		personas.add((Persona)alumno);

	}
	
	public int buscar(List<Alumno> alumnos, String dni, String usuario) {

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

	public void modificar(List<Alumno> alumnos, List<Persona> personas, int indicePropio) {
		try {

			System.out.println("Introduzca los nuevos datos");
			
			System.out.println("Introduzca el nombre:");
			String nombre = sctexto.nextLine();
			System.out.println("Introduzca los apellidos:");
			String apellidos = sctexto.nextLine();
			System.out.println("Introduzca el correo electrónico:");
			String correoElectronico = sctexto.nextLine();
			System.out.println("Introduzca la contraseña:");
			String password = sctexto.nextLine();
			System.out.println("Introduzca la facultad:");
			String facultad = sctexto.nextLine();
			
			Alumno alumno=new Alumno(nombre, apellidos, alumnos.get(indicePropio).getDni(),
					correoElectronico,  alumnos.get(indicePropio).getUsuario(), password, facultad);
		//reemplazar los antiguos datos por los nuevos
			alumnos.set(indicePropio, alumno);
			int indicePersonas = PersonaRepository.buscar(personas, alumno.getDni(), null);

			personas.set(indicePersonas, (Persona)alumno);

		}catch (NullPointerException e) {
			System.out.println("No se ha encontrado el alumno.");
		}
		
	}

	public void borrar(List<Alumno> alumnos, List<Persona> personas, String dni, String usuario) {
		try {
			int indice = buscar(alumnos, dni, usuario);
			
			if(indice >= 0) {
				alumnos.remove(indice);
			}
			PersonaRepository.borrar(personas, dni, usuario);
		}catch (NullPointerException e) {
			System.out.println("No se ha encontrado el alumno.");
		}
	}

	public void mostrar(List<Alumno> alumnos, String dni, String usuario) {
		try {
			int indice = buscar(alumnos, dni, usuario);
			
			System.out.println("Alumno: " + alumnos.get(indice).getNombre() + " " + alumnos.get(indice).getApellidos() + " ");
			System.out.println("DNI: "+ alumnos.get(indice).getDni() + ". Facultad: " + ((Alumno)alumnos.get(indice)).getFacultad());
			System.out.println("Correo: "+ alumnos.get(indice).getCorreoElectronico() + ". Usuario: " + alumnos.get(indice).getUsuario());		
		}catch(IndexOutOfBoundsException e) {
			
		}
	}
	
}
