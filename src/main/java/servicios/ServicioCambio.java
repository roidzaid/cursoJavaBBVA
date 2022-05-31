package servicios;

public interface ServicioCambio {
	/**
	 * Permite convertir un monto de una moneda 
	 * a otra aplicando la tasa de conversion actual
	 * @param de Moneda identificación de la moneda 
	 * del monto a convertir
	 * @param a  Moneda del monto convertido
	 * @param monto a convertir
	 * @return el resultado de la operación de cambio
	 */
	public ResultadoCambio cambiar(String MonedaDE, String MonedaA, Double monto);
}

