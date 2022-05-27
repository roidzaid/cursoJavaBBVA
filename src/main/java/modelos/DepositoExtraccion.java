package modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "DEPOSITO_EXTRACCION")
@Getter
public class DepositoExtraccion extends Movimiento{

	private String caja;
	
	public DepositoExtraccion(LocalDate fechayHora, float monto, String descripcion, Cuenta cuenta, String caja) {
		super(fechayHora, monto, descripcion, cuenta);

		this.caja=caja;
		
	}
	

	
}
