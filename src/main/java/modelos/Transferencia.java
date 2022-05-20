package modelos;

import javax.persistence.Entity;

@Entity
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

	
	

}
