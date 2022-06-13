package app.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.modelos.Cliente;
import app.modelos.Direccion;
import app.servicios.ServicioCliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired 
	private ServicioCliente servicioCliente; 
	
	
	/*
	 * @GetMapping(path = "/saludo") public ResponseEntity<?> saludar() { return new
	 * ResponseEntity<>("app funciona", HttpStatus.OK); }
	 * 
	 */
	 
	  
	  
	  @PostMapping(path = "/alta") 
	  public ResponseEntity<?> crearCliente(@RequestBody Cliente c) {
	  
		  System.out.println("se da alta un cliente"); 
		  try {
	  
			  servicioCliente.crearCliente(c);
	  
			  return new ResponseEntity<>(c, HttpStatus.CREATED); 
	      } catch(IllegalArgumentException e) { 
	    	  return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
	      }
	  }
	  
	  
	  @GetMapping(path = "/todos") 
	  public ResponseEntity<?> listarTodos() {
	  
		  System.out.println("se listan todos los clientes");
	  
		  try {
	  
			  Collection<Cliente> clientes = servicioCliente.listarClientes();
	  
			  return new ResponseEntity<>(clientes, HttpStatus.OK); 
		  } catch (IllegalArgumentException e) { 
			  return new ResponseEntity<>(HttpStatus.FORBIDDEN); } 
	  }
	  
	  
	  @GetMapping(path = "/id/{id}") 
	  public ResponseEntity<?> buscarPorId(@PathVariable long id) {
	  
		  System.out.println("se busca cliente por Id");
	  
		  try {
	  
			  Cliente cliente = servicioCliente.buscarClientePorId(id);
	  
			  return new ResponseEntity<>(cliente, HttpStatus.OK); 
		  } catch (IllegalArgumentException e) { 
			  return new ResponseEntity<>(HttpStatus.FORBIDDEN); } 
	  }
	  
	  @GetMapping(path = "/nombre/{nombre}") 
	  public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
	  
		  System.out.println("se busca cliente por nombre");
	  
		  try {
	  
			  Cliente cliente = servicioCliente.buscarClientePorNombre(nombre);
	  
			  return new ResponseEntity<>(cliente, HttpStatus.OK); 
		  } catch (IllegalArgumentException e) { 
			  return new ResponseEntity<>(HttpStatus.FORBIDDEN); } 
	  }
	  
	  @PutMapping(path = "/direccion/{id}") 
	  public ResponseEntity<?> buscarPorNombre(@PathVariable long id, @RequestBody Direccion direccion) {
	  
		  System.out.println("se modifica direccion del cliente");
	  
		  try {
	  
			  servicioCliente.actualizarDireccion(id, direccion);
	  
			  return new ResponseEntity<>("direccion actualizada", HttpStatus.OK); 
		  } catch (IllegalArgumentException e) { 
			  return new ResponseEntity<>(HttpStatus.FORBIDDEN); } 
	  }
	 
}
