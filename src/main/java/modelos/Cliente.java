package modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class Cliente {
	
		private String nombre;
		private String apellido;
		private Direccion direccion;
		private int telefono;
		private String email;
		
		private List<Cuenta> cuentasTitulares = new ArrayList<>();
		
		private List<Cuenta> cuentasCoTitulares = new ArrayList<>();
		
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
			cuentasTitulares.add(cuenta);
		}
		
		public void agregarCuentaCoTitular(Cuenta cuenta) {
			cuentasCoTitulares.add(cuenta);
		}
		
		
		

		public List<Cuenta> getCuentasTitulares() {
			return cuentasTitulares;
		}


		public List<Cuenta> getCuentasCoTitulares() {
			return cuentasCoTitulares;
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
