package edu.eoi.repository;

import java.util.List;

import edu.eoi.pojo.Persona;

public interface CRUDable {

	void crear(List<Persona> personas);
	
	int buscar(List<Persona> personas, String dni, String usuario);
	
	void mostrar(List<Persona> personas, String dni, String usuario, String clase);
	
	void modificar(List<Persona> personas, String dni, String usuario);
	
	void borrar(List<Persona> personas, String dni, String usuario);
	
	
}
