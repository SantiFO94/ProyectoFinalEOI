package edu.eoi.service;

import java.util.List;

import edu.eoi.entity.Responsable;
import edu.eoi.repository.ResponsableRepositoryJDBCImpl;

public class ResponsableService {

	private ResponsableRepositoryJDBCImpl ResponsableRepositoryJDBCImpl;
	
	public ResponsableService() {
		ResponsableRepositoryJDBCImpl = new ResponsableRepositoryJDBCImpl();
	}
	
	public void save(Responsable responsable) {
		this.ResponsableRepositoryJDBCImpl.save(responsable);
	}
	public Responsable read(Integer id) {
		return this.ResponsableRepositoryJDBCImpl.read(id);
	}
	
	public Responsable update(Responsable responsable) {
		return this.ResponsableRepositoryJDBCImpl.update(responsable);
		
	}

	public List<Responsable> recuperarResponsables(){
		return this.ResponsableRepositoryJDBCImpl.recuperarResponsables();
	}
}
