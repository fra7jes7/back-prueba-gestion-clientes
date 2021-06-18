package com.futureDevelopment.springboot.backend.apirest.models.services;

import java.util.List;

import com.futureDevelopment.springboot.backend.apirest.models.entity.Articulo;

public interface IArticuloService {
	
	public List<Articulo> findAll();	
	
	public Articulo findById(Long codigo);

	
	public Articulo save(Articulo articulo);
}
