package edu.eoi.service;

import java.util.List;

import edu.eoi.entity.Mascota;
import edu.eoi.entity.TipoDeMascota;
import edu.eoi.repository.MascotaRepositoryJDBCImpl;

public class MascotaService {

	MascotaRepositoryJDBCImpl MascotaRepositoryJDBCImpl;
	
	public MascotaService() {
		MascotaRepositoryJDBCImpl = new MascotaRepositoryJDBCImpl();
	}
	
	public void save(Mascota mascota) {
		this.MascotaRepositoryJDBCImpl.save(mascota);
	}
	public Mascota read(Integer id) {
		return this.MascotaRepositoryJDBCImpl.read(id);
	}
	
	public void delete(Mascota mascota) {
		this.MascotaRepositoryJDBCImpl.delete(mascota);
	}
	
	public Mascota update(Mascota mascota) {
		return this.MascotaRepositoryJDBCImpl.update(mascota);
	}
	
	public List<Mascota> recuperarMascotas(TipoDeMascota tipoDeMascota){
		return this.MascotaRepositoryJDBCImpl.recuperarMascotas(tipoDeMascota);
	}

}
