package daos;

import java.util.Collection;
import java.util.Optional;

import modelos.CompraVentaMoneda;

public interface DAO<T> {

	void save(T compraMoneda);
	Optional<T> findById(Long id);
	void update(T t);
	void delete(T t);
	Collection<T> findAll();

	
	Optional<T> findByNombre(String nombre);
	
}
