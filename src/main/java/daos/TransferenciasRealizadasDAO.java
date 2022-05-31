package daos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import modelos.TransferenciaRealizada;

@Repository("TransferenciasRealizadasDAO")
public class TransferenciasRealizadasDAO implements DAO<TransferenciaRealizada>{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public void save(TransferenciaRealizada transferencia) {
		
		entityManager.persist(transferencia);
		
	}

	@Override
	public Optional<TransferenciaRealizada> findById(Long id) {

		return Optional.ofNullable(entityManager.find(TransferenciaRealizada.class, id));
	}

	@Override
	public void update(TransferenciaRealizada transferencia) {
		
		entityManager.merge(transferencia);
		
	}

	@Override
	public void delete(TransferenciaRealizada transferencia) {
		
		entityManager.remove(transferencia);
		
	}

	@Override
	public Collection<TransferenciaRealizada> findAll() {
		
		List<TransferenciaRealizada> transferencias = entityManager.createQuery("Select * From transferencias", TransferenciaRealizada.class).getResultList();
		return transferencias;
	}

	@Override
	public Optional<TransferenciaRealizada> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
