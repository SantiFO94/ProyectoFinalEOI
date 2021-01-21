package edu.eoi.entity;

public abstract class Mascota {

	protected String imagen;
	protected String nombre;
	protected String ubicacion;
	protected String descripcion;
	protected String nombreResponsable;
	protected Integer telefonoResponsable;
	protected TipoDeMascota tipoDeMascota;

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreResponsable() {
		return nombreResponsable;
	}

	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}

	public Integer getTelefonoResponsable() {
		return telefonoResponsable;
	}

	public void setTelefonoResponsable(Integer telefonoResponsable) {
		this.telefonoResponsable = telefonoResponsable;
	}

	public TipoDeMascota getTipoDeMascota() {
		return tipoDeMascota;
	}

	public void setTipoDeMascota(TipoDeMascota tipoDeMascota) {
		this.tipoDeMascota = tipoDeMascota;
	}

}
