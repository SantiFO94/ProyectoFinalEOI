package edu.eoi.repository;

import java.util.List;
import java.util.Scanner;

import edu.eoi.pojo.PAS;
import edu.eoi.pojo.Persona;
import edu.eoi.pojo.Unidad;

public class PASRepository {

	private static final Scanner sctexto = new Scanner(System.in);
	
	public void guardar(List<PAS> listaPas, List<Persona> personas) {
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
		
		Unidad unidadAsignada = determinarUnidad();
		
		do{
			
			System.out.println("Introduzca el dni:");
			dni = sctexto.nextLine();
			System.out.println("Introduzca el nombre de usuario (no podrá modificarlo):");
			usuario = sctexto.nextLine();

			repetir = PersonaRepository.comprobarExistencia(personas, dni, usuario);

		}while (repetir);
		
		PAS pas = new PAS(nombre, apellidos, dni, correoElectronico, usuario, password, unidadAsignada);

		listaPas.add(pas);
		personas.add((Persona)pas);

	}
	
	public int buscar(List<PAS> listaPas, String dni, String usuario) {
		int indice = -1;
		
		for(int i = 0; i < listaPas.size(); i++) {
			if(listaPas.get(i).getDni().equalsIgnoreCase(dni)) {
				indice = i;
			}else if (listaPas.get(i).getUsuario().equalsIgnoreCase(usuario)) {
				indice = i;
			}
		}
		return indice;
	}

	public void modificar(List<PAS> listaPas, List<Persona> personas, int indicePropio) {
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
			
			Unidad unidadAsignada = determinarUnidad();
	
			PAS pas=new PAS(nombre, apellidos, listaPas.get(indicePropio).getDni(),
					correoElectronico, listaPas.get(indicePropio).getUsuario(), password, unidadAsignada);
			
			listaPas.set(indicePropio, pas);
			int indicePersonas = PersonaRepository.buscar(personas, pas.getDni(), null);

			personas.set(indicePersonas, (Persona)pas);

		}catch (NullPointerException e) {
			System.out.println("No se ha encontrado el PAS.");
		}
	}
	
	public void borrar(List<PAS> listaPas, List<Persona> personas, String dni, String usuario) {
		try {
			int indice = buscar(listaPas, dni, usuario);
			
			if(indice >= 0) {
				listaPas.remove(indice);
			}
			PersonaRepository.borrar(personas, dni, usuario);
		}catch (NullPointerException e) {
			System.out.println("No se ha encontrado el PAS.");
		}
	}
	
	public void mostrar(List<PAS> listaPAS, String dni, String usuario) {
		try {
			int indice = buscar(listaPAS, dni, usuario);
			
			System.out.println("Pas: " + listaPAS.get(indice).getNombre() + " " + listaPAS.get(indice).getApellidos() + " ");
			System.out.println("DNI: "+ listaPAS.get(indice).getDni() + ". Unidad: " + listaPAS.get(indice).getUnidad().toString());
			System.out.println("Correo: "+ listaPAS.get(indice).getCorreoElectronico() + ". Usuario: " + listaPAS.get(indice).getUsuario());
		}catch(IndexOutOfBoundsException e) {
			
		}catch(NullPointerException e1) {
			System.out.println("Este usuario PAS necesita actualizar su UNIDAD.");
		}
	}
	
	public Unidad determinarUnidad() {
		Unidad unidadAsignada = null;
		String unidadIntroducida = null;
		
		try{
			
			System.out.println("Introduzca la unidad (ADMINISTRACION, SERVICIOS, OTROS):");
			unidadIntroducida = sctexto.nextLine();
			
			for(Unidad unidadTemporal : Unidad.values()) {
				if (unidadIntroducida.equalsIgnoreCase(unidadTemporal.toString())) {
					unidadAsignada = unidadTemporal;
				}
			}
			if(unidadAsignada.equals(null)) {
				
			}
		}catch(NullPointerException e) {
			System.out.println("Unidad introducida desconocida, vuelva a intentarlo.\n");
			unidadAsignada = determinarUnidad();
		}
		
		return unidadAsignada;
	}
}
