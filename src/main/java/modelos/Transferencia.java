package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSFERENCIAS")
public class Transferencia extends Movimiento{
	
	@Column(name="nro_cuenta")
	@ManyToOne
	private Cuenta cuenta;

	
	public Transferencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transferencia(Cuenta cuenta) {
		super();
		this.cuenta = cuenta;
	}

	

	
	

}
