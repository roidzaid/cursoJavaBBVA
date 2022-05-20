package modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "CLIENTES")
public class Cliente {
	
	@Id	@GeneratedValue
	private Long id;
	
	@NotEmpty (message = "{cliente.nombre}")
	private String nombre;
	
	@NotEmpty (message = "{cliente.apellido}")
	private String apellido;
	
	@NotEmpty (message = "{cliente.direccion}")
	private Direccion direccion;
	
	private int telefono;
	
	@Email
	private String email;
	
	@OneToMany(mappedBy = "titular")
	private List<Cuenta> cuenta_titular = new ArrayList<>();
	
	@ManyToMany(mappedBy = "coTitulares")
	private Set<Cuenta> cuenta_coTitulares  = new HashSet<>();
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cliente(String nombre, String apellido, Direccion direccion, int telefono, String email) {
		super();
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

	public List<Cuenta> getCuentasTitulares() {
		return cuenta_titular;
	}

	public Set<Cuenta> getCuentasCoTitulares() {
		return cuenta_coTitulares;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


		

		

}
