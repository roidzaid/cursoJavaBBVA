package modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;


public class ClienteTest {

	
	private Cliente cliente;
	private CuentaNacional cuentaNacional;
	private CuentaExtranjera cuentaExtranjera;
	
	
	@Before
	public void crearCliente() {
		
		cuentaNacional = mock(CuentaNacional.class);
		
	}
	
	@Test
	public void agregarCuentaTitular_ElClienteTieneUnaCuentaTitular() {
		
		cliente.AgregarCuentaTitular(cuentaNacional);
		
		for(int i = 0; cliente.getCuentasTitularNacionales().size()<i; i++) {
			CuentaNacional c = (CuentaNacional) cliente.getCuentasTitularNacionales().get(i);
			
			assertTrue(c.getClass().equals(cuentaNacional));

		}
		
		
	}

	

}
