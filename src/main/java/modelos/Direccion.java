package modelos;

import javax.persistence.Embeddable;

@Embeddable
public class Direccion {
	
	
	private String calle;
	private int numeroCivico;
	private String departamento;
	private int piso;
	private String ciudad;
	private int codigoPosta;
	private String provincia;
	
	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Direccion(String calle, int numeroCivico, String departamento, int piso, String ciudad, int codigoPosta,
			String provincia) {
		super();
		this.calle = calle;
		this.numeroCivico = numeroCivico;
		this.departamento = departamento;
		this.piso = piso;
		this.ciudad = ciudad;
		this.codigoPosta = codigoPosta;
		this.provincia = provincia;
	}

	
	public String getDireccion() {
		return  calle + " " + numeroCivico + " " + departamento + " " + piso + ", " + ciudad + " " + codigoPosta + ", " + provincia;
	}
	
	

}
