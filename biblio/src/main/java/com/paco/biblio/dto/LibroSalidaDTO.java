package com.paco.biblio.dto;

public class LibroSalidaDTO {
	private Long id;
	private String titulo;
	private String isbn;
	private Integer anioPublicacion;
	private Boolean disponible;
	private Long autorId;
	private String autorNombre;

	public LibroSalidaDTO() {
	}

	public LibroSalidaDTO(Long id, String titulo, String isbn, Integer anioPublicacion, Boolean disponible,
			Long autorId, String autorNombre) {
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.anioPublicacion = anioPublicacion;
		this.disponible = disponible;
		this.autorId = autorId;
		this.autorNombre = autorNombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getAutorId() {
		return autorId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}

	public String getAutorNombre() {
		return autorNombre;
	}

	public void setAutorNombre(String autorNombre) {
		this.autorNombre = autorNombre;
	}

}
