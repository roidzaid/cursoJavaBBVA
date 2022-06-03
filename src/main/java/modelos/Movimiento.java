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

import lombok.Getter;

@Entity
@Table(name = "MOVIMIENTOS")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
public abstract class Movimiento{

	@Id @GeneratedValue
	@Column(name="id_movimiento")
	private long id;
	
	@Column(name="fecha_hora")
	private LocalDate fechayHora;
	
	private Double monto;
	private String descripcion;
	
	@ManyToOne
	private Cuenta cuenta;
	

	public Movimiento(LocalDate fechayHora, Double monto, String descripcion, Cuenta cuenta) {
		this.fechayHora = fechayHora;
		this.monto = monto;
		this.descripcion = descripcion;
		this.cuenta = cuenta;
	}
	
}
