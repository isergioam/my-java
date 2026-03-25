package com.paco.productojpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paco.productojpa.model.Producto;

/**
 * Repositorio para el acceso a datos de Producto.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	/**
	 * Busca productos cuyo nombre contenga el texto indicado, sin distinguir
	 * mayúsculas y minúsculas.
	 */
	List<Producto> findByNombreContainingIgnoreCase(String nombre);
}