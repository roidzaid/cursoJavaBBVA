package modelos;

import java.time.LocalDate;
import javax.persistence.Entity;

@Entity
public class CuentaNacional extends Cuenta{

	
	public CuentaNacional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaNacional(LocalDate fechaCreacion, float saldoInicial, float saldoActual, float descubierto,
			LocalDate fechaCierre) {
		super(fechaCreacion, saldoInicial, saldoActual, descubierto, fechaCierre);
		// TODO Auto-generated constructor stub
	}

	
	
	

	
	
}
