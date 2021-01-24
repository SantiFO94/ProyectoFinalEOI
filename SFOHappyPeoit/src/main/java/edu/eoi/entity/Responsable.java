package edu.eoi.entity;

public class Responsable {

	private Integer id;
	private String nombre;
	private Integer telefono;
	
	
	public Responsable(Integer id, String nombre, Integer telefono) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Responsable [nombre=" + nombre + "]";
	}
	
}
