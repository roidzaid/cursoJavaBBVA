package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import exceptions.ExcepcionFechaDeCreacionInvalida;
import exceptions.ExcepcionNroCuentaInvalido;
import exceptions.ExcepcionSaldoInicialInvalido;
import lombok.Getter;

@Entity
@Table(name = "CUENTAS")
@Getter
public abstract class Cuenta{
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="nro_cuenta")
	private Long nro;

	@Column(name="fecha_creacion")
	private LocalDate fechaCreacion;
	
	@Column(name="saldo_inicial")
	private float saldoInicial;
	
	@Column(name="saldo_actual")
	private float saldoActual;
	
	@Column(name="descubierto")
	private float descubierto;
	
	@Column(name="fecha_cierre")
	private LocalDate fechaCierre;
	
	@ManyToOne
	private Cliente titular;
	
	@ManyToMany
	private List<Cliente> coTitulares = new ArrayList<>();
	
	@OneToMany(mappedBy = "cuenta")
	private List<Movimiento> movimientos = new ArrayList<>();
	
	@OneToMany(mappedBy = "cuenta")
	private List<TransferenciaRecibida> transferenciasRecibidas = new ArrayList<>();
	
	@OneToMany(mappedBy = "cuenta")
	private List<TransferenciaRealizada> transferenciasRealizadas = new ArrayList<>();
	
	
	public Cuenta(Long nro, LocalDate fechaCreacion, float saldoInicial, float saldoActual, float descubierto, Cliente titular) 
			throws ExcepcionNroCuentaInvalido, ExcepcionFechaDeCreacionInvalida, ExcepcionSaldoInicialInvalido {

		if(nro == null) {
			throw new ExcepcionNroCuentaInvalido();
		}
		
		if(fechaCreacion==null || fechaCreacion.isAfter(LocalDate.now())) {
			throw new ExcepcionFechaDeCreacionInvalida();			
		}
		
		if(saldoInicial <= 0) {
			throw new ExcepcionSaldoInicialInvalido();
		}
		
		
		this.nro = nro;
		this.fechaCreacion = fechaCreacion;
		this.saldoInicial = saldoInicial;
		this.saldoActual = saldoActual;
		this.descubierto = descubierto;
		this.titular = titular;
	}

	public void agregarMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
	}
	
	public void agregarCotitulares(Cliente coTitular) {
		coTitulares.add(coTitular);
	}
	
	

	public void setSaldoActual(float saldoActual) {
		this.saldoActual = saldoActual;
	}

	public void setDescubierto(float descubierto) {
		this.descubierto = descubierto;
	}

	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	
	


}
