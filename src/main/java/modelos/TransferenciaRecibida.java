package modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "TRANSFERENCIAS_RECIBIDAS")
@Getter
public class TransferenciaRecibida extends Movimiento{

	@ManyToOne
	private Cuenta cuentaOrigen;

	public TransferenciaRecibida(LocalDate fechayHora, float monto, String descripcion, Cuenta cuenta, Cuenta cuentaOrigen) {
		super(fechayHora, monto, descripcion, cuenta);

		this.cuentaOrigen=cuentaOrigen;
	}

}
