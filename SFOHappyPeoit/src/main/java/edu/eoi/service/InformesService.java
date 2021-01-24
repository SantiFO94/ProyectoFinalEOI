package edu.eoi.service;

import edu.eoi.repository.InformesRepository;

public class InformesService {

	InformesRepository InformesRepository;
	
	public InformesService() {
		InformesRepository = new InformesRepository();
	}
	
	public void generarInformes() {
		this.InformesRepository.generarInformes();
	}
}
