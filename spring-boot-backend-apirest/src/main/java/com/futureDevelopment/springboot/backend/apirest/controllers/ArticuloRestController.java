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

import com.futureDevelopment.springboot.backend.apirest.models.entity.Articulo;
import com.futureDevelopment.springboot.backend.apirest.models.services.IArticuloService;

@CrossOrigin(origins = { "http://localhost:4200" }) // damos acceso para que pueda enviar y recibir datos
@RestController
@RequestMapping("/api")
public class ArticuloRestController {
	
	@Autowired
	private IArticuloService articuloService;
	
	
	@GetMapping("/articulos")
	public List<Articulo> index() {
		return articuloService.findAll();
	}
	
	@PostMapping("/articulos")
	@ResponseStatus(HttpStatus.CREATED)
	public Articulo create(@RequestBody Articulo articulo) {
		return articuloService.save(articulo);
	}
	
	@GetMapping("/articulo/{id}")
	public Articulo show(@PathVariable Long id) {
		return articuloService.findById(id);
	}
	
}
