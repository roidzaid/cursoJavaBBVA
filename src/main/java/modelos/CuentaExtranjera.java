package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuentaExtranjera extends Cuenta{
	
	@NonNull
	@Column(name="moneda")
	private String monedaAsociada;

	
}
