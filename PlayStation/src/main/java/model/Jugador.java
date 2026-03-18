package model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {

	@Id
	private int id;
	
	private String nombre;
	
	@ManyToMany
	@JoinTable(
			name = "jugadores_videojuegos",
			joinColumns = @JoinColumn(name = "jugador_id"),
			inverseJoinColumns = @JoinColumn(name = "videojuego_id")
			)
	private Set<Videojuego> videojuegos = new HashSet<>();

	public Jugador() {}
	
	public Jugador(int id, String nombre) {
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

	public void addVideojuego(Videojuego videojuego) {
		videojuegos.add(videojuego);
		videojuego.getJugadores().add(this);
	}
	
}
