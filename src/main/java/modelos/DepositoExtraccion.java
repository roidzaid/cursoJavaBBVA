package modelos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

public class DepositoExtraccion extends Movimiento{
	
	private String caja;

	
	
	public DepositoExtraccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepositoExtraccion(Date fechayHora, float monto, String descripcion) {
		super(fechayHora, monto, descripcion);
		// TODO Auto-generated constructor stub
	}

	public String getCaja() {
		return caja;
	}

	public void setCaja(String caja) {
		this.caja = caja;
	}
	
	

}
