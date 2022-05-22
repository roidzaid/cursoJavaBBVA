package DAO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import modelos.Transferencia;

@Repository("TransferenciasDAO")
public class TransferenciasDAO implements DAO<Transferencia>{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public void save(Transferencia transferencia) {
		
		entityManager.persist(transferencia);
		
	}

	@Override
	public Optional<Transferencia> findById(Long id) {

		return Optional.ofNullable(entityManager.find(Transferencia.class, id));
	}

	@Override
	public void update(Transferencia transferencia) {
		
		entityManager.persist(transferencia);
		
	}

	@Override
	public void delete(Transferencia transferencia) {
		
		entityManager.remove(transferencia);
		
	}

	@Override
	public Collection<Transferencia> findAll() {
		
		List<Transferencia> transferencias = entityManager.createQuery("Select * From transferencias", Transferencia.class).getResultList();
		return transferencias;
	}

}
