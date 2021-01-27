package edu.eoi.app;

import java.util.ArrayList;
import java.util.List;

import edu.eoi.enums.Accion;
import edu.eoi.enums.TipoBusqueda;
import edu.eoi.enums.TipoUsuario;
import edu.eoi.pojo.Alumno;
import edu.eoi.pojo.PAS;
import edu.eoi.pojo.Persona;
import edu.eoi.pojo.Profesor;
import edu.eoi.repository.AlumnoRepository;
import edu.eoi.repository.JSONRepository;
import edu.eoi.repository.PASRepository;
import edu.eoi.repository.ProfesorRepository;
import edu.eoi.ui.MenuCrear;
import edu.eoi.ui.MenuIdentificador;
import edu.eoi.ui.MenuInicio;
import edu.eoi.ui.MenuTipoBusqueda;

public class MainApp {

	public static void main(String[] args) {

		AlumnoRepository alumnoRepo = new AlumnoRepository();
		ProfesorRepository profesorRepo = new ProfesorRepository();
		PASRepository pasRepo = new PASRepository();
				
		List<Alumno> alumnos = JSONRepository.leerArchivoAlumnos("Alumnos");
		
		List<Profesor> profesores = JSONRepository.leerArchivoProfesores("Profesores");
		
		List<PAS> listaPas = JSONRepository.leerArchivoPas("PAS");
		
		List<Persona> personas = new ArrayList<Persona>();
		personas.addAll(listaPas);
		personas.addAll(profesores);
		personas.addAll(alumnos);
		
		Accion accion = null;
		TipoBusqueda tipoBusqueda = null;
		
		do {
			accion = MenuInicio.menuInicio();
			switch(accion) {
				case CREAR:
					TipoUsuario tipoUsuario = MenuCrear.menuCrear();
					switch(tipoUsuario) {
						case ALUMNO:
							alumnoRepo.guardar(alumnos, personas);
							break;
						case PROFESOR:
							profesorRepo.guardar(profesores, personas);
							break;
						case PAS:
							pasRepo.guardar(listaPas, personas);
							break;
					}
					break;
				case CONSULTAR:
					tipoBusqueda = MenuTipoBusqueda.menuTipoBusqueda();
					switch(tipoBusqueda) {
					case DNI:
						String dni = MenuIdentificador.menuIdentificador("dni");
						alumnoRepo.mostrar(alumnos, dni, null);
						pasRepo.mostrar(listaPas, dni, null);
						profesorRepo.mostrar(profesores, dni, null);
						break;
					case USUARIO:
						String usuario = MenuIdentificador.menuIdentificador("usuario");
						alumnoRepo.mostrar(alumnos, null, usuario);
						pasRepo.mostrar(listaPas, null, usuario);
						profesorRepo.mostrar(profesores, null, usuario);
						break;
					}
					break;
				case MODIFICAR:
					tipoBusqueda = MenuTipoBusqueda.menuTipoBusqueda();
					int indice;
					switch(tipoBusqueda) {
					case DNI:
						String dni = MenuIdentificador.menuIdentificador("dni");;
						indice = alumnoRepo.buscar(alumnos, dni, null);
						if(indice >= 0) {
							alumnoRepo.modificar(alumnos, personas, indice);
						}else {
							indice = pasRepo.buscar(listaPas, dni, null);
							if(indice >= 0) {
								pasRepo.modificar(listaPas, personas, indice);
							}else {
								indice = profesorRepo.buscar(profesores, dni, null);
								if(indice >= 0) {
									profesorRepo.modificar(profesores, personas, indice);

								}else {
									System.out.println("Usuario no encontrado.");
								}
							}
						}
						break;
					case USUARIO:
						String usuario = MenuIdentificador.menuIdentificador("usuario");
						indice = alumnoRepo.buscar(alumnos, null, usuario);
						if(indice >= 0) {
							alumnoRepo.modificar(alumnos, personas, indice);
						}else {
							indice = pasRepo.buscar(listaPas, null, usuario);
							if(indice >= 0) {
								pasRepo.modificar(listaPas, personas, indice);
							}else {
								indice = profesorRepo.buscar(profesores, null, usuario);
								if(indice >= 0) {
									profesorRepo.modificar(profesores, personas, indice);

								}
							}
						}
						break;
					}
					break;
					
				case ELIMINAR:
					tipoBusqueda = MenuTipoBusqueda.menuTipoBusqueda();
					switch(tipoBusqueda) {
					case DNI:
						String dni = MenuIdentificador.menuIdentificador("dni");
						alumnoRepo.borrar(alumnos, personas, dni, null);
						profesorRepo.borrar(profesores, personas, dni, null);
						pasRepo.borrar(listaPas, personas, dni, null);
						break;
					case USUARIO:
						String usuario = MenuIdentificador.menuIdentificador("usuario");
						alumnoRepo.borrar(alumnos, personas, null, usuario);
						profesorRepo.borrar(profesores, personas, null, usuario);
						pasRepo.borrar(listaPas, personas, null, usuario);
						break;
					}
					break;
				case SALIR:
					System.out.println("Hasta pronto.");
					break;
				default:
					break;
					
			}
		}while(accion != Accion.SALIR);
		
		JSONRepository.escribirArchivoAlumnos(alumnos);
		JSONRepository.escribirArchivoProfesores(profesores);
		JSONRepository.escribirArchivoPas(listaPas);
//
	}

}
