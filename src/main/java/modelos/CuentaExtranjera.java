package modelos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

public class CuentaExtranjera extends Cuenta{
	
	private String monedaAsociada;

	public CuentaExtranjera() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CuentaExtranjera(String monedaAsociada) {
		super();
		this.monedaAsociada = monedaAsociada;
	}



	public String getMonedaAsociada() {
		return monedaAsociada;
	}

	public void setMonedaAsociada(String monedaAsociada) {
		this.monedaAsociada = monedaAsociada;
	}


}
