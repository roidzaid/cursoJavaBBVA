package modelos;

import java.util.Date;
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


	

	

	
	
	

}
