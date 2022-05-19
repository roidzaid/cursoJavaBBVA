package modelos;

import java.util.Date;

public class Transferencia extends Movimiento{
	
	private Long nroCuenta;

	public Transferencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transferencia(Long nroCuenta) {
		super();
		this.nroCuenta = nroCuenta;
	}

	public Long getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(Long nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	
	
	
	
	

}
