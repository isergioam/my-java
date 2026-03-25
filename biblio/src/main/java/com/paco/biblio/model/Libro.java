package com.paco.biblio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;
	private String isbn;
	private Integer anioPublicacion;
	private Boolean disponible;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	public Libro() {
	}

	public Libro(String titulo, String isbn, Integer anioPublicacion, Boolean disponible, Autor autor) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.anioPublicacion = anioPublicacion;
		this.disponible = disponible;
		this.autor = autor;
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
