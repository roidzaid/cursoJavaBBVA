package modelos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "COMPRA_VENTA_MONEDA")
@Getter
public class CompraVentaMoneda extends Movimiento{

	private float cotizacion;
	private float comision;
	
	public CompraVentaMoneda(LocalDate fechayHora, float monto, String descripcion, Cuenta cuenta, float cotizacion, float comision) {
		super(fechayHora, monto, descripcion, cuenta);
		
		this.comision=comision;
		this.cotizacion=cotizacion;
	}
	
	
	
	
}
