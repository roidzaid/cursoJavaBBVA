package app.servicios;

import javax.transaction.Transactional;

import app.exceptions.ExceptionCuentaCerrada;
import app.exceptions.ExceptionCuentaNoExiste;
import app.exceptions.ExceptionSaldoInsuficiente;

public interface ServicioTransferencias {
	
	@Transactional
	public void transferir(Long idCuentaOrigen, Double monto, Long idCuentaDestino) throws ExceptionCuentaCerrada, ExceptionSaldoInsuficiente, ExceptionCuentaNoExiste;

}
