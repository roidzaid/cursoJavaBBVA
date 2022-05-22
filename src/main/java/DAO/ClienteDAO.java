package DAO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import modelos.Cliente;

@Repository("ClienteDAO")
public class ClienteDAO implements DAO<Cliente>{

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public void save(Cliente cliente) {
		entityManager.persist(cliente);
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		
		Cliente c = entityManager.find(Cliente.class, id);
		
		return Optional.ofNullable(c);
		
	}
	
	//obtener cliente por nombre
	public Optional<Cliente> findByNombre(String nombre) {
		
		Query query = entityManager.createQuery("SELECT * FROM Cliente c WHERE c.nombre = ?1");
		query.setParameter(1, nombre);
		Cliente cliente = (Cliente) query.getSingleResult();
		
		return Optional.ofNullable(cliente);
		
	}

	@Override
	public void update(Cliente cliente) {

		entityManager.persist(cliente);
	}

	@Override
	public void delete(Cliente cliente) {
		
		Cliente c = entityManager.find(Cliente.class, cliente.getId());
		
		if(c!=null) {
			entityManager.remove(cliente);
		}
		
		
	}

	@Override
	public Collection<Cliente> findAll() {
		
		List<Cliente> clientes = entityManager.createQuery("Select * From clientes", Cliente.class).getResultList();
		return clientes;
		
		
	}
	
	
	
}
