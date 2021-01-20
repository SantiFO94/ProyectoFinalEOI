package edu.eoi.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.eoi.pojo.Persona;
import edu.eoi.repository.AlumnoRepository;
import edu.eoi.repository.JSONRepository;
import edu.eoi.repository.PASRepository;
import edu.eoi.repository.PersonaRepository;
import edu.eoi.repository.ProfesorRepository;

public class MainApp {

	public static void main(String[] args) {

		Scanner sctexto = new Scanner(System.in);
		AlumnoRepository alumnoRepo = new AlumnoRepository();
		ProfesorRepository profesorRepo = new ProfesorRepository();
		PASRepository pasRepo = new PASRepository();
		
		PersonaRepository repositorioPersona = new PersonaRepository();
		
		List<Persona> alumnos = new ArrayList<Persona>();
		alumnos = JSONRepository.leerArchivo("Alumnos");
		
		List<Persona> profesores = new ArrayList<Persona>();
		profesores = JSONRepository.leerArchivo("Profesores");
		
		List<Persona> listaPas = new ArrayList<Persona>();
		listaPas = JSONRepository.leerArchivo("PAS");

		Accion accion = null;
		TipoUsuario tipoUsuario = null;
		TipoBusqueda tipoBusqueda = null;
		do {
			accion = MenuInicio.menuInicio(sctexto);
			switch(accion) {
				case CREAR:
					tipoUsuario = MenuCrear.menuCrear(sctexto);
					switch(tipoUsuario) {
						case ALUMNO:
							alumnoRepo.crear(alumnos);
							break;
						case PROFESOR:
							profesorRepo.crear(profesores);
							break;
						case PAS:
							pasRepo.crear(listaPas);;
							break;
					}
					break;
				case CONSULTAR:
					tipoBusqueda = MenuTipoBusqueda.menuTipoBusqueda(sctexto);
					switch(tipoBusqueda) {
					case DNI:
						String dni = MenuIdentificador.menuIdentificador(sctexto, "dni");
						repositorioPersona.mostrar(alumnos, dni, null, "Alumnos");
						repositorioPersona.mostrar(profesores, dni, null, "Profesores");
						repositorioPersona.mostrar(listaPas, dni, null, "pas");
						break;
					case USUARIO:
						String usuario = MenuIdentificador.menuIdentificador(sctexto, "usuario");
						repositorioPersona.mostrar(alumnos, null, usuario, "Alumnos");
						repositorioPersona.mostrar(profesores, null, usuario, "Profesores");
						repositorioPersona.mostrar(listaPas, null, usuario, "pas");
						break;
					}
					break;
				case MODIFICAR:
					tipoBusqueda = MenuTipoBusqueda.menuTipoBusqueda(sctexto);
					switch(tipoBusqueda) {
					case DNI:
						String dni = MenuIdentificador.menuIdentificador(sctexto, "dni");;
						alumnoRepo.modificar(alumnos, dni, null);
						pasRepo.modificar(listaPas, dni, null);
						profesorRepo.modificar(profesores, dni, null);
						break;
					case USUARIO:
						String usuario = MenuIdentificador.menuIdentificador(sctexto, "usuario");
						alumnoRepo.modificar(alumnos, null, usuario);
						pasRepo.modificar(listaPas, null, usuario);
						profesorRepo.modificar(profesores, null, usuario);
						break;
					}
					break;
					
				case ELIMINAR:
					tipoBusqueda = MenuTipoBusqueda.menuTipoBusqueda(sctexto);
					switch(tipoBusqueda) {
					case DNI:
						String dni = MenuIdentificador.menuIdentificador(sctexto, "dni");
						repositorioPersona.borrar(alumnos, dni, null);
						repositorioPersona.borrar(profesores, dni, null);
						repositorioPersona.borrar(listaPas, dni, null);
						break;
					case USUARIO:
						String usuario = MenuIdentificador.menuIdentificador(sctexto, "usuario");
						repositorioPersona.borrar(alumnos, null, usuario);
						repositorioPersona.borrar(profesores, null, usuario);
						repositorioPersona.borrar(listaPas, null, usuario);
						break;
					}
					break;
				case SALIR:
					System.out.println("Hasta pronto.");
					break;
					
			}
		}while(accion != Accion.SALIR);
		
		JSONRepository.escribirArchivo(alumnos, "Alumnos");
		JSONRepository.escribirArchivo(profesores, "Profesores");
		JSONRepository.escribirArchivo(listaPas, "PAS");
		sctexto.close();

	}

}
