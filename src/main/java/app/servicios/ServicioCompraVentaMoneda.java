package app.servicios;

import org.springframework.stereotype.Component;

import app.exceptions.ExceptionCuentaCerrada;
import app.exceptions.ExceptionCuentaNoExiste;
import app.exceptions.ExceptionCuentaNoPerteneceAlCliente;
import app.exceptions.ExceptionSaldoInsuficiente;

@Component
public interface ServicioCompraVentaMoneda {

	
	public void comprarMoneda(Long idCliente, Long idcuentaExtranjera, Long idCuentaNacional, Double monto) 
			throws ExceptionCuentaNoExiste, 
			       ExceptionCuentaCerrada, 
			       ExceptionSaldoInsuficiente, ExceptionCuentaNoPerteneceAlCliente;
}
