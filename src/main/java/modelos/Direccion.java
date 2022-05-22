package modelos;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
	
	
	private String calle;
	private int numeroCivico;
	private String departamento;
	private int piso;
	private String ciudad;
	private int codigoPosta;
	private String provincia;
	

}
