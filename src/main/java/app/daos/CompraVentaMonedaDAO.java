package app.daos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import app.modelos.CompraVentaMoneda;

@Repository("CompraVentaMonedaDAO")
public class CompraVentaMonedaDAO implements DAO<CompraVentaMoneda>{

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public void save(CompraVentaMoneda compraVentaMoneda) {
		
		entityManager.persist(compraVentaMoneda);
		
	}

	@Override
	public Optional<CompraVentaMoneda> findById(Long id) {
		
		return Optional.ofNullable(entityManager.find(CompraVentaMoneda.class, id));
	}

	@Override
	public void update(CompraVentaMoneda compraVentaMoneda) {
		entityManager.merge(compraVentaMoneda);
		
	}

	@Override
	public void delete(CompraVentaMoneda compraVentaMoneda) {
		entityManager.remove(compraVentaMoneda);
		
	}

	@Override
	public Collection<CompraVentaMoneda> findAll() {
		
		List<CompraVentaMoneda> ComprasVentasMoneda = entityManager.createQuery("Select * From COMPRA_VENTA_MONEDA", CompraVentaMoneda.class).getResultList();
		return ComprasVentasMoneda;
	}

	@Override
	public Optional<CompraVentaMoneda> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
}
