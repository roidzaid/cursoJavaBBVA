package servicios;

import exceptions.ExceptionCuentaCerrada;
import exceptions.ExceptionCuentaNoExiste;
import exceptions.ExceptionSaldoInsuficiente;

public interface ServicioCompraVentaMoneda {

	
	public void comprarMoneda(Long idCliente, Long idcuentaExtranjera, Long idCuentaNacional, Double monto) 
			throws ExceptionCuentaNoExiste, 
			       ExceptionCuentaCerrada, 
			       ExceptionSaldoInsuficiente;
}
