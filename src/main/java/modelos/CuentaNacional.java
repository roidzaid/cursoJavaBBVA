package modelos;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class CuentaNacional extends Cuenta{

	
	
	public CuentaNacional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaNacional(Long nro, LocalDate fechaCreacion, float saldoInicial, float saldoActual, float descubierto,
			Cliente titular){
		super(nro, fechaCreacion, saldoInicial, saldoActual, descubierto, titular);
		
	}
	
}
