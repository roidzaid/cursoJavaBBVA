package modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "TRANSFERENCIAS_REALIZADAS")
@Getter
public class TransferenciaRealizada extends Movimiento{

	@ManyToOne
	private Cuenta cuentaDestino;

	public TransferenciaRealizada(LocalDate fechayHora, float monto, String descripcion, Cuenta cuenta, Cuenta cuentaDestino) {
		super(fechayHora, monto, descripcion, cuenta);
	
		this.cuentaDestino=cuentaDestino;
	}
		

}
