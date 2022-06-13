package app.serviciosImpl;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.daos.DAO;
import app.exceptions.ExceptionClienteYaEsCoTitularDeLaCuenta2;
import app.exceptions.ExceptionClienteYaEsTitularDeLaCuenta;
import app.exceptions.ExceptionCuentaCerrada;
import app.exceptions.ExceptionCuentaNoExiste;
import app.exceptions.ExceptionSaldoInsuficiente;
import app.modelos.Cliente;
import app.modelos.Cuenta;
import app.modelos.CuentaExtranjera;
import app.modelos.CuentaModel;
import app.modelos.CuentaNacional;
import app.modelos.Movimiento;
import app.servicios.ServicioCuentas;
import app.servicios.ServicioTransferencias;

@Service
public class ServicioCuentasImpl implements ServicioCuentas{

	@Autowired
	private DAO<Cliente> clienteDAO;
	
	@Autowired
	private DAO<Cuenta> cuentaDAO;
	
	@Autowired
	private ServicioTransferencias servicioTransferencias;
	
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


	@Override
	public Collection<Cuenta> listarCuentas() {
		
		Collection<Cuenta> cuentas = cuentaDAO.findAll();
		
		if(cuentas!=null) {
			return cuentas;
		}else {
			return null;
		}
	}


	@Transactional
	@Override
	public void crearCuentaNacional(CuentaModel cuenta) {
		
		Optional<Cliente> c = clienteDAO.findById(cuenta.getIdTitular());
		
		if(c!= null) {
			Cliente cliente = c.get();
			
			CuentaNacional cuentaNacional = new CuentaNacional(
					cuenta.getNro(),
					cuenta.getFechaCreacion(),
					cuenta.getSaldoInicial(),
					cuenta.getSaldoActual(),
					cuenta.getDescubierto(),
					cliente);
			
			cuentaDAO.save(cuentaNacional);
		}
		
	}
	
	@Transactional
	@Override
	public void crearCuentaExtranjera(CuentaModel cuenta) {
		
		Optional<Cliente> c = clienteDAO.findById(cuenta.getIdTitular());
		
		if(c!= null) {
			Cliente cliente = c.get();
			
			CuentaExtranjera cuentaExtranjera = new CuentaExtranjera(
					cuenta.getNro(),
					cuenta.getFechaCreacion(),
					cuenta.getSaldoInicial(),
					cuenta.getSaldoActual(),
					cuenta.getDescubierto(),
					cliente,
					cuenta.getMoneda());
			
			cuentaDAO.save(cuentaExtranjera);
		}
		
	}

	@Transactional
	@Override
	public void agregarCoTitular(Long idCliente, Long idCuenta) throws ExceptionClienteYaEsTitularDeLaCuenta, ExceptionClienteYaEsCoTitularDeLaCuenta2 {
		
		Optional<Cliente> cliente = clienteDAO.findById(idCliente);
		
		if(cliente.isPresent()) {
			Cliente c = cliente.get();
			
			Optional<Cuenta> cuenta = cuentaDAO.findById(idCuenta);
			
			if(cuenta.isPresent()) {
				Cuenta cta = cuenta.get();
				
				
				if(!cta.esTitular(c)) {
					
					if(!cta.esCoTitular(c)) {
					
						c.agregarCuentaCoTitular(cta);
						cta.agregarCotitulares(c);
						
						clienteDAO.update(c);
						cuentaDAO.update(cta);
						em.flush();
					
					}else {
						throw new ExceptionClienteYaEsCoTitularDeLaCuenta2();
					}
					
				}else {
					throw new ExceptionClienteYaEsTitularDeLaCuenta();
				}
			}
		}
		
	}


	@Override
	public Collection<Movimiento> listarMovimientos(Long idCuenta) {
		
		Optional<Cuenta> cuenta = cuentaDAO.findById(idCuenta);
		
		if(cuenta.isPresent()) {
			Cuenta cta = cuenta.get();
			
			return cta.getMovimientos();
			
		}else {
			return null;
		}
	}


	@Transactional
	@Override
	public void transferir(Long idCuentaOrigen, Long idCuentaDestino, Double Monto) throws ExceptionCuentaCerrada, ExceptionSaldoInsuficiente, ExceptionCuentaNoExiste {
		

		servicioTransferencias.transferir(idCuentaOrigen, Monto, idCuentaDestino);
		
	}

}
