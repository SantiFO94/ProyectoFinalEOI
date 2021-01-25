package edu.eoi.service;

import java.util.List;

import edu.eoi.entity.Melodia;
import edu.eoi.repository.MelodiaRepositoryJDBCImpl;
import edu.eoi.repository.MusicaRepository;
import edu.eoi.utils.InputMelodiaUtilities;

public class MelodiaService {

	MelodiaRepositoryJDBCImpl MelodiaRepositoryJDBCImpl;
	MusicaRepository MusicaRepository;
	InputMelodiaUtilities InputMelodiaUtilities;
	
	public MelodiaService() {
		MelodiaRepositoryJDBCImpl = new MelodiaRepositoryJDBCImpl();
	}
	
	
	public void guardarMelodia(Melodia melodia) {
		this.MelodiaRepositoryJDBCImpl.save(melodia);;
	}
	
	public Melodia buscarMelodia(Integer id) {
		return this.MelodiaRepositoryJDBCImpl.read(id);
	}
	public void borrarMelodia(Melodia melodia) {
		this.MelodiaRepositoryJDBCImpl.delete(melodia);
	}
	
	public Melodia actualizarMelodia(Melodia melodia) {
		return this.MelodiaRepositoryJDBCImpl.update(melodia);
	}
	
	public List<Melodia> recuperarMelodias() {
		return this.MelodiaRepositoryJDBCImpl.recuperarMelodias();
	}
	
	public String traducirSecuencia(String secuenciaIntroducida) {
		return this.MusicaRepository.traducirSecuencia(secuenciaIntroducida);
	}
	
	public String elegirInstrumento(String instrumentoIntroducido) {
		return this.MusicaRepository.elegirInstrumento(instrumentoIntroducido);
	}
	public Melodia introducirDatosMelodia() {
		return this.InputMelodiaUtilities.introducirDatosMelodia();
	}
//	public Integer introducirId() {
//		return this.InputMelodiaUtilities.introducirId();
//	}
}
