package model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "videojuegos")
public class Videojuego {
	@Id
	private int id;
	
	private String titulo;
	
	@ManyToMany(mappedBy = "videojuegos")
	private Set<Jugador> jugadores = new HashSet<>();
	
	public Videojuego() {}

	public Videojuego(int id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
