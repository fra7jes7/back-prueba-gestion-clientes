package com.futureDevelopment.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.futureDevelopment.springboot.backend.apirest.models.entity.OrdenesArticulos;
import com.futureDevelopment.springboot.backend.apirest.models.services.IOrdenesArticulosService;

@CrossOrigin(origins = { "http://localhost:4200" }) // damos acceso para que pueda enviar y recibir datos
@RestController
@RequestMapping("/api")
public class OrdenesArticulosRestController {
	
	@Autowired
	private IOrdenesArticulosService oAservice;

	
	@PostMapping("/ordenesarticulos")
	@ResponseStatus(HttpStatus.CREATED)
	public OrdenesArticulos create(@RequestBody OrdenesArticulos oa) {
		return oAservice.save(oa);
	}
	
	@GetMapping("/ordenesArticulos")
	public List<OrdenesArticulos> index(){
		return oAservice.findAll();
	}

} 
