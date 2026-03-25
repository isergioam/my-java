package com.paco.biblio.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String pais;

	@OneToMany(mappedBy = "autor")
	private List<Libro> libros = new ArrayList<>();

	public Autor() {
	}

	public Autor(String nombre, String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPais() {
		return pais;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}