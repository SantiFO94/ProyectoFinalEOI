package edu.eoi.entity;

public abstract class Mascota {

	protected Integer id;
	protected String imagen;
	protected String nombre;
	protected String ubicacion;
	protected String descripcion;
	protected Integer idResponsable;
	protected TipoDeMascota tipoDeMascota;
	protected String edad;
	
	public Mascota(String imagen, String nombre, String ubicacion, String descripcion,
			Integer idResponsable, String edad) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.idResponsable = idResponsable;
		this.edad = edad;
	}
	public Mascota(String imagen, String nombre, String ubicacion, String descripcion,
			Integer idResponsable) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.idResponsable = idResponsable;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(Integer idResponsable) {
		this.idResponsable = idResponsable;
	}

	public TipoDeMascota getTipoDeMascota() {
		return tipoDeMascota;
	}

	public void setTipoDeMascota(TipoDeMascota tipoDeMascota) {
		this.tipoDeMascota = tipoDeMascota;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Mascota " + id + ", nombre=" + nombre + ", tipoDeMascota=" + tipoDeMascota + "]";
	}

}
