package modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class ClienteTest {

	
	private String nombre = "Leandro";
	private String apellido = "Roidzaid";
	private Direccion direccion = new Direccion();
	private int telefono = 12345678;
	private String email = "roidzaid@gmail.com";
	
	
	private Cliente cliente;
	private CuentaNacional cuentaNacional;
	private CuentaExtranjera cuentaExtranjera;
	
	
	@Before
	public void crearCliente() {
		
		cliente = new Cliente(null, nombre, direccion, email);
		
		cuentaNacional = mock(CuentaNacional.class);
		cuentaExtranjera = mock(CuentaExtranjera.class);
		
	}
	
	@Test
	public void cliente_mantieneInformacionEsperada() {
		
		assertEquals(cliente.getNombre(), nombre);
		assertEquals(cliente.getApellido(), apellido);
		assertEquals(cliente.getDireccion(), direccion);
		assertEquals(cliente.getTelefono(), telefono);
		assertEquals(cliente.getEmail(), email);

	}
	
	@Test
	public void agregarCuentaTitularNacional_esTitularDeUnaCuentaNacional() {
		
		cliente.agregarCuentaTitular(cuentaNacional);
		
		assertTrue(cliente.getCuenta_coTitulares().size() > 0);
		
		
	}
	
	
	@Test
	public void agregarCuentasCoTitulares_esCoTitularDeCuentas() {
		
		cliente.agregarCuentaCoTitular(cuentaNacional);
		cliente.agregarCuentaCoTitular(cuentaExtranjera);
		
		assertTrue(cliente.getCuenta_coTitulares().size() > 0);
		
	}
		
}


