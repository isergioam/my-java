package com.paco.productojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paco.productojpa.dto.ProductoEntradaDTO;
import com.paco.productojpa.dto.ProductoSalidaDTO;
import com.paco.productojpa.model.Producto;
import com.paco.productojpa.repository.ProductoRepository;

/**
 * Capa de servicio para la lógica de negocio relacionada con productos.
 */
@Service
public class ProductoService {

	/**
	 * Dependencia hacia el repositorio. Se inyecta por constructor.
	 */
	private final ProductoRepository productoRepository;

	/**
	 * Constructor con inyección de dependencias.
	 */
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	/**
	 * Crea un producto nuevo a partir de un DTO de entrada.
	 */
	public ProductoSalidaDTO crearProducto(ProductoEntradaDTO dto) {

		// Convertimos el DTO en una entidad.
		Producto producto = new Producto(dto.getNombre(), dto.getPrecio(), dto.getStock());

		// Guardamos la entidad en la base de datos.
		Producto guardado = productoRepository.save(producto);

		// Convertimos la entidad guardada en DTO de salida.
		return convertirASalidaDTO(guardado);
	}

	/**
	 * Devuelve todos los productos.
	 */
	public List<ProductoSalidaDTO> listarProductos() {
		return productoRepository.findAll().stream().map(this::convertirASalidaDTO).toList();
	}

	/**
	 * Busca un producto por su id.
	 */
	public ProductoSalidaDTO buscarPorId(Long id) {
		Optional<Producto> productoOptional = productoRepository.findById(id);

		if (productoOptional.isEmpty()) {
			return null;
		}

		return convertirASalidaDTO(productoOptional.get());
	}

	/**
	 * Busca productos por nombre.
	 */
	public List<ProductoSalidaDTO> buscarPorNombre(String texto) {
		return productoRepository.findByNombreContainingIgnoreCase(texto).stream().map(this::convertirASalidaDTO)
				.toList();
	}

	/**
	 * Actualiza un producto existente.
	 */
	public ProductoSalidaDTO actualizarProducto(Long id, ProductoEntradaDTO dto) {
		Optional<Producto> productoOptional = productoRepository.findById(id);

		if (productoOptional.isEmpty()) {
			return null;
		}

		Producto producto = productoOptional.get();

		// Actualizamos los campos de la entidad existente.
		producto.setNombre(dto.getNombre());
		producto.setPrecio(dto.getPrecio());
		producto.setStock(dto.getStock());

		// Guardamos los cambios.
		Producto actualizado = productoRepository.save(producto);

		return convertirASalidaDTO(actualizado);
	}

	/**
	 * Borra un producto por id.
	 */
	public boolean borrarProducto(Long id) {

		// Comprobamos si existe antes de borrar.
		if (!productoRepository.existsById(id)) {
			return false;
		}

		productoRepository.deleteById(id);
		return true;
	}

	/**
	 * Método privado de apoyo para convertir entidad a DTO de salida.
	 */
	private ProductoSalidaDTO convertirASalidaDTO(Producto producto) {
		return new ProductoSalidaDTO(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock());
	}
}