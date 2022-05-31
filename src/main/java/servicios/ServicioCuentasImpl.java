package servicios;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DAO;
import modelos.Cliente;
import modelos.Cuenta;

@Service
public class ServicioCuentasImpl implements ServicioCuentas{

	@Autowired
	private DAO<Cliente> clienteDAO;
	
	@Autowired
	private DAO<Cuenta> cuentaDAO;
	
	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	public void agregarTitular(Long idCliente, Long idCuenta) {

		Optional<Cliente> cliente = clienteDAO.findById(idCliente);
		
		if(cliente.isPresent()) {
			Cliente c = cliente.get();
			
			Optional<Cuenta> cuenta = cuentaDAO.findById(idCuenta);
			
			if(cuenta.isPresent()) {
				Cuenta cta = cuenta.get();
				
				
				if(!cta.esTitular(c) && !cta.esCoTitular(c)) {
					
					c.agregarCuentaCoTitular(cta);
					
					clienteDAO.update(c);
					em.flush();
				}
			}
		}
		
	}

}
