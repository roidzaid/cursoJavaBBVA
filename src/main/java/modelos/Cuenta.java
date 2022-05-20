package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public class Cuenta {
	
	@Id @GeneratedValue
	private long id;
	
	@NotEmpty (message = "{cuenta.nro}")
	private Long Nro;

	@NotEmpty (message = "{cuenta.fecha.creacion}")
	private LocalDate fechaCreacion;
	
	@NotEmpty (message = "{cuenta.saldo.inicial}")
	private float saldoInicial;
	
	@NotEmpty (message = "{cuenta.saldo.actual}")
	private float saldoActual;
	
	@NotEmpty (message = "{cuenta.descubierto}")
	private float descubierto;
	
	private LocalDate fechaCierre;
	
	private Cliente titular;
	
	@ManyToMany
	private List<Cliente> coTitulares = new ArrayList<>();
	
	@OneToMany(mappedBy = "cuenta-movimientos")
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

	public List<Cliente> getcoTitulares() {
		return coTitulares;
	}

	public void agregarcoTitulares(Cliente cliente) {
		
		coTitulares.add(cliente);
	}


	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void agregarMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
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
