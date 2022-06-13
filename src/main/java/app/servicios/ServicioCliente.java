package app.servicios;

import java.util.Collection;

import app.modelos.Cliente;
import app.modelos.Direccion;

public interface ServicioCliente {
	
	public void crearCliente(Cliente cliente);
	public Collection<Cliente> listarClientes();
	public Cliente buscarClientePorNombre(String Nombre);
	public Cliente buscarClientePorId(Long idCliente);
	public void actualizarDireccion(Long idCliente, Direccion direccion);

}
