package app.modelos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CuentaModel {

	private Long nro;
	private LocalDate fechaCreacion;
	private Double saldoInicial;
	private Double saldoActual;
	private Double descubierto;
	private String moneda;
	private Long idTitular;
	
	
}
