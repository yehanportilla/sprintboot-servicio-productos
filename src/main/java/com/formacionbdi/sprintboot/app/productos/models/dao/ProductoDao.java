package com.formacionbdi.sprintboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;



public interface ProductoDao extends CrudRepository<Producto, Long>{
	

}
