package edu.eoi.service;

import java.util.List;

import edu.eoi.entity.Melodia;
import edu.eoi.main.GeneracionDeMusica;
import edu.eoi.repository.MelodiaRepositoryJDBCImpl;
import edu.eoi.utils.InputMelodia;

public class MelodiaService {

	MelodiaRepositoryJDBCImpl MelodiaRepositoryJDBCImpl;
	GeneracionDeMusica MusicaRepository;
	InputMelodia InputMelodiaUtilities;
	
	public MelodiaService() {
		MelodiaRepositoryJDBCImpl = new MelodiaRepositoryJDBCImpl();
	}
	
	public void guardar(Melodia melodia) {
		this.MelodiaRepositoryJDBCImpl.save(melodia);;
	}
	
	public Melodia read(String nombre) {
		return this.MelodiaRepositoryJDBCImpl.read(nombre);
	}
	public void borrar(Melodia melodia) {
		this.MelodiaRepositoryJDBCImpl.delete(melodia);
	}
	
	public Melodia actualizar(Melodia melodia) {
		return this.MelodiaRepositoryJDBCImpl.update(melodia);
	}
	
	public List<Melodia> recuperarMelodias() {
		return this.MelodiaRepositoryJDBCImpl.recuperarMelodias();
	}
	
}
