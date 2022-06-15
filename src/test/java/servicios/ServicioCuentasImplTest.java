package servicios;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import app.configuracion.Configuracion;
import app.daos.DAO;
import app.modelos.Cliente;
import app.modelos.Cuenta;
import app.modelos.CuentaExtranjera;
import app.modelos.Direccion;
import app.servicios.ServicioCuentas;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuracion.class)
@Transactional
class ServicioCuentasImplTest {

	@Autowired
	private DAO<Cliente> clienteDao;
	
	@Autowired
	private DAO<Cuenta> cuentaDao;
	
	@Autowired
	private ServicioCuentas servicioCuentas;
	
	@PersistenceContext
    private EntityManager em;  
	
	
	private final String NOMBRE = "Leandro";
	private final String APELLIDO = "Roidzaid";
	private final int TELEFONO = 12345678; 
	private final String MAIL  = "Leandro@gmail.com";
	private Cliente cliente;

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
	private final String MONEDA = "USD";
	
	private CuentaExtranjera cuentaExtranjera;
	

	@BeforeEach
	void setup() {
		direccion = new Direccion(CALLE, NUM, DEPTO, PISO, CIUDAD, CP, PROV);
		cliente = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		cuentaExtranjera = new CuentaExtranjera(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente, MONEDA);
		
		clienteDao.save(cliente);
		cuentaDao.save(cuentaExtranjera);
		em.flush();
		
		assertNotNull(cliente.getId());
		assertNotNull(cuentaExtranjera.getId());
	}
	
	
	
	@Test
	void AgregarCotitular() {
		
		em.clear();
 		Cliente c = em.find(Cliente.class, cliente.getId());
 		
 		em.clear();
 		Cuenta cta = em.find(Cuenta.class, cuentaExtranjera.getId());
		
		servicioCuentas.agregarTitular(c.getId(), cta.getId());
		em.flush();
		
		
		em.clear();
 		Cuenta ctaExt = em.find(Cuenta.class, cuentaExtranjera.getId());
 		
 		assertTrue(ctaExt.esTitular(cliente));
		
	}

}
