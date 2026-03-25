package com.paco.productos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA que representa la tabla productos.
 */
@Entity
@Table(name = "productos")
public class Producto {

	/**
	 * Identificador único del producto. Será clave primaria en la base de datos.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del producto.
	 */
	private String nombre;

	/**
	 * Precio del producto.
	 */
	private Double precio;

	/**
	 * Cantidad disponible en almacén.
	 */
	private Integer stock;

	/**
	 * Constructor vacío obligatorio para JPA.
	 */
	public Producto() {
	}

	/**
	 * Constructor para crear productos cómodamente.
	 */
	public Producto(String nombre, Double precio, Integer stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}