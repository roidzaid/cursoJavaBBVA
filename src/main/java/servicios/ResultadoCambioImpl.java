package servicios;

import org.springframework.stereotype.Service;

@Service
public class ResultadoCambioImpl implements ResultadoCambio{

	private Double tasa = 200.00;

	/**
	 *  @return Tasa aplicada al cambio
	 */
	public Double getTasa() {
		return tasa;
	};
	/**
	 * @return El resultado de la conversion
	 */
	@Override
	public Double getResultado(Double monto) {
		return monto/tasa;
	}
	
	
	
	
	

	
}
