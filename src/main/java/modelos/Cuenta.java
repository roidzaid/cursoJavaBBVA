package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Cuenta {
	
	private Long Nro;
	private Date fechaCreacion;
	private float saldoInicial;
	private float saldoActual;
	private float descubierto;
	private Date fechaCierre;
	private Cliente titular;
	private List<Cliente> coTitulares = new ArrayList<>();
	private List<Movimiento> movimientos = new ArrayList<>();
	
	public Cuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Cuenta(Long nro, Date fechaCreacion, float saldoInicial, float saldoActual, float descubierto,
			Date fechaCierre) {
		super();
		Nro = nro;
		this.fechaCreacion = fechaCreacion;
		this.saldoInicial = saldoInicial;
		this.saldoActual = saldoActual;
		this.descubierto = descubierto;
		this.fechaCierre = fechaCierre;
	}


	public Cliente getTitular() {
		return titular;
	}


	public void setTitular(Cliente titular) {
		this.titular = titular;
	}


	public List<Cliente> getcoTitulares() {
		return coTitulares;
	}


	public void agregarcoTitulares(Cliente cliente) {
		
		coTitulares.add(cliente);
	}


	public List<Movimiento> getMovimientos() {
		return movimientos;
	}


	public void agregarMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
	}
	
	
	


	

	

	
	
	

}
