package app.daos;

import java.util.Collection;
import java.util.Optional;

public interface DAO<T> {

	void save(T t);
	Optional<T> findById(Long id);
	void update(T t);
	void delete(T t);
	Collection<T> findAll();

	
	Optional<T> findByNombre(String nombre);
	
}
