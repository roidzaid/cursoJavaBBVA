package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Transferencia extends Movimiento{
	
	@Column(name="nro_cuenta")
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
