package modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CLIENTES")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
	
	@Id	@GeneratedValue
	private Long id;
	
	@NonNull
	@NotEmpty (message = "{cliente.nombre}")
	private String nombre;
	
	@NonNull
	@NotEmpty (message = "{cliente.apellido}")
	private String apellido;
	
	@NonNull
	@NotEmpty (message = "{cliente.direccion}")
	private Direccion direccion;
	
	private int telefono;
	
	@NonNull
	@Email
	private String email;
	
	@OneToMany(mappedBy = "titular")
	private List<Cuenta> cuenta_titular = new ArrayList<>();
	
	@ManyToMany(mappedBy = "coTitulares")
	private Set<Cuenta> cuenta_coTitulares  = new HashSet<>();
	
	
	
	
	public void agregarCuentaTitular(Cuenta cuenta) {
		cuenta_titular.add(cuenta);
	}
	
	public void agregarCuentaCoTitular(Cuenta cuenta) {
		cuenta_coTitulares.add(cuenta);
	}

		

}
