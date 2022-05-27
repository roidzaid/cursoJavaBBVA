package daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import configuracion.Configuracion;
import exceptions.ExcepcionApellidoInvalido;
import exceptions.ExcepcionDireccionInvalida;
import exceptions.ExcepcionNombreInvalido;
import modelos.Cliente;
import modelos.Direccion;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Configuracion.class)
@Transactional
class ClienteDAOTest {

	@Autowired
	private DAO<Cliente> clienteDao;
	
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
	
	
	@BeforeEach
	void setUp() throws Exception {
		direccion = new Direccion(CALLE, NUM, DEPTO, PISO, CIUDAD, CP, PROV);
		cliente = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
	}
	
	
	@Test
	void guardarCliente(){
 		
		clienteDao.save(cliente);
		em.flush();
 		
 		assertNotNull(cliente.getId());
 		
 		em.clear();
 		Cliente c = em.find(Cliente.class, cliente.getId());
 		
 		assertNotNull(c);
		assertFalse(cliente == c);
 		assertEquals(cliente.getNombre(), c.getNombre());
	}
	
	@Test
	void buscarClientePorNombre(){
 		
		clienteDao.save(cliente);
		em.flush();
		
		Optional<Cliente> cliente = clienteDao.findByNombre(NOMBRE);
 		
 		assertNotNull(cliente);
 		assertEquals(cliente.get().getNombre(), NOMBRE);
	}
	
	
	@Test
	void modificarCliente(){
 		
		clienteDao.save(cliente);
		em.flush();
		
		cliente.setNombre("Matias");
		em.flush();
		
		Optional<Cliente> cliente = clienteDao.findByNombre("Matias");
 		
 		assertNotNull(cliente);
 		assertEquals(cliente.get().getNombre(), "Matias");
	}

}
