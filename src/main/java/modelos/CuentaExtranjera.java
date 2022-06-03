package modelos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
public class CuentaExtranjera extends Cuenta{
	
	@NotEmpty
	@Column(name="moneda")
	private String monedaAsociada;

	public CuentaExtranjera(Long nro, LocalDate fechaCreacion, Double saldoInicial, Double saldoActual, Double descubierto,
			Cliente titular, String monedaAsociada){
		
		super(nro, fechaCreacion, saldoInicial, saldoActual, descubierto, titular);
		
		this.monedaAsociada = monedaAsociada;
		
	}

	public CuentaExtranjera() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaExtranjera(Long nro, LocalDate fechaCreacion, Double saldoInicial, Double saldoActual, Double descubierto,
			Cliente titular) {
		super(nro, fechaCreacion, saldoInicial, saldoActual, descubierto, titular);
		// TODO Auto-generated constructor stub
	}

	public String getMonedaAsociada() {
		return monedaAsociada;
	}

	
	

	
	

	
	
}
