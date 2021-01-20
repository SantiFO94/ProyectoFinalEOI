package edu.eoi.repository;

import java.util.List;
import java.util.Scanner;

import edu.eoi.pojo.Alumno;
import edu.eoi.pojo.PAS;
import edu.eoi.pojo.Persona;
import edu.eoi.pojo.Profesor;

public class PersonaRepository implements CRUDable {

	private static final Scanner sctexto = new Scanner(System.in);
	
	public static Persona introducirDatos(List<Persona> personas, boolean existente, String dniExistente, String usuarioExistente) {
		
		Persona persona = null;
		boolean repetir = true;
		
			if(existente) {
				
				System.out.println("Introduzca el nombre:");
				String nombre = sctexto.nextLine();
				System.out.println("Introduzca los apellidos:");
				String apellidos = sctexto.nextLine();
				System.out.println("Introduzca el correo electrónico:");
				String correoElectronico = sctexto.nextLine();
				System.out.println("Introduzca la contraseña:");
				String password = sctexto.nextLine();
				persona = new Persona(nombre, apellidos, dniExistente, correoElectronico, usuarioExistente, password);
			}else {
				do{
					System.out.println("Introduzca el nombre:");
					String nombre = sctexto.nextLine();
					System.out.println("Introduzca los apellidos:");
					String apellidos = sctexto.nextLine();
					System.out.println("Introduzca el dni:");
					String dni = sctexto.nextLine();
					System.out.println("Introduzca el correo electrónico:");
					String correoElectronico = sctexto.nextLine();
					System.out.println("Introduzca el nombre de usuario (no podrá modificarlo):");
					String usuario = sctexto.nextLine();
					System.out.println("Introduzca la contraseña:");
					String password = sctexto.nextLine();
					
					for(Persona personaTemporal : personas) {
						if(personaTemporal.getDni().equalsIgnoreCase(dni)) {
							System.out.println("DNI ya existente.");
						}else if (personaTemporal.getUsuario().equalsIgnoreCase(usuario)) {
							System.out.println("Usuario ya existente.");
						}else {
							repetir=false;
							persona = new Persona(nombre, apellidos, dni, correoElectronico, usuario, password);
						}
					}
				}while (repetir);
			}
		
		return persona;
		
	}

	public void crear(List<Persona> personas) {
		// TODO Auto-generated method stub
		
	}

	public int buscar(List<Persona> personas, String dni, String usuario) {
		int indice = -1;
		
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getDni().equalsIgnoreCase(dni)) {
				indice = i;
			}else if (personas.get(i).getUsuario().equalsIgnoreCase(usuario)) {
				indice = i;
			}
		}
		if(indice == -1) {
			System.out.println("No se ha encontrado el usuario.");
					}
		return indice;
	}

	public void modificar(List<Persona> personas, String dni, String usuario) {
		// TODO Auto-generated method stub
		
	}

	public void borrar(List<Persona> personas, String dni, String usuario) {

		int indice = buscar(personas, dni, usuario);
		
		if(indice >= 0) {
			personas.remove(indice);
		}
	}

	public void mostrar(List<Persona> personas, String dni, String usuario,String clase) {
		
		int indice = buscar(personas, dni, usuario);
		
		System.out.print(clase + ": " + personas.get(indice).getNombre() + " " + personas.get(indice).getApellidos() + ". DNI: "
				+ personas.get(indice).getDni());
		if(clase.equals("profesor")) {
			System.out.print(". Despacho: " + ((Profesor)personas.get(indice)).getDespacho());
		}else if(clase.equals("alumno")) {
			System.out.print(". Facultad: " + ((Alumno)personas.get(indice)).getFacultad());
		}else {
			System.out.print(". Unidad: " + ((PAS)personas.get(indice)).getUnidad());
		}
		
		System.out.println(". Correo: "+ personas.get(indice).getCorreoElectronico() + ". Usuario: " + personas.get(indice).getUsuario());

		
		
	}
	

}
