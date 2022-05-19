package modelos;

import java.util.Date;

public class TransferenciasRealizadas  extends Movimiento{

	private Long cuentaDestino;

	public TransferenciasRealizadas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransferenciasRealizadas(Date fechayHora, float monto, String descripcion) {
		super(fechayHora, monto, descripcion);
		// TODO Auto-generated constructor stub
	}

	public Long getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(Long cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
	
	
}
