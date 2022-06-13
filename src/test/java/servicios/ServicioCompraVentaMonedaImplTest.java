 package servicios;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import app.exceptions.ExceptionCuentaCerrada;
import app.exceptions.ExceptionCuentaNoExiste;
import app.exceptions.ExceptionCuentaNoPerteneceAlCliente;
import app.exceptions.ExceptionSaldoInsuficiente;
import app.modelos.Cliente;
import app.modelos.ConversionDeMoneda;
import app.modelos.Cuenta;
import app.modelos.CuentaExtranjera;
import app.modelos.CuentaNacional;
import app.modelos.Direccion;
import app.servicios.ServicioCambio;
import app.servicios.ServicioCompraVentaMoneda;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuracion.class)
@Transactional
class ServicioCompraVentaMonedaImplTest {
	
	@Autowired
	private DAO<Cliente> clienteDao;
	
	@Autowired
	private DAO<Cuenta> cuentaDao;
	
	@Autowired
	private ServicioCompraVentaMoneda servicioCompraVentaMoneda;
	
	
	@Autowired
	private ServicioCambio servicioCambio;
	
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
	private final Double SALDO_ACTUAL = 200.0;
	private final Double DESCUBIERTO = 200.0;
	@SuppressWarnings("unused")
	private final LocalDate FEC_CIERRE = LocalDate.now();
	private final String MONEDA = "USD";
	
	private CuentaNacional cuentaNacional;
	private CuentaExtranjera cuentaExtranjera;
	private CuentaExtranjera cuentaExtranjera2;
	private Cliente cliente;
	private Cliente cliente2;
	
	
	@BeforeEach
	void setup() {
		direccion = new Direccion(CALLE, NUM, DEPTO, PISO, CIUDAD, CP, PROV);
		cliente = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		cliente2 = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		
		System.out.println(cliente.toString());
		
		clienteDao.save(cliente);
		clienteDao.save(cliente2);
		
		cuentaNacional = new CuentaNacional(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente);
		cuentaExtranjera = new CuentaExtranjera(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente, MONEDA);
		cuentaExtranjera2 = new CuentaExtranjera(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente2, MONEDA);
		
		cuentaDao.save(cuentaNacional);
		cuentaDao.save(cuentaExtranjera);
		cuentaDao.save(cuentaExtranjera2);
		em.flush();
		
		assertNotNull(cuentaNacional.getId());
		assertNotNull(cuentaExtranjera.getId());
	}
	
	@Test
	void CompraVentaMoneda_Exitosa() throws ExceptionCuentaNoExiste, ExceptionCuentaCerrada, ExceptionSaldoInsuficiente, ExceptionCuentaNoPerteneceAlCliente{
		
		servicioCompraVentaMoneda.comprarMoneda(cliente.getId(), cuentaExtranjera.getId(), cuentaNacional.getId(), 100.00);
		
		//Validamos el saldo actual de la cuanta nacional luego de la operacion
		Cuenta cn = em.find(Cuenta.class, cuentaNacional.getId());
		assertEquals(100.00, cn.getSaldoActual());

		ConversionDeMoneda conversion = servicioCambio.cambiar(cuentaExtranjera.getMonedaAsociada(), cuentaNacional.getMonedaAsociada(), 100.00);

		//Validamos el saldo actual de la cuanta extranjera luego de la operacion
		Cuenta ce = em.find(Cuenta.class, cuentaExtranjera.getId());
		assertEquals(cuentaExtranjera.getSaldoActual() + conversion.getResult(), ce.getSaldoActual());
		
		//Validamos que el movimiento se encuentra en la tabla de movimientos con el monto correcto para cuenta extranjera
		assertEquals(conversion.getResult(), ce.getMovimientos().get(0).getMonto());
		
		//Validamos que ell movimiento se encuentra en la tabla de movimientos con el monto en negativo para la cuenta nacional
		assertEquals(-100.00, cn.getMovimientos().get(0).getMonto());
		
	}

	
	@Test
	void CompraVentaMoneda_SaldoInsuficiente(){

		assertThrows(ExceptionSaldoInsuficiente.class, () -> {
	 		
			servicioCompraVentaMoneda.comprarMoneda(cliente.getId(), cuentaExtranjera.getId(), cuentaNacional.getId(), 300.00);
	 	});
		
	}
	
	@Test
	void CompraVentaMoneda_ClienteNoEsTitularNiCotitular(){

		assertThrows(ExceptionCuentaNoPerteneceAlCliente.class, () -> {
	 		
			servicioCompraVentaMoneda.comprarMoneda(cliente.getId(), cuentaExtranjera2.getId(), cuentaNacional.getId(), 100.00);
	 	});
		
	}
}
