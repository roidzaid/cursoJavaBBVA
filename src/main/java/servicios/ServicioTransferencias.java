package servicios;

import javax.transaction.Transactional;

import exceptions.ExceptionCuentaCerrada;
import exceptions.ExceptionCuentaNoExiste;
import exceptions.ExceptionSaldoInsuficiente;

public interface ServicioTransferencias {
	
	@Transactional
	public void transferir(Long idCuentaOrigen, float monto, Long idCuentaDestino) throws ExceptionCuentaCerrada, ExceptionSaldoInsuficiente, ExceptionCuentaNoExiste;

}
