package modelos;

import javax.persistence.Entity;

@Entity
public class DepositoExtraccion extends Movimiento{
	
	private String caja;
	
	public DepositoExtraccion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DepositoExtraccion(String caja) {
		super();
		this.caja = caja;
	}

	public String getCaja() {
		return caja;
	}

	
}
