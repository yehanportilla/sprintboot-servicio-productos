package com.formacionbdi.sprintboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.sprintboot.app.productos.models.dao.ProductoDao;
import com.formacionbdi.sprintboot.app.commons.models.entity.Producto;

/**
 * 
 * @author yehan.portilla
 *
 */
@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoDao productoDao;

	/**
	 * Method in charge of listing all products
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {

		return (List<Producto>) productoDao.findAll();
	}

	/**
	 * Method of searching for product by id
	 */
	@Override
	@Transactional(readOnly = true)
	public Producto finById(Long id) {

		return productoDao.findById(id).orElse(null);
	}

	/**
	 * Method save product
	 */
	@Override
	@Transactional
	public Producto saveProduct(Producto producto) {

		return productoDao.save(producto);
	}

	/**
	 * Method delet for id product
	 */
	@Override
	@Transactional // de escritura
	public void deleteById(Long id) {
		productoDao.deleteById(id);
	}

}
