package app.serviciosImpl;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.daos.DAO;
import app.exceptions.ExceptionCuentaCerrada;
import app.exceptions.ExceptionCuentaNoExiste;
import app.exceptions.ExceptionCuentaNoPerteneceAlCliente;
import app.exceptions.ExceptionSaldoInsuficiente;
import app.modelos.Cliente;
import app.modelos.CompraVentaMoneda;
import app.modelos.ConversionDeMoneda;
import app.modelos.Cuenta;
import app.modelos.CuentaExtranjera;
import app.modelos.CuentaNacional;
import app.servicios.ServicioCambio;
import app.servicios.ServicioCompraVentaMoneda;

@Transactional
@Service
public class ServicioCompraVentaMonedaImpl implements ServicioCompraVentaMoneda{

	@Autowired
	private DAO<Cuenta> cuentaDAO;
	
	@Autowired
	private DAO<Cliente> clienteDAO;
	
	@Autowired
	private DAO<CompraVentaMoneda> comVenMonedaDAO;
	
	//@Autowired
	//private ResultadoCambio resultadoCambio;
	
	@Autowired
	private ServicioCambio servicioCambio;
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void comprarMoneda(Long idCliente, Long idcuentaExtranjera, Long idCuentaNacional, Double monto) 
			throws ExceptionCuentaNoExiste, ExceptionCuentaCerrada, ExceptionSaldoInsuficiente, ExceptionCuentaNoPerteneceAlCliente{

		Optional<Cliente> c = clienteDAO.findById(idCliente);
		
		Cliente cliente = c.get();
		
		if(cliente != null) {
			
			Optional<Cuenta> ce = cuentaDAO.findById(idcuentaExtranjera);
			
			if(!ce.isPresent()) {
				throw new ExceptionCuentaNoExiste();
			}
			
			CuentaExtranjera cuentaExtranjera = (CuentaExtranjera) ce.get();
			cuentaExtranjera.ValidarEstadoDeCuenta();
			
			Optional<Cuenta> cn = cuentaDAO.findById(idCuentaNacional);
			
			if(!cn.isPresent()) {
				throw new ExceptionCuentaNoExiste();
			}
			
			CuentaNacional cuentaNacional = (CuentaNacional) cn.get();
			cuentaNacional.ValidarEstadoDeCuenta();
			cuentaNacional.validarSaldoDisponible(monto);
			
			if((cuentaExtranjera.esTitular(cliente) || cuentaExtranjera.esCoTitular(cliente)) && 
			   (cuentaNacional.esTitular(cliente) || cuentaNacional.esCoTitular(cliente))){
				
				ConversionDeMoneda conversion = servicioCambio.cambiar(cuentaExtranjera.getMonedaAsociada(), cuentaNacional.getMonedaAsociada(), monto);
				
				
				CompraVentaMoneda compraMonedaExt = new CompraVentaMoneda(LocalDate.now(), conversion.getResult(), "compra moneda", cuentaExtranjera, conversion.getRate(), 0.0);
				comVenMonedaDAO.save(compraMonedaExt);
				cuentaExtranjera.agregarMovimiento(compraMonedaExt);
				cuentaExtranjera.setSaldoActual(cuentaExtranjera.getSaldoActual() + conversion.getResult());
				cuentaDAO.update(cuentaExtranjera);
				em.flush();
				
				CompraVentaMoneda compraMonedaNac = new CompraVentaMoneda(LocalDate.now(), -monto, "venta moneda", cuentaNacional, conversion.getRate(), 0.0);
				comVenMonedaDAO.save(compraMonedaNac);
				cuentaNacional.agregarMovimiento(compraMonedaNac);
				cuentaNacional.setSaldoActual(cuentaNacional.getSaldoActual() - monto);
				cuentaDAO.update(cuentaNacional);
				
				em.flush();
				
				
			}else {
				throw new ExceptionCuentaNoPerteneceAlCliente();
			}
				
		}else {
			System.out.println("El cliente no existe");
		}
				
		
	}
}
