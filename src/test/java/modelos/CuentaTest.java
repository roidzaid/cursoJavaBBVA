package modelos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

public class CuentaTest {

	
	private final int NUMERO = 123456789;
	private final Long NUMERO_CTA = (long) NUMERO;
	private final LocalDate FEC_CREACION = LocalDate.now();
	private final Double SALDO_INICIAL = 100.0;
	private final Double SALDO_ACTUAL = 100.0;
	private final Double DESCUBIERTO = 200.0;
	@SuppressWarnings("unused")
	private final LocalDate FEC_CIERRE = LocalDate.now();
	private final String MONEDA = "USD";
	
	private Cliente titular;
	private Cliente coTitular1;
	private Cliente coTitular2;
	private Cliente coTitular3;
	private Cliente coTitular4;
	private CuentaNacional cuentaNacional;
	private CuentaExtranjera cuentaExtranjera;
	
	private TransferenciaRecibida transferencia;
	private DepositoExtraccion depositoExtraccion;
	private CompraVentaMoneda compraVentaMoneda;
	
	@Before
	public void crearCuenta() {
		
		titular = mock(Cliente.class);
		coTitular1 = mock(Cliente.class);
		coTitular2 = mock(Cliente.class);
		coTitular3 = mock(Cliente.class);
		coTitular4 = mock(Cliente.class);
		
		transferencia = mock(TransferenciaRecibida.class);
		depositoExtraccion = mock(DepositoExtraccion.class);
		compraVentaMoneda = mock(CompraVentaMoneda.class);
		
		
	}
	
	@Test
	public void constructorFijaAtributos_CuentaExtranjera(){
		
		cuentaExtranjera = new CuentaExtranjera(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, titular, MONEDA);
		
		assertTrue(NUMERO_CTA.equals(cuentaExtranjera.getNro()));
		assertTrue(FEC_CREACION.equals(cuentaExtranjera.getFechaCreacion()));
		assertTrue(SALDO_INICIAL == cuentaExtranjera.getSaldoInicial());
		assertTrue(SALDO_ACTUAL == cuentaExtranjera.getSaldoActual());
		assertTrue(DESCUBIERTO  == cuentaExtranjera.getDescubierto());
		assertTrue(titular.equals(cuentaExtranjera.getTitular()));
		assertTrue(MONEDA.equals(cuentaExtranjera.getMonedaAsociada()));
		
	}
	
	@Test
	public void constructorFijaAtributos_CuentaNacional(){
		
		cuentaNacional = new CuentaNacional(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, titular);
		
		assertTrue(NUMERO_CTA.equals(cuentaNacional.getNro()));
		assertTrue(FEC_CREACION.equals(cuentaNacional.getFechaCreacion()));
		assertTrue(SALDO_INICIAL == cuentaNacional.getSaldoInicial());
		assertTrue(SALDO_ACTUAL == cuentaNacional.getSaldoActual());
		assertTrue(DESCUBIERTO  == cuentaNacional.getDescubierto());
		assertTrue(titular.equals(cuentaNacional.getTitular()));
		
	}
	
	
	@Test 
	 public void validarDatosObligatorios_CuentaExtranjera() {
		
		cuentaExtranjera = new CuentaExtranjera(NUMERO_CTA, null, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, titular, MONEDA);
		
		 ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 Validator validator = factory.getValidator();
		 Set<ConstraintViolation<CuentaExtranjera>> violations = validator.validate(cuentaExtranjera);
		
		 assertTrue(violations.size() > 0);
		 
	}
	
	@Test 
	 public void validarMoneda_CuentaExtranjera() {
	
		cuentaExtranjera = new CuentaExtranjera(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, titular, null); 
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 Validator validator = factory.getValidator();
		 Set<ConstraintViolation<CuentaExtranjera>> violations = validator.validate(cuentaExtranjera);
		
		 assertTrue(violations.size() > 0);
		
	}	
	 
	
	
	@Test
	public void Cuenta_tieneMovimientos(){
		
		cuentaNacional = new CuentaNacional(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, titular);
		
		cuentaNacional.agregarMovimiento(compraVentaMoneda);
		cuentaNacional.agregarMovimiento(transferencia);
		cuentaNacional.agregarMovimiento(depositoExtraccion);
		
		List<Movimiento> movimientos = cuentaNacional.getMovimientos();
		
		assertEquals(3, movimientos.size());
		
	}
	
	
	@Test
	public void Cuenta_tieneCotitulares(){
		
		cuentaNacional = new CuentaNacional(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, titular);
		
		cuentaNacional.agregarCotitulares(coTitular1);
		cuentaNacional.agregarCotitulares(coTitular2);
		cuentaNacional.agregarCotitulares(coTitular3);
		cuentaNacional.agregarCotitulares(coTitular4);
		
		List<Cliente> coTitulares = cuentaNacional.getCoTitulares();
		
		assertEquals(4, coTitulares.size());
		
	}

}
