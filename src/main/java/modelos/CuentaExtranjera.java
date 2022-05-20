package modelos;

import java.time.LocalDate;
import javax.persistence.Entity;

@Entity
public class CuentaExtranjera extends Cuenta{
	
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
