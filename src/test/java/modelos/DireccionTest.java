package modelos;

import static org.junit.Assert.*;
import org.junit.Test;

import exceptions.ExcepcionDireccionInvalida;

public class DireccionTest {

	//datos direccion	
	private final String CALLE = "Juan Larrea";
	private final int NUM = 460;
	private final String DEPTO = "D";
	private final int PISO = 1;
	private final String CIUDAD = "Moron";
	private final int CP = 1708;
	private final String PROV = "Buenos Aires";
	private Direccion direccion;
	
	
	@Test
	public void ConstructorFijaAtributos_Direccion() throws ExcepcionDireccionInvalida {
		
		direccion = new Direccion(CALLE, NUM, DEPTO, PISO, CIUDAD, CP, PROV);
		
		assertTrue(CALLE.equals(direccion.getCalle()));
		assertTrue(NUM == direccion.getNumeroCivico());
		assertTrue(DEPTO.equals(direccion.getDepartamento()));
		assertTrue(PISO == direccion.getPiso());
		assertTrue(CIUDAD.equals(direccion.getCiudad()));
		assertTrue(CP == direccion.getCodigoPosta());
		assertTrue(PROV.equals(direccion.getProvincia()));
		
	}

}
