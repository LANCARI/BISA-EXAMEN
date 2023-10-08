package com.pruebasABM.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pruebasABM.demo.model.Cliente;
import com.pruebasABM.demo.model.Direccion;
import com.pruebasABM.demo.model.Persona;
import com.pruebasABM.demo.model.Referencia;
import java.time.LocalDate;
import java.time.Period;


public class Global {

	
	static List<Cliente> clientes = new ArrayList<Cliente>();
	static List<Direccion> direcciones = new ArrayList<Direccion>();
	static List<Persona> personas = new ArrayList<Persona>();

	static List<Referencia> referencias = new ArrayList<Referencia>();
	
	
	public static List<Cliente> getClientes() {
		return clientes;
	}
	public static void setClientes(List<Cliente> clientes) {
		Global.clientes = clientes;
	}
	public static List<Direccion> getDirecciones() {
		return direcciones;
	}
	public static void setDirecciones(List<Direccion> direcciones) {
		Global.direcciones = direcciones;
	}
	public static List<Persona> getPersonas() {
		return personas;
	}
	public static void setPersonas(List<Persona> personas) {
		Global.personas = personas;
	}

	public static List<Referencia> getReferencias() {
		return referencias;
	}
	public static void setReferencias(List<Referencia> referencias) {
		Global.referencias = referencias;
	}
	
	
	

	
	public Global() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public Cliente getCliente(int id) {
		Cliente resp = null;
		for(Cliente cliente :this.clientes ) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		return resp;
	}
	
	public Cliente getClienteEdad(int id) {
		Cliente resp = null;
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaNacimiento = null;

		for (Cliente cliente : this.clientes) {
			if (cliente.getId() == id) {
				System.out.println("año1:");
				Date fechaN = cliente.getPersona().getFechaNacimiento();
				System.out.println(fechaN.getYear());
				fechaNacimiento = LocalDate.of(cliente.getPersona().getFechaNacimiento().getYear(), cliente.getPersona().getFechaNacimiento().getMonth(), cliente.getPersona().getFechaNacimiento().getDay());
				resp = cliente;
				break;
			}
		}
		System.out.println("fecha:");
		System.out.println( fechaNacimiento.toString());
		
		if (fechaNacimiento != null) {
			Period periodo = Period.between(fechaNacimiento, fechaActual);
			int edad = periodo.getYears();

			System.out.println("La edad es: " + edad + " años.");
		} else {
			System.out.println("Cliente no encontrado.");
		}

		return resp;
	}
	
	
	public boolean removeCliente(int id) {
		boolean resp=false;
		Cliente cliente = this.getCliente(id);
		resp=	this.clientes.remove(cliente);
		return resp;
	}
	
	
	public void setPersona(Persona persona) {
		this.personas.add(persona);
	}

	public void setReferencia(Referencia referencia) {
		this.referencias.add(referencia);
	}

	public Referencia getReferencia(int id) {
		Referencia resp = null;
		for(Referencia referencia :this.referencias ) {
			if (referencia.getId() == id) {
				return referencia;
			}
		}
		return resp;
	}

	public Referencia getContarClientesReferencia(int id) {
		Referencia resp = null;
		int contador = 0;

		for (Referencia referencia : this.referencias) {
			if (referencia.getCliente().getId() == id) {
				contador++;
			}
		}

		if (contador >= 1) {
			for (Referencia referencia : this.referencias) {
				if (referencia.getCliente().getId() == id) {
					referencia.getCliente().setEstado("Activo");
				}
			}
		}

		System.out.println("Cantidad " + contador);

		return resp;
	}




}
