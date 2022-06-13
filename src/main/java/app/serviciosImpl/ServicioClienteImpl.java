package app.serviciosImpl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.daos.DAO;
import app.modelos.Cliente;
import app.modelos.Direccion;
import app.servicios.ServicioCliente;

@Service
public class ServicioClienteImpl implements ServicioCliente{

	@Autowired
	private DAO<Cliente> clienteDAO;
	
	@Override
	public void crearCliente(Cliente cliente) {
		
		 clienteDAO.save(cliente);
		
	}

	@Override
	public Collection<Cliente> listarClientes() {
		
		Collection<Cliente> clientes = clienteDAO.findAll();
		
		if(clientes!=null) {
			return clientes;
		}else {
			return null;
		}
		
		
	}

	@Override
	public Cliente buscarClientePorNombre(String Nombre) {
		
		Optional<Cliente> c = clienteDAO.findByNombre(Nombre);
		
		if(c!=null) {

			Cliente cliente = c.get();
			return cliente;
		}else {
		
			return null;
		}
		
	}

	@Override
	public Cliente buscarClientePorId(Long idCliente) {
		
		Optional<Cliente> c = clienteDAO.findById(idCliente);
		
		if(c!=null) {

			Cliente cliente = c.get();
			return cliente;
		}else {
		
			return null;
		}
	}

	@Override
	public void actualizarDireccion(Long idCliente, Direccion direccion){

		Optional<Cliente> c = clienteDAO.findById(idCliente);
		
		if(c!=null) {

			Cliente cliente = c.get();
			cliente.setDireccion(direccion);
			
			clienteDAO.update(cliente);
			
		}

		
	}

}
