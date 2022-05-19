package modelos;

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

	public void setCotizacion(float cotizacion) {
		this.cotizacion = cotizacion;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}
	
	
	
	
}
