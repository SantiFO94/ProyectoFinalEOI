package edu.eoi.service;

import edu.eoi.repository.ReproductorRepository;

public class ReproductorService {

	ReproductorRepository ReproductorRepository;
	
	public ReproductorService() {
		this.ReproductorRepository = new ReproductorRepository();
	}
	
	public void reproducirMelodia() {
		this.ReproductorRepository.reproducirMelodia();
	}
}
