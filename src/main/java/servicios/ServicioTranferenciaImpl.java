package servicios;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DAO;
import exceptions.ExceptionCuentaCerrada;
import exceptions.ExceptionCuentaNoExiste;
import exceptions.ExceptionSaldoInsuficiente;
import modelos.Cuenta;
import modelos.TransferenciaRealizada;
import modelos.TransferenciaRecibida;

@Service
public class ServicioTranferenciaImpl implements ServicioTransferencias{

	@Autowired
	private DAO<Cuenta> cuentaDAO;
	
	@Autowired
	private DAO<TransferenciaRealizada> tranferenciaRealizada;
	
	@Autowired
	private DAO<TransferenciaRecibida> tranferenciaRecibida;
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void transferir(Long idCuentaOrigen, Double monto, Long idCuentaDestino) throws ExceptionCuentaCerrada, ExceptionSaldoInsuficiente, ExceptionCuentaNoExiste {
		
		Optional<Cuenta> cuenta = cuentaDAO.findById(idCuentaOrigen);
		
		if(!cuenta.isPresent()) {
			throw new ExceptionCuentaNoExiste();
		}
		
		Cuenta ctaOrigen = cuenta.get();
		ctaOrigen.ValidarEstadoDeCuenta();
		ctaOrigen.validarSaldoDisponible(monto);
		
		cuenta = cuentaDAO.findById(idCuentaDestino);
		 
		if(!cuenta.isPresent()) {
			throw new ExceptionCuentaNoExiste();
		}

		Cuenta ctaDestino = cuenta.get();
		ctaDestino.ValidarEstadoDeCuenta();

		ctaOrigen.setSaldoActual(ctaOrigen.getSaldoActual() - monto);
		
		TransferenciaRealizada tranRealizada = new TransferenciaRealizada(LocalDate.now(), monto, "transferencia", ctaOrigen, ctaDestino);
		
		tranferenciaRealizada.save(tranRealizada);
		cuentaDAO.update(ctaOrigen);
		
		ctaDestino.setSaldoActual(ctaDestino.getSaldoActual() + monto);
		
		TransferenciaRecibida tranRecibida = new TransferenciaRecibida(LocalDate.now(), monto, "transferencia", ctaOrigen, ctaDestino);
		
		tranferenciaRecibida.save(tranRecibida);
		cuentaDAO.update(ctaDestino);
		
		em.flush();
			
	
	}
}
