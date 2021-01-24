package edu.eoi.repository;

import java.util.List;

import edu.eoi.entity.Responsable;

public interface ResponsableRepository extends CrudInterface<Responsable, Integer> {

	public List<Responsable> recuperarResponsables();
}
