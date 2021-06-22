package com.futureDevelopment.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.futureDevelopment.springboot.backend.apirest.models.entity.Articulo;
import com.futureDevelopment.springboot.backend.apirest.models.entity.OrdenesArticulos;
import com.futureDevelopment.springboot.backend.apirest.models.services.ArticuloServiceImpl;
import com.futureDevelopment.springboot.backend.apirest.models.services.IOrdenesArticulosService;
import com.futureDevelopment.springboot.backend.apirest.models.services.OrdenesServiceImp;

@CrossOrigin(origins = { "http://localhost:4200" }) // damos acceso para que pueda enviar y recibir datos
@RestController
@RequestMapping("/api")
public class OrdenesArticulosRestController {
	
	@Autowired
	private IOrdenesArticulosService oAservice;
	@Autowired
	ArticuloServiceImpl objArt= new ArticuloServiceImpl();
	@Autowired
	OrdenesServiceImp objOrdenes= new OrdenesServiceImp();


	
	@PostMapping("/ordenesarticulos")
	public ResponseEntity<?> create(@Valid @RequestBody OrdenesArticulos oa) 
	{
		
		Map<String, Object> response = new HashMap<>();
		
		Articulo objArtEnt= new Articulo();
		objArtEnt = objArt.findById((long) oa.getIdArticulo());
		System.out.printf("objArtEnt.getStock()"+objArtEnt.getStock());
		Integer stockActual= objArtEnt.getStock();
		
		if(oa.getCantidad() <= objArtEnt.getStock()) {
			objArtEnt.setStock(objArtEnt.getStock() -oa.getCantidad());
			objArt.save(objArtEnt);
			
			oAservice.save(oa);
			response.put("mensaje", "La orden se ha ingresado con exito");
			response.put("oa", oa);
			return new ResponseEntity<Map<String, Object>>
			(response, HttpStatus.CREATED);
		}else {
			objOrdenes.delete((long)oa.getIdOrdenes());
			response.put("mensaje", "error en el ingreso "
					+ "no hay suficiente stock, el stock es:"+ stockActual);
			response.put("oa", "error");
			
			return new ResponseEntity<Map<String, Object>>
			(response, HttpStatus.CREATED);

		}		
	}
	
	@GetMapping("/ordenesArticulos")
	public List<OrdenesArticulos> index(){
		return oAservice.findAll();
	}

} 
