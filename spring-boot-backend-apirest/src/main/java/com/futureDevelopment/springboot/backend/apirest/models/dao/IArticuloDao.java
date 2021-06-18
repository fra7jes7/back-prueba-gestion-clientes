package com.futureDevelopment.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.futureDevelopment.springboot.backend.apirest.models.entity.Articulo;

public interface IArticuloDao extends CrudRepository<Articulo, Long > {

}
