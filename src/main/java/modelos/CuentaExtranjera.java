package modelos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import exceptions.ExcepcionFechaDeCreacionInvalida;
import exceptions.ExcepcionMonedaCuentaExtranjera;
import exceptions.ExcepcionNroCuentaInvalido;
import exceptions.ExcepcionSaldoInicialInvalido;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CuentaExtranjera extends Cuenta{
	
	@Column(name="moneda")
	private String monedaAsociada;

	public CuentaExtranjera(Long nro, LocalDate fechaCreacion, float saldoInicial, float saldoActual, float descubierto,
			Cliente titular, String monedaAsociada)
			throws ExcepcionNroCuentaInvalido, ExcepcionFechaDeCreacionInvalida, ExcepcionSaldoInicialInvalido, ExcepcionMonedaCuentaExtranjera {
		
		super(nro, fechaCreacion, saldoInicial, saldoActual, descubierto, titular);
		
		if(monedaAsociada==null || monedaAsociada=="") {
			throw new ExcepcionMonedaCuentaExtranjera();
		}
		
		this.monedaAsociada = monedaAsociada;
		
	}
	
	

	
	

	
	
}
