package modelos;

import java.time.LocalDate;

import javax.persistence.Entity;

import exceptions.ExcepcionFechaDeCreacionInvalida;
import exceptions.ExcepcionNroCuentaInvalido;
import exceptions.ExcepcionSaldoInicialInvalido;

@Entity
public class CuentaNacional extends Cuenta{

	public CuentaNacional(Long nro, LocalDate fechaCreacion, float saldoInicial, float saldoActual, float descubierto,
			Cliente titular)
			throws ExcepcionNroCuentaInvalido, ExcepcionFechaDeCreacionInvalida, ExcepcionSaldoInicialInvalido {
		super(nro, fechaCreacion, saldoInicial, saldoActual, descubierto, titular);
		
	}
	
}
