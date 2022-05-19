package modelos;

import java.util.Date;

public class TransferenciaRecibida extends Movimiento{
	
	private Long cuentaOrigen;

	public TransferenciaRecibida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransferenciaRecibida(Date fechayHora, float monto, String descripcion) {
		super(fechayHora, monto, descripcion);
		// TODO Auto-generated constructor stub
	}

	public Long getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(Long cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	
	

}
