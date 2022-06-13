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

import app.exceptions.ExceptionClienteYaEsCoTitularDeLaCuenta2;
import app.exceptions.ExceptionClienteYaEsTitularDeLaCuenta;
import app.exceptions.ExceptionCuentaCerrada;
import app.exceptions.ExceptionCuentaNoExiste;
import app.exceptions.ExceptionSaldoInsuficiente;
import app.modelos.Cuenta;
import app.modelos.CuentaModel;
import app.modelos.Movimiento;
import app.servicios.ServicioCuentas;

@RestController
@RequestMapping("/cuentas")
public class CuentasController {
	
	@Autowired
	private ServicioCuentas servicioCuentas;
	
	
	 @PostMapping(path = "/altaExtranjera") 
	  public ResponseEntity<?> crearCuentaExtranjera(@RequestBody CuentaModel c) {
	  
		  System.out.println("se da alta una cuenta Extranjera"); 
		  try {
	  
			  servicioCuentas.crearCuentaExtranjera(c);
	  
			  return new ResponseEntity<>(c, HttpStatus.CREATED); 
	      } catch(IllegalArgumentException e) { 
	    	  return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
	      }
	  }
	 
	 @PostMapping(path = "/altaNacional") 
	  public ResponseEntity<?> crearCuenta(@RequestBody CuentaModel c) {
	  
		  System.out.println("se da alta una cuenta nacional"); 
		  try {
	  
			  servicioCuentas.crearCuentaNacional(c);
	  
			  return new ResponseEntity<>(c, HttpStatus.CREATED); 
	      } catch(IllegalArgumentException e) { 
	    	  return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
	      }
	  }

	 
	 @GetMapping(path = "/listar") 
	  public ResponseEntity<?> listarCuentas() {
	  
		  System.out.println("se listan todas las cuentas");
	  
		  try {
	  
			  Collection<Cuenta> cuentas = servicioCuentas.listarCuentas();
	  
			  return new ResponseEntity<>(cuentas, HttpStatus.OK); 
		  } catch (IllegalArgumentException e) { 
			  return new ResponseEntity<>(HttpStatus.FORBIDDEN); } 
	  }
	 
	 @PutMapping(path = "/addCotitular/{idCliente}/{idCuenta}") 
	  public ResponseEntity<?> agregarCoTitular(@PathVariable long idCliente, @PathVariable long idCuenta) {
	  
		  System.out.println("Se agrega cotitular a la cuenta");
	  
		  try {
	  
			  servicioCuentas.agregarCoTitular(idCliente, idCuenta);
	  
			  return new ResponseEntity<>("Se agrega cotitular", HttpStatus.OK); 
		  } catch (IllegalArgumentException e) { 
			  return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
		  } 
		  catch (ExceptionClienteYaEsTitularDeLaCuenta e) {
			  return new ResponseEntity<>("El cliente ya es titular de la cuenta", HttpStatus.FORBIDDEN); 
		  } catch (ExceptionClienteYaEsCoTitularDeLaCuenta2 e) {
			  return new ResponseEntity<>("El cliente ya es Co-titular de la cuenta", HttpStatus.FORBIDDEN);
		  }
		 
	  }
	 

	 @GetMapping(path = "/movimientos/{idCuenta}") 
	  public ResponseEntity<?> listarMovimientos(@PathVariable long idCuenta) {
	  
		  System.out.println("se listan lso movimiemtos de una cuenta");
	  
		  try {
	  
			  Collection<Movimiento> movimientos = servicioCuentas.listarMovimientos(idCuenta);
	  
			  return new ResponseEntity<>(movimientos, HttpStatus.OK); 
		  } catch (IllegalArgumentException e) { 
			  return new ResponseEntity<>(HttpStatus.FORBIDDEN); } 
	  }
	 

	 @PostMapping(path = "/transferencia/{idCuentaOrigen}/{idCuentaDestino}/{monto}") 
	  public ResponseEntity<?> transferencia(@PathVariable long idCuentaOrigen, @PathVariable long idCuentaDestino, @PathVariable double monto) {
	  
		  System.out.println("se realiza una tranferencia"); 
		  try {
	  
			  servicioCuentas.transferir(idCuentaOrigen, idCuentaDestino, monto);
	  
			  return new ResponseEntity<>("Se realizo la tranferencia", HttpStatus.CREATED); 
	      } catch(IllegalArgumentException e) { 
	    	  return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
	      } catch (ExceptionCuentaCerrada e) {
	    	  return new ResponseEntity<>("Cuenta cerrada", HttpStatus.FORBIDDEN);
		} catch (ExceptionSaldoInsuficiente e) {
			return new ResponseEntity<>("Saldo insuficiente", HttpStatus.FORBIDDEN);
		} catch (ExceptionCuentaNoExiste e) {
			return new ResponseEntity<>("No existe la cuenta", HttpStatus.FORBIDDEN);
		}
	  }
}
