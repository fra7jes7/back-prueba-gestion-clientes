package com.futureDevelopment.springboot.backend.apirest.models.services;

import java.util.List;

import com.futureDevelopment.springboot.backend.apirest.models.entity.Ordenes;

public interface IOrdenesService {
	
	public List<Ordenes> findAll();
	
	public Ordenes save(Ordenes orden);
	
	public Ordenes findById(Long id);
	
	public void delete(Long id);

}
