package com.formacionbdi.sprintboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;
import com.formacionbdi.sprintboot.app.productos.models.service.IProductoService;

/**
 * 
 * @author yehan.portilla
 *
 */
@RestController
public class ProductoController {

	@Autowired
	private Environment env;

	@Value("${server.port}")
	private Integer port;

	@Autowired
	private IProductoService iProductoService;

	/**
	 * Method of listing products
	 * 
	 * @return iProductoService.findAll()
	 */
	@GetMapping("/listarProductos")
	public List<Producto> listar() {

		return iProductoService.findAll().stream().map(producto -> {
			producto.setPort(port);
			return producto;

		}).collect(Collectors.toList());
	}

	/**
	 * Method search product for id
	 * 
	 * @param id
	 * @return iProductoService.finById(id)
	 * @throws Exception
	 */
	@GetMapping("/buscarProducto/{id}")
	public Producto buscarPoridProducto(@PathVariable Long id) {
		Producto producto = iProductoService.finById(id);
		producto.setPort(port);
		/*
		 * try { Thread.sleep(2000L); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		return producto;
	}

	/**
	 * Method save product
	 * 
	 * @param producto
	 * @return
	 */
	@PostMapping("/guardarProductos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto guardarProducto(@Valid @RequestBody Producto producto) {

		Producto productoGuardado = iProductoService.saveProduct(producto);
		return productoGuardado;
	}

	/**
	 * Method for update product id
	 * 
	 * @param Producto
	 * @param id
	 * @return productoActualizado
	 */
	@PutMapping("/actulizaProducto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto actualizarProducto(@RequestBody Producto producto, @PathVariable Long id) {

		Producto productoDb = iProductoService.finById(id);
		productoDb.setNombre(producto.getNombre());
		productoDb.setPrecio(producto.getPrecio());

		Producto productoActualizado = iProductoService.saveProduct(productoDb);
		return productoActualizado;

	}

	/**
	 * Method delet for id product
	 * 
	 * @param id
	 */
	@DeleteMapping("/eliminaProducto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarProducto(@PathVariable Long id) {
		iProductoService.deleteById(id);

	}

}
