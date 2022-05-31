package daos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	@Override
	public Optional<Cliente> findByNombre(String nombre) {
		
		//Query query = entityManager.createQuery("SELECT c FROM clientes c WHERE c.nombre = ?1");
		TypedQuery<Cliente> query = entityManager.createNamedQuery("buscarPorNombre", Cliente.class);
		query.setParameter(1, nombre);
		Cliente cliente = (Cliente) query.getSingleResult();
		
		return Optional.ofNullable(cliente);
		
	}

	@Override
	public void update(Cliente cliente) {

		entityManager.merge(cliente);
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
