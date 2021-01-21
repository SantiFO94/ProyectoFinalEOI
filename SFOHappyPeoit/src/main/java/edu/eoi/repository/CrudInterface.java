package edu.eoi.repository;

public interface CrudInterface<E, SEARCH_FIELD> {

	void save(E e);
	
	E read(SEARCH_FIELD sf);
	
	void delete(E e);
	
	E update(E e);
	
	
}
