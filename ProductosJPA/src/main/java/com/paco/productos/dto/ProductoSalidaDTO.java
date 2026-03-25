package com.paco.productos.dto;

/**
 * DTO que representa los datos que devolvemos al cliente.
 */
public class ProductoSalidaDTO {

	private Long id;
	private String nombre;
	private Double precio;
	private Integer stock;

	public ProductoSalidaDTO() {
	}

	public ProductoSalidaDTO(Long id, String nombre, Double precio, Integer stock) {
		this.id = id;
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

	public Double getPrecio() {
		return precio;
	}

	public Integer getStock() {
		return stock;
	}
}