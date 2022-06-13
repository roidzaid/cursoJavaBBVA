package app.servicios;

import app.modelos.ConversionDeMoneda;

public interface ServicioCambio {
	
	public ConversionDeMoneda cambiar(String monedaDE, String monedaA, Double monto);

	
	
}
