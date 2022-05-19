package modelos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

public class Movimiento {

	private Date fechayHora;
	private float monto;
	private String descripcion;
	
	
	public Movimiento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movimiento(Date fechayHora, float monto, String descripcion) {
		super();
		this.fechayHora = fechayHora;
		this.monto = monto;
		this.descripcion = descripcion;
	}


	public Date getFechayHora() {
		return fechayHora;
	}


	public void setFechayHora(Date fechayHora) {
		this.fechayHora = fechayHora;
	}


	public float getMonto() {
		return monto;
	}


	public void setMonto(float monto) {
		this.monto = monto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
