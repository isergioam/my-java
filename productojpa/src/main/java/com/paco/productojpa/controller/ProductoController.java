package com.paco.productojpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.paco.productojpa.dto.ProductoEntradaDTO;
import com.paco.productojpa.dto.ProductoSalidaDTO;
import com.paco.productojpa.service.ProductoService;

@RestController
public class ProductoController {

	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	// Crear un producto
	@PostMapping("/productos")
	public ProductoSalidaDTO crearProducto(@RequestBody ProductoEntradaDTO dto) {
		return productoService.crearProducto(dto);
	}

	// Obtener todos los productos
	@GetMapping("/productos")
	public List<ProductoSalidaDTO> listarProductos() {
		return productoService.listarProductos();
	}

	// Obtener un producto por su id
	@GetMapping("/productos/{id}")
	public ProductoSalidaDTO buscarPorId(@PathVariable Long id) {
		return productoService.buscarPorId(id);
	}

	// Buscar productos por nombre
	@GetMapping("/productos/buscar")
	public List<ProductoSalidaDTO> buscarPorNombre(@RequestParam String nombre) {
		return productoService.buscarPorNombre(nombre);
	}

	// Actualizar un producto
	@PutMapping("/productos/{id}")
	public ProductoSalidaDTO actualizarProducto(@PathVariable Long id, @RequestBody ProductoEntradaDTO dto) {
		return productoService.actualizarProducto(id, dto);
	}

	// Borrar un producto
	@DeleteMapping("/productos/{id}")
	public void borrarProducto(@PathVariable Long id) {
		productoService.borrarProducto(id);
	}
}