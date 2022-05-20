package modelos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class CuentaTest {

	
	private LocalDate fechaCreacion = LocalDate.now();
	private float saldoInicial = 0;
	private float saldoActual = 100;
	private float descubierto = 200;
	private LocalDate fechaCierre = LocalDate.now();
	private String monedaAsociada = "USD";
	
	private Cliente cliente;
	private CuentaNacional cuentaNacional;
	private CuentaExtranjera cuentaExtranjera;
	
	private Transferencia transferencia;
	private DepositoExtraccion depositoExtraccion;
	private CompraVentaMoneda compraVentaMoneda;
	
	@Before
	public void crearCuenta() {
		
		cuentaNacional = new CuentaNacional(fechaCreacion, saldoInicial, saldoActual, descubierto, fechaCierre);
		cuentaExtranjera = new CuentaExtranjera(fechaCreacion, saldoInicial, saldoActual, descubierto, fechaCierre, monedaAsociada);
		
		cliente = mock(Cliente.class);
		transferencia = mock(Transferencia.class);
		depositoExtraccion = mock(DepositoExtraccion.class);
		compraVentaMoneda = mock(CompraVentaMoneda.class);
		
		
	}
	
	
	@Test
	public void cuenta_MantieneDatosEsperados() {
		assertEquals(cuentaNacional.getFechaCreacion(), fechaCreacion);
		assertTrue(cuentaNacional.getSaldoInicial()==saldoInicial);
		assertTrue(cuentaNacional.getSaldoActual()==saldoActual);
		assertTrue(cuentaNacional.getDescubierto()==descubierto);
		assertEquals(cuentaNacional.getFechaCierre(), fechaCierre);
	}
	
	
	@Test
	public void AgregarMovimientos_guardaLosMovimientos() {
		cuentaNacional.agregarMovimiento(compraVentaMoneda);
		cuentaNacional.agregarMovimiento(depositoExtraccion);
		cuentaNacional.agregarMovimiento(transferencia);
		
		assertTrue("la cantidad no guarda los movimientos ", cuentaNacional.getMovimientos().size()>0);
		
	}
	
	

}
