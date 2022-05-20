package modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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
		
		cliente = new Cliente(nombre, apellido, direccion, telefono, email);
		
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
		
		assertTrue(cliente.getCuentasTitulares().size() > 0);
		
		assertTrue(cliente.getCuentasTitulares().get(0).getClass().equals(cuentaNacional.getClass()));
		
	}
	
	
	@Test
	public void agregarCuentasCoTitulares_esCoTitularDeCuentas() {
		
		cliente.agregarCuentaCoTitular(cuentaNacional);
		cliente.agregarCuentaCoTitular(cuentaExtranjera);
		
		assertTrue(cliente.getCuentasCoTitulares().size() > 0);
		
		assertTrue(cliente.getCuentasCoTitulares().get(0).getClass().equals(cuentaNacional.getClass()));
		assertTrue(cliente.getCuentasCoTitulares().get(1).getClass().equals(cuentaExtranjera.getClass()));
		
	}
	
	
		
		
}


