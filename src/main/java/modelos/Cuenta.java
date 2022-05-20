package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "CUENTAS")
public abstract class Cuenta implements java.io.Serializable{
	
	@Id @GeneratedValue
	private long id;
	
	@NotEmpty (message = "{cuenta.nro}")
	@Column(name="nro_cuenta")
	private Long Nro;

	@NotEmpty (message = "{cuenta.fecha.creacion}")
	@Column(name="fecha_creacion")
	private LocalDate fechaCreacion;
	
	@NotEmpty (message = "{cuenta.saldo.inicial}")
	@Column(name="saldo_inicial")
	private float saldoInicial;
	
	@NotEmpty (message = "{cuenta.saldo.actual}")
	@Column(name="saldo_actual")
	private float saldoActual;
	
	@NotEmpty (message = "{cuenta.descubierto}")
	@Column(name="descubierto")
	private float descubierto;
	
	@Column(name="fecha_cierre")
	private LocalDate fechaCierre;
	
	@ManyToOne
	private Cliente titular;
	
	@ManyToMany
	private Set<Cliente> coTitulares = new HashSet<>();
	
	@OneToMany(mappedBy = "cuenta")
	private List<Movimiento> movimientos = new ArrayList<>();
	
	
	public Cuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Cuenta(LocalDate fechaCreacion, float saldoInicial, float saldoActual, float descubierto,
			LocalDate fechaCierre) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.saldoInicial = saldoInicial;
		this.saldoActual = saldoActual;
		this.descubierto = descubierto;
		this.fechaCierre = fechaCierre;
	}


	public Cliente getTitular() {
		return titular;
	}

	

	public Set<Cliente> getCoTitulares() {
		return coTitulares;
	}


	public void agregarcoTitulares(Cliente cliente) {
		
		coTitulares.add(cliente);
	}


	public Long getNro() {
		return Nro;
	}


	
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public float getSaldoInicial() {
		return saldoInicial;
	}


	public float getDescubierto() {
		return descubierto;
	}


	public void setDescubierto(float descubierto) {
		this.descubierto = descubierto;
	}


	public LocalDate getFechaCierre() {
		return fechaCierre;
	}


	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}


	public float getSaldoActual() {
		return saldoActual;
	}


	public void setSaldoActual(float saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	
	


	

	

	
	
	

}
