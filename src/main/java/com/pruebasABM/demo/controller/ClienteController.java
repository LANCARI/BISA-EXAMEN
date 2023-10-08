package com.pruebasABM.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebasABM.demo.Global;
import com.pruebasABM.demo.model.Cliente;
import com.pruebasABM.demo.model.Direccion;
import com.pruebasABM.demo.model.Persona;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	
	Global global = new Global();
	
	@GetMapping("")
	public List<Cliente> getClients(){
		return this.global.getClientes();
	}
	
	@GetMapping("/{id}")
	public Cliente getClient(@PathVariable("id") int id){
		return this.global.getCliente(id);
	}

	@GetMapping("edad/{id}")
	public Cliente getClientEdad(@PathVariable("id") int id){
		return this.global.getClienteEdad(id);
	}
	
	@PostMapping("")
	public ResponseEntity addClient(@RequestBody Cliente client){
		this.global.setCliente(client);
		return new ResponseEntity<>(client, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity removeClient(@PathVariable("id") int id){
		if (this.removeCliente(id)) {
			return new ResponseEntity("Se Elimino al cliente", HttpStatus.CREATED);
		} else {
			return new ResponseEntity("El cliente no existe", HttpStatus.ACCEPTED);
		}	
	}

	public boolean removeCliente(int id) {
		boolean resp=false;
		resp=	this.global.removeCliente(id);
		return resp;
	}

}
