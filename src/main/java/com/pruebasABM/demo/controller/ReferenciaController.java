package com.pruebasABM.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pruebasABM.demo.model.Cliente;
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
import com.pruebasABM.demo.model.Referencia;
import com.pruebasABM.demo.model.Direccion;
import com.pruebasABM.demo.model.Persona;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/referencia")
public class ReferenciaController {

    Global global = new Global();

    @GetMapping("")
    public List<Referencia> getReferent(){
        return this.global.getReferencias();
    }

    @GetMapping("/{id}")
    public Referencia getReferencia(@PathVariable("id") int id){
        return this.global.getReferencia(id);
    }

    @GetMapping("contar/{id}")
    public Referencia getRef(@PathVariable("id") int id){
        return this.global.getContarClientesReferencia(id);
    }

}
