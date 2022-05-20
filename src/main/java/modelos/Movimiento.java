package modelos;

import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Movimiento {

	@Id @GeneratedValue
	private long id;
	private LocalDate fechayHora;
	private float monto;
	private String descripcion;
	private Cuenta cuenta;
	
	public Movimiento() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Movimiento(LocalDate fechayHora, float monto, String descripcion, Cuenta cuenta) {
		super();
		this.fechayHora = fechayHora;
		this.monto = monto;
		this.descripcion = descripcion;
		this.cuenta = cuenta;
	}





	public LocalDate getFechayHora() {
		return fechayHora;
	}


	public float getMonto() {
		return monto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public Cuenta getCuenta() {
		return cuenta;
	}

	

	
	
	
}
