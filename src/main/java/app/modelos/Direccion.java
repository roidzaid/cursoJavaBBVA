package app.modelos;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Direccion {
	
	private String calle;
	private int numeroCivico;
	private String departamento;
	private int piso;
	private String ciudad;
	private int codigoPosta;
	private String provincia;
	
	
	
	
	public Direccion(String calle, int numeroCivico, String departamento, int piso, String ciudad, int codigoPosta, String provincia){
		this.calle = calle;
		this.numeroCivico = numeroCivico;
		this.departamento = departamento;
		this.piso = piso;
		this.ciudad = ciudad;
		this.codigoPosta = codigoPosta;
		this.provincia = provincia;
	}
	
	

}
