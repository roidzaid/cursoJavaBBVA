package modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import exceptions.ExcepcionApellidoInvalido;
import exceptions.ExcepcionNombreInvalido;

public class ClienteTest {

	//datos cliente
	private final String NOMBRE = "Leandro";
	private final String APELLIDO = "Roidzaid";
	private final int TELEFONO = 12345678; 
	private final String MAIL  = "Leandro@gmail.com";
	private Cliente cliente;
	
	private Direccion direccion;
	
	private CuentaExtranjera cuentaExtranjera;
	private CuentaNacional cuentaNacional;
	
	@Before
	public void before() {
		direccion = mock(Direccion.class);
		cuentaExtranjera = mock(CuentaExtranjera.class);
		cuentaNacional = mock(CuentaNacional.class);
		
	}

	@Test
	public void ConstructorFijaAtributos_Cliente() throws ExcepcionNombreInvalido, ExcepcionApellidoInvalido {
		
		cliente = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		
		assertTrue(NOMBRE.equals(cliente.getNombre()));
		assertTrue(APELLIDO.equals(cliente.getApellido()));
		assertTrue(direccion.equals(cliente.getDireccion()));
		assertTrue(TELEFONO==cliente.getTelefono());
		assertTrue(MAIL.equals(cliente.getEmail()));
		
	}
	
	 @Test 
	 public void validarDatosObligatorios_Cliente() {
		 assertThrows(ExcepcionNombreInvalido.class, () -> {
		 	 cliente = new Cliente(null, APELLIDO, direccion, TELEFONO, MAIL);
	    });
		 
		 assertThrows(ExcepcionApellidoInvalido.class, () -> {
		 	 cliente = new Cliente(NOMBRE, "", direccion, TELEFONO, MAIL);
	    });
		
	 }
	 
	 @Test
	 public void TitularYCoTitularDeMasDeUnaCuenta_Cliente() throws ExcepcionNombreInvalido, ExcepcionApellidoInvalido {
		 
		 cliente = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		 
		 cliente.agregarCuentaTitular(cuentaExtranjera);
		 cliente.agregarCuentaTitular(cuentaNacional);
		 
		 cliente.agregarCuentaCoTitular(cuentaExtranjera);
		 cliente.agregarCuentaCoTitular(cuentaNacional);
		 
		 List<Cuenta> TitularDeCuentas = cliente.getCuenta_titular();
		 
		 List<Cuenta> CoTitularDeCuentas = cliente.getCuenta_coTitulares();
		 
		 assertEquals(2, TitularDeCuentas.size());
		 assertEquals(2, CoTitularDeCuentas.size());
		 
	 }
	 
}
