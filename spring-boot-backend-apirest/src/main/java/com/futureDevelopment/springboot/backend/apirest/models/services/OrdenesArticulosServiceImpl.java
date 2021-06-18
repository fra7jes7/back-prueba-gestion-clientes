package com.futureDevelopment.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futureDevelopment.springboot.backend.apirest.models.dao.IOrdenesArticulosDao;
import com.futureDevelopment.springboot.backend.apirest.models.entity.OrdenesArticulos;

@Service
public class OrdenesArticulosServiceImpl implements IOrdenesArticulosService{

	@Autowired
	private IOrdenesArticulosDao ordenesArticulos;
	
	@Override
	public OrdenesArticulos save(OrdenesArticulos ordenArt) {
		// TODO Auto-generated method stub
		return ordenesArticulos.save(ordenArt);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrdenesArticulos> findAll() {
		// TODO Auto-generated method stub
		return (List<OrdenesArticulos>) ordenesArticulos.findAll();
	}

}
