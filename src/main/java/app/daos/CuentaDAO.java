package app.daos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import app.modelos.Cuenta;
import app.modelos.CuentaExtranjera;

@Repository("CuentaDAO")
public class CuentaDAO implements DAO<Cuenta> {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public void save(Cuenta cuenta) {
		entityManager.persist(cuenta);
		
	}

	@Override
	public Optional<Cuenta> findById(Long id) {
		
		Cuenta c = entityManager.find(Cuenta.class, id);
		return Optional.ofNullable(c);
	}
	
	//obtengo cuenta extranjera por moneda
	public Optional<CuentaExtranjera> findByMoneda(String moneda) {
		
		Query query = entityManager.createQuery("SELECT c FROM cuentas c WHERE c.moneda = ?1");
		query.setParameter(1, moneda);
		CuentaExtranjera cuentasExtranjeras = (CuentaExtranjera) query.getResultList();
		
		return Optional.ofNullable(cuentasExtranjeras);
	}

	@Override
	public void update(Cuenta cuenta) {
		
		entityManager.merge(cuenta);
		
	}

	@Override
	public void delete(Cuenta cuenta) {
		
		entityManager.remove(cuenta);
		
	}

	@Override
	public Collection<Cuenta> findAll() {
		
		List<Cuenta> cuentas = entityManager.createQuery("Select c From cuentas c", Cuenta.class).getResultList();
		return cuentas;
	}

	@Override
	public Optional<Cuenta> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
