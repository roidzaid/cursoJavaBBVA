package main;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import configuracion.Configuracion;
import daos.DAO;
import exceptions.ExceptionCuentaCerrada;
import exceptions.ExceptionCuentaNoExiste;
import exceptions.ExceptionSaldoInsuficiente;
import modelos.Cliente;
import modelos.Cuenta;
import modelos.CuentaExtranjera;
import modelos.CuentaNacional;
import modelos.Direccion;
import servicios.ServicioCambio;
import servicios.ServicioCompraVentaMoneda;

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
	
	private final int NUMERO = 123456789;
	private final Long NUMERO_CTA = (long) NUMERO;
	private final LocalDate FEC_CREACION = LocalDate.now();
	private final Double SALDO_INICIAL = 100.0;
	private final Double SALDO_ACTUAL = 100.0;
	private final Double DESCUBIERTO = 200.0;
	@SuppressWarnings("unused")
	private final LocalDate FEC_CIERRE = LocalDate.now();
	private final String MONEDA = "USD";
	private CuentaNacional cuentaNacional;
	private CuentaExtranjera cuentaExtranjera;
	
	@Autowired
	private DAO<Cliente> clienteDao;
	
	@Autowired
	private DAO<Cuenta> cuentaDao;
	
	@Autowired
	private ServicioCompraVentaMoneda comprarMoneda;

	@Transactional
	public void usar(){
		
		direccion = new Direccion(CALLE, NUM, DEPTO, PISO, CIUDAD, CP, PROV);
		cliente = new Cliente(NOMBRE, APELLIDO, direccion, TELEFONO, MAIL);
		
		clienteDao.save(cliente);
		
		cuentaExtranjera = new CuentaExtranjera(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente, MONEDA);
		
		cuentaDao.save(cuentaExtranjera);
		
		cuentaNacional = new CuentaNacional(NUMERO_CTA, FEC_CREACION, SALDO_INICIAL, SALDO_ACTUAL, DESCUBIERTO, cliente);
		
		cuentaDao.save(cuentaNacional);
		
		System.out.println(clienteDao.findByNombre("Leandro"));
		
		
		try {
			
			comprarMoneda.comprarMoneda(cliente.getId(), cuentaExtranjera.getId(), cuentaNacional.getId(), 50.0);
			
		} catch (ExceptionCuentaNoExiste | ExceptionCuentaCerrada | ExceptionSaldoInsuficiente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
		
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuracion.class);
		
		miBancoLeandroRoidzaid usa = ctx.getBean("miBancoLeandroRoidzaid",miBancoLeandroRoidzaid.class);
		usa.usar();
		
		((ConfigurableApplicationContext) ctx).close();

	}

}


