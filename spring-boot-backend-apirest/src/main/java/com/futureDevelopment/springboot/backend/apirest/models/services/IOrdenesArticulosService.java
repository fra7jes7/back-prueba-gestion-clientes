package com.futureDevelopment.springboot.backend.apirest.models.services;

import java.util.List;

import com.futureDevelopment.springboot.backend.apirest.models.entity.OrdenesArticulos;

public interface IOrdenesArticulosService {
	
	public List<OrdenesArticulos> findAll();
	
	public OrdenesArticulos save(OrdenesArticulos ordenArt);

}
