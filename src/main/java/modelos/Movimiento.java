package modelos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIMIENTOS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Movimiento{

	@Id @GeneratedValue
	@Column(name="id_movimiento")
	private long id;
	
	@Column(name="fecha_hora")
	private LocalDate fechayHora;
	
	private float monto;
	private String descripcion;
	
	@ManyToOne
	private Cuenta cuenta;
	
	public Movimiento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movimiento(LocalDate fechayHora, float monto, String descripcion) {
		super();
		this.fechayHora = fechayHora;
		this.monto = monto;
		this.descripcion = descripcion;
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

	
	
	
}
