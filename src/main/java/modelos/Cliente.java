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
		
		private List<CuentaNacional> cuentasTitular = new ArrayList<>();

		
		private List<Cuenta> cuentasCoTitular = new ArrayList<>();
		
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

		
		public void AgregarCuentaTitular(CuentaNacional cuentaNacional) {
			
			this.cuentasTitular.add(cuentaNacional);
		}
		


		public List<CuentaNacional> getCuentasTitularNacionales() {
			return cuentasTitular;
		}

		

}
