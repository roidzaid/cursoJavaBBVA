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

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CUENTAS")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public abstract class Cuenta{
	
	@Id @GeneratedValue
	private long id;
	
	@NonNull
	@NotEmpty (message = "{cuenta.nro}")
	@Column(name="nro_cuenta")
	private Long Nro;

	@NonNull
	@NotEmpty (message = "{cuenta.fecha.creacion}")
	@Column(name="fecha_creacion")
	private LocalDate fechaCreacion;
	
	@NonNull
	@NotEmpty (message = "{cuenta.saldo.inicial}")
	@Column(name="saldo_inicial")
	private float saldoInicial;
	
	@NonNull
	@NotEmpty (message = "{cuenta.saldo.actual}")
	@Column(name="saldo_actual")
	private float saldoActual;
	
	@NonNull
	@NotEmpty (message = "{cuenta.descubierto}")
	@Column(name="descubierto")
	private float descubierto;
	
	@Column(name="fecha_cierre")
	private LocalDate fechaCierre;
	
	@NonNull
	@ManyToOne
	private Cliente titular;
	
	@ManyToMany
	private Set<Cliente> coTitulares = new HashSet<>();
	
	@OneToMany(mappedBy = "cuenta")
	private List<Movimiento> movimientos = new ArrayList<>();
	
	@OneToMany(mappedBy = "cuenta")
	private List<Transferencia> transferencias = new ArrayList<>();
	
	
	
	
	
	
	public void agregarMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
	}

}
