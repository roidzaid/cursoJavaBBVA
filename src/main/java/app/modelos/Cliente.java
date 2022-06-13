package app.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "clientes")
@Table(name = "CLIENTES")
@NoArgsConstructor
@Data
@NamedQuery(name = "buscarPorNombre", query = "SELECT c FROM clientes c WHERE c.nombre = ?1")
public class Cliente {
	
	@Id	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	private Direccion direccion;
	private int telefono;
	@Email
	private String email;
	
	@OneToMany(mappedBy = "titular")
	private List<Cuenta> cuenta_titular = new ArrayList<>();
	
	@ManyToMany(mappedBy = "coTitulares")
	private List<Cuenta> cuenta_coTitulares  =  new ArrayList<>();
	
	public Cliente(String nombre, String apellido, Direccion direccion, int telefono, @Email String email){
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	
	
	public void agregarCuentaTitular(Cuenta cuenta) {
		cuenta_titular.add(cuenta);
	}
	
	public void agregarCuentaCoTitular(Cuenta cuenta) {
		cuenta_coTitulares.add(cuenta);
	}

	


		

}
