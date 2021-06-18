package com.futureDevelopment.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.futureDevelopment.springboot.backend.apirest.models.entity.Ordenes;

public interface IOrdenes extends CrudRepository <Ordenes, Long>{

}
