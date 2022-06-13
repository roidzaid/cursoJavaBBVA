package app.modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "COMPRA_VENTA_MONEDA")
@Getter
public class CompraVentaMoneda extends Movimiento{

	private Double cotizacion;
	private Double comision;
	
	public CompraVentaMoneda(LocalDate fechayHora, Double monto, String descripcion, Cuenta cuenta, Double cotizacion, Double comision) {
		super(fechayHora, monto, descripcion, cuenta);
		
		this.comision=comision;
		this.cotizacion=cotizacion;
	}
	
	
	
	
}
