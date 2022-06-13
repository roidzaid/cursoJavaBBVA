package app.servicios;

import java.util.Collection;

import app.exceptions.ExceptionClienteYaEsCoTitularDeLaCuenta2;
import app.exceptions.ExceptionClienteYaEsTitularDeLaCuenta;
import app.exceptions.ExceptionCuentaCerrada;
import app.exceptions.ExceptionCuentaNoExiste;
import app.exceptions.ExceptionSaldoInsuficiente;
import app.modelos.Cuenta;
import app.modelos.CuentaModel;
import app.modelos.Movimiento;

public interface ServicioCuentas {
	
	public Collection<Cuenta> listarCuentas();
	public void crearCuentaNacional(CuentaModel cuenta);
	public void crearCuentaExtranjera(CuentaModel cuenta);
	
	public void agregarCoTitular(Long idCliente, Long idCuenta) 
			throws ExceptionClienteYaEsTitularDeLaCuenta, 
			       ExceptionClienteYaEsCoTitularDeLaCuenta2;
	
	public Collection<Movimiento> listarMovimientos(Long idCuenta);
	
	public void transferir(Long idCuentaOrigen, Long idCuentaDestino, Double Monto) 
			throws ExceptionCuentaCerrada, 
			       ExceptionSaldoInsuficiente, 
			       ExceptionCuentaNoExiste;
	
	public void agregarTitular(Long idCliente, Long idCuenta);

}
