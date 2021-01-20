package edu.eoi.repository;

import java.util.List;
import java.util.Scanner;

import edu.eoi.pojo.PAS;
import edu.eoi.pojo.Persona;
import edu.eoi.pojo.Unidad;

public class PASRepository implements CRUDable {

	private static final Scanner sctexto = new Scanner(System.in);
	
	public void crear(List<Persona> personas) {
		
		Persona persona = PersonaRepository.introducirDatos(personas, false, null, null);
		Unidad unidadAsignada = determinarUnidad();
//		String unidadIntroducida = null;
		PAS pas = null;
		//convertir esto en metodo para poder aplicarlo cuando haga falta e implementar personRepo
//		do {
//			
//			System.out.println("Introduzca la unidad:");
//			unidadIntroducida = sctexto.nextLine();
//			
//			for(Unidad unidadTemporal : Unidad.values()) {
//				if (unidadIntroducida.equalsIgnoreCase(unidadTemporal.toString())) {
//					unidadAsignada = unidadTemporal;
//				}else {
//					System.out.println("Unidad introducida desconocida, vuelva a intentarlo.\n");
//					System.out.println("Si desea abandonar el proceso de creación introduzca:\n"
//										+ "finalizar.\n");
//				}
//			}
//			if(unidadIntroducida.equalsIgnoreCase("administración")){
//				unidadAsignada = Unidad.ADMINISTRACION;
//			} else if (unidadIntroducida.equalsIgnoreCase("servicios")) {
//				unidadAsignada = Unidad.SERVICIOS;
//			} else if (unidadIntroducida.equalsIgnoreCase("otros")) {
//				unidadAsignada = Unidad.OTROS;
//			}else {
//				System.out.println("Unidad introducida desconocida, vuelva a intentarlo.\n");
//				System.out.println("Si desea abandonar el proceso de creación introduzca:\n"
//									+ "finalizar.\n");
//			}
//		
//		}while (unidadAsignada == null && !unidadIntroducida.equalsIgnoreCase("finalizar"));
		try {
			pas=new PAS(persona.getNombre(), persona.getApellidos(), persona.getDni(),
					persona.getCorreoElectronico(), persona.getUsuario(), persona.getPassword(),
					unidadAsignada);
			personas.add(pas);
		}catch (IllegalArgumentException e) {
			System.out.println("Ha decidido no completar la creación del usuario.");
		}
	}
//general
	public int buscar(List<Persona> listaPas, String dni, String usuario) {
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

	public void modificar(List<Persona> listaPas, String dni, String usuario) {
		int indice = buscar(listaPas, dni, usuario);
		
		System.out.println("Introduzca los nuevos datos:");
		
		Persona persona =  PersonaRepository.introducirDatos(listaPas, true, listaPas.get(indice).getDni(), listaPas.get(indice).getUsuario());
		System.out.println("Introduzca la unidad:");
		Unidad unidadAsignada = determinarUnidad();
		PAS pas=new PAS(persona.getNombre(), persona.getApellidos(), persona.getDni(),
				persona.getCorreoElectronico(), persona.getUsuario(), persona.getPassword(), unidadAsignada);
		
		listaPas.set(indice, pas);
	}
	//general
	public void borrar(List<Persona> listaPas, String dni, String usuario) {
		int indice = buscar(listaPas, dni, usuario);
		
		if(indice >= 0) {
			listaPas.remove(indice);
		}
	}
	//general
	public void mostrar(List<Persona> personas, String dni, String usuario, String clase) {
		
	}
	
	public Unidad determinarUnidad() {
		Unidad unidadAsignada = null;
		String unidadIntroducida = null;
		
		do {
			
			System.out.println("Introduzca la unidad:");
			unidadIntroducida = sctexto.nextLine();
			
			for(Unidad unidadTemporal : Unidad.values()) {
				if (unidadIntroducida.equalsIgnoreCase(unidadTemporal.toString())) {
					unidadAsignada = unidadTemporal;
				}else {
					System.out.println("Unidad introducida desconocida, vuelva a intentarlo.");
					System.out.println("Si desea abandonar el proceso de creación introduzca:\n"
										+ "finalizar\n");
				}
			}
		}while (unidadAsignada == null && !unidadIntroducida.equalsIgnoreCase("finalizar"));
		
		return unidadAsignada;
	}
}
