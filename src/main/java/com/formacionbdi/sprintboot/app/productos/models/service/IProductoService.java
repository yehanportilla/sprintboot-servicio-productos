package com.formacionbdi.sprintboot.app.productos.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;



/**
 * 
 * @author yehan.portilla
 *
 */
public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto finById(Long id);
	
	public Producto saveProduct(Producto producto);
	
	public void deleteById(Long id);
	
}
