package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import configuracion.Configuracion;
import daos.DAO;
import exceptions.ExcepcionApellidoInvalido;
import exceptions.ExcepcionDireccionInvalida;
import exceptions.ExcepcionNombreInvalido;
import modelos.Cliente;
import modelos.Direccion;

@Component
public class miBancoLeandroRoidzaid {

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
	
	
	@Autowired
	private DAO<Cliente> clienteDao;

	@Transactional
	public void usar() throws ExcepcionDireccionInvalida, ExcepcionNombreInvalido, ExcepcionApellidoInvalido {
		
		direccion = new Direccion(CALLE, NUM, DEPTO, PISO, CIUDAD, CP, PROV);
		cliente = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		
		clienteDao.save(cliente);
		
	}
	
		
	public static void main(String[] args) throws ExcepcionDireccionInvalida, ExcepcionNombreInvalido, ExcepcionApellidoInvalido {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuracion.class);
		
		miBancoLeandroRoidzaid usa = ctx.getBean("miBancoLeandroRoidzaid",miBancoLeandroRoidzaid.class);
		usa.usar();
		
		((ConfigurableApplicationContext) ctx).close();

	}

}


