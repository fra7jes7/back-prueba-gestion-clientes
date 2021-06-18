package com.futureDevelopment.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futureDevelopment.springboot.backend.apirest.models.dao.IArticuloDao;
import com.futureDevelopment.springboot.backend.apirest.models.entity.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService{

	@Autowired
	private IArticuloDao articuloDao;
	
	
	@Override
	@Transactional(readOnly = true)  // SE PUEDE OMITIR -- PERO NO PARA LOS METODOS NUEVOS
	public List<Articulo> findAll() {
		 
		return (List<Articulo>) articuloDao.findAll();
	}


	@Override
	@Transactional
	public Articulo save(Articulo articulo) {

		return articuloDao.save(articulo);
	}


	@Override
	@Transactional(readOnly = true)
	public Articulo findById(Long codigo) {
		// TODO Auto-generated method stub
		return articuloDao.findById(codigo).orElse(null);
	}

	
	
}
