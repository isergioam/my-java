package model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

	@Id
	private int id;
	
	private String titulo;
	
	@ManyToMany(mappedBy = "peliculas")
	private Set<Actor> actores = new HashSet<>();
	
	public Pelicula() {}

	public Pelicula(int id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<Actor> getActores() {
		return actores;
	}

	public void setActores(Set<Actor> actores) {
		this.actores = actores;
	}	
}
