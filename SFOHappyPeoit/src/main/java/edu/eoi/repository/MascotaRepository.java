package edu.eoi.repository;

import java.util.List;

import edu.eoi.entity.Mascota;
import edu.eoi.entity.TipoDeMascota;

public interface MascotaRepository extends CrudInterface<Mascota, Integer>{

	public List<Mascota> recuperarMascotas(TipoDeMascota tipoDeMascota);
	
}
