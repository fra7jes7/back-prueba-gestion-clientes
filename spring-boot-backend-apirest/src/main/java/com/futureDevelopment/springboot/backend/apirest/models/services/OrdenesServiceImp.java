package com.futureDevelopment.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futureDevelopment.springboot.backend.apirest.models.dao.IOrdenes;
import com.futureDevelopment.springboot.backend.apirest.models.entity.Ordenes;

@Service
public class OrdenesServiceImp implements IOrdenesService {

	@Autowired
	private IOrdenes ordenesDao;
	
	@Override
	public Ordenes save(Ordenes orden) {
		// TODO Auto-generated method stub
		return ordenesDao.save(orden);
	}

	@Override
	@Transactional(readOnly = true)
	public Ordenes findById(Long id) {
		// TODO Auto-generated method stub
		return ordenesDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ordenes> findAll() {
		// TODO Auto-generated method stub
		return (List<Ordenes>) ordenesDao.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ordenesDao.deleteById(id);
		
	}

}
