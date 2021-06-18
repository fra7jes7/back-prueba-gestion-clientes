package com.futureDevelopment.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.futureDevelopment.springboot.backend.apirest.models.entity.Ordenes;
import com.futureDevelopment.springboot.backend.apirest.models.services.IOrdenesService;

@CrossOrigin(origins = { "http://localhost:4200" }) // damos acceso para que pueda enviar y recibir datos
@RestController
@RequestMapping("/api")
public class OrdenesRestControler {
	
	@Autowired
	private IOrdenesService ordenesService;
	
	
	@GetMapping("/ordeness")
	public List<Ordenes> index(){
		return ordenesService.findAll();
	}
	
	@PostMapping("/ordenes")
	@ResponseStatus(HttpStatus.CREATED)
	public Ordenes create(@RequestBody Ordenes orden) {
		return ordenesService.save(orden);
	}
	
	@GetMapping("/orden/{id}")
	public Ordenes show(@PathVariable Long id){
		return  ordenesService.findById(id);
	}

}
