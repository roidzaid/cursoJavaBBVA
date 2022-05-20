package modelos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class CuentaExtranjera extends Cuenta{
	
	@Column(name="moneda")
	private String monedaAsociada;

	public CuentaExtranjera() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public CuentaExtranjera(LocalDate fechaCreacion, float saldoInicial, float saldoActual, float descubierto,
			LocalDate fechaCierre, String monedaAsociada) {
		super(fechaCreacion, saldoInicial, saldoActual, descubierto, fechaCierre);
		this.monedaAsociada = monedaAsociada;
		// TODO Auto-generated constructor stub
	}




	public String getMonedaAsociada() {
		return monedaAsociada;
	}

	public void setMonedaAsociada(String monedaAsociada) {
		this.monedaAsociada = monedaAsociada;
	}


}
