package app.daos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import app.modelos.DepositoExtraccion;

@Repository("DepositoExtraccionDAO")
public class DepositoExtraccionDAO implements DAO<DepositoExtraccion>{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public void save(DepositoExtraccion depositoExtraccion) {
		entityManager.persist(depositoExtraccion);
		
	}

	@Override
	public Optional<DepositoExtraccion> findById(Long id) {
		
		return Optional.ofNullable(entityManager.find(DepositoExtraccion.class, id));
	}

	@Override
	public void update(DepositoExtraccion depositoExtraccion) {
		
		entityManager.merge(depositoExtraccion);
	}

	@Override
	public void delete(DepositoExtraccion depositoExtraccion) {
		
		entityManager.remove(depositoExtraccion);
		
	}

	@Override
	public Collection<DepositoExtraccion> findAll() {
		
		List<DepositoExtraccion> depositosExtracciones = entityManager.createQuery("Select * From DEPOSITO_EXTRACCION", DepositoExtraccion.class).getResultList();
		return depositosExtracciones;
	}

	@Override
	public Optional<DepositoExtraccion> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
