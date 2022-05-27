package daos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import modelos.TransferenciaRecibida;

@Repository("TransferenciasRealizadasDAO")
public class TransferenciasRealizadasDAO implements DAO<TransferenciaRecibida>{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public void save(TransferenciaRecibida transferencia) {
		
		entityManager.persist(transferencia);
		
	}

	@Override
	public Optional<TransferenciaRecibida> findById(Long id) {

		return Optional.ofNullable(entityManager.find(TransferenciaRecibida.class, id));
	}

	@Override
	public void update(TransferenciaRecibida transferencia) {
		
		entityManager.merge(transferencia);
		
	}

	@Override
	public void delete(TransferenciaRecibida transferencia) {
		
		entityManager.remove(transferencia);
		
	}

	@Override
	public Collection<TransferenciaRecibida> findAll() {
		
		List<TransferenciaRecibida> transferencias = entityManager.createQuery("Select * From transferencias", TransferenciaRecibida.class).getResultList();
		return transferencias;
	}

	@Override
	public Optional<TransferenciaRecibida> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
