package modelos;

import javax.persistence.Entity;

@Entity
public class CompraVentaMoneda extends Movimiento{

	private float cotizacion;
	private float comision;
	
	public CompraVentaMoneda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompraVentaMoneda(float cotizacion, float comision) {
		super();
		this.cotizacion = cotizacion;
		this.comision = comision;
	}

	public float getCotizacion() {
		return cotizacion;
	}


	public float getComision() {
		return comision;
	}

	
	
	
}
