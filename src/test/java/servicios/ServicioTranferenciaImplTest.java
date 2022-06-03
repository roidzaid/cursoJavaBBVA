package servicios;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import configuracion.Configuracion;
import daos.DAO;
import exceptions.ExceptionCuentaCerrada;
import exceptions.ExceptionCuentaNoExiste;
import exceptions.ExceptionSaldoInsuficiente;
import modelos.Cliente;
import modelos.Cuenta;
import modelos.CuentaNacional;
import modelos.Direccion;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuracion.class)
@Transactional
class ServicioTranferenciaImplTest {

	@Autowired
	private DAO<Cliente> clienteDao;
	
	@Autowired
	private DAO<Cuenta> cuentaDao;
	
	@Autowired
	private ServicioTransferencias servicioTransferencias;
	
	@PersistenceContext
    private EntityManager em;  
	
	private final String NOMBRE = "Leandro";
	private final String APELLIDO = "Roidzaid";
	private final int TELEFONO = 12345678; 
	private final String MAIL  = "Leandro@gmail.com";

	private final String CALLE = "Juan Larrea";
	private final int NUM = 460;
	private final String DEPTO = "D";
	private final int PISO = 1;
	private final String CIUDAD = "Moron";
	private final int CP = 1708;
	private final String PROV = "Buenos Aires";
	private Direccion direccion;
	
	private final int NUMERO = 123456789;
	private final Long NUMERO_CTA = (long) NUMERO;
	private final LocalDate FEC_CREACION = LocalDate.now();
	private final Double SALDO_INICIAL = 100.0;
	private final Double SALDO_ACTUAL = 100.0;
	private final Double DESCUBIERTO = 200.0;
	@SuppressWarnings("unused")
	private final LocalDate FEC_CIERRE = LocalDate.now();
	
	private CuentaNacional cuenta1;
	private CuentaNacional cuenta2;
	private Cliente cliente1;
	private Cliente cliente2;
	
	@Test
	void TransferenciaExitosa() throws ExceptionCuentaCerrada, ExceptionSaldoInsuficiente, ExceptionCuentaNoExiste {
		
		direccion = new Direccion(CALLE, NUM, DEPTO, PISO, CIUDAD, CP, PROV);
		cliente1 = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		cliente2 = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		
		clienteDao.save(cliente1);
		clienteDao.save(cliente2);
		
		cuenta1 = new CuentaNacional(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente1);
		cuenta2 = new CuentaNacional(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente2);
		
		cuentaDao.save(cuenta1);
		cuentaDao.save(cuenta2);
		em.flush();

		assertNotNull(cuenta1.getId());
		assertNotNull(cuenta2.getId());
		
		em.clear();
 		CuentaNacional ctaOrigen = em.find(CuentaNacional.class, cuenta1.getId());
 		CuentaNacional ctaDestino = em.find(CuentaNacional.class, cuenta2.getId());
		
		servicioTransferencias.transferir(ctaOrigen.getId(), 50.0, ctaDestino.getId());
		
	}
	
	@Test
	void Transferencia_SaldoInsuficiente() throws ExceptionSaldoInsuficiente{
			
		direccion = new Direccion(CALLE, NUM, DEPTO, PISO, CIUDAD, CP, PROV);
		cliente1 = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		cliente2 = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		
		clienteDao.save(cliente1);
		clienteDao.save(cliente2);
		
		cuenta1 = new CuentaNacional(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente1);
		cuenta2 = new CuentaNacional(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente2);
		
		cuentaDao.save(cuenta1);
		cuentaDao.save(cuenta2);
		em.flush();

		assertNotNull(cuenta1.getId());
		assertNotNull(cuenta2.getId());
		
		em.clear();
 		CuentaNacional ctaOrigen = em.find(CuentaNacional.class, cuenta1.getId());
 		CuentaNacional ctaDestino = em.find(CuentaNacional.class, cuenta2.getId());
		
	 	assertThrows(ExceptionSaldoInsuficiente.class, () -> {
	 		
	 		servicioTransferencias.transferir(ctaOrigen.getId(), 2000.0, ctaDestino.getId());
	 	});
			
		
	 		



			
		
	}

}
