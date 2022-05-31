package modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

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
	public void ConstructorFijaAtributos_Cliente(){
		
		cliente = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		
		assertTrue(NOMBRE.equals(cliente.getNombre()));
		assertTrue(APELLIDO.equals(cliente.getApellido()));
		assertTrue(direccion.equals(cliente.getDireccion()));
		assertTrue(TELEFONO==cliente.getTelefono());
		assertTrue(MAIL.equals(cliente.getEmail()));
		
	}
	
	 @Test 
	 public void validarDatosObligatorios_Cliente(){
		
		 cliente = new Cliente(null, APELLIDO, direccion, TELEFONO, MAIL);
		 
		 ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		 Validator validator = factory.getValidator();
		 Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);

		 assertTrue(violations.size() > 0);
		 
	 }
	 
	 @Test
	 public void TitularYCoTitularDeMasDeUnaCuenta_Cliente(){
		 
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
