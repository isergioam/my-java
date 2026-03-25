package com.paco.biblio.dto;

public class LibroEntradaDTO {

	private String titulo;
	private String isbn;
	private Integer anioPublicacion;
	private Boolean disponible;

	public LibroEntradaDTO() {
	}

	public LibroEntradaDTO(String titulo, String isbn, Integer anioPublicacion, Boolean disponible) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.anioPublicacion = anioPublicacion;
		this.disponible = disponible;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(Integer anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

}
