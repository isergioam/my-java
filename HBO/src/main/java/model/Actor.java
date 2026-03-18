package model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "actores")
public class Actor {

	@Id
	private int id;
	
	private String nombre;
	
	@ManyToMany
	@JoinTable(
			name = "actores_peliculas",
			joinColumns = @JoinColumn(name = "actor_id"),
			inverseJoinColumns = @JoinColumn(name = "pelicula_id")
			)

	private Set<Pelicula> peliculas = new HashSet<>();

	public Actor() {}
	
	public Actor(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addPelicula(Pelicula pelicula) {
		peliculas.add(pelicula);
		pelicula.getActores().add(this);
	}	
}
