package app.modelos;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class CuentaNacional extends Cuenta{

	
	
	public CuentaNacional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaNacional(Long nro, LocalDate fechaCreacion, Double saldoInicial, Double saldoActual, Double descubierto,
			Cliente titular){
		super(nro, fechaCreacion, saldoInicial, saldoActual, descubierto, titular);
		
	}
	
	public String getMonedaAsociada() {
		return "ARS";
	}
}
