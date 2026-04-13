package com.paco.arenaxp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paco.arenaxp.entity.Videojuego;
import com.paco.arenaxp.repository.VideojuegoRepository;

@Service
public class VideojuegoService {

	private final VideojuegoRepository videojuegoRepository;

	public VideojuegoService(VideojuegoRepository videojuegoRepository) {
		this.videojuegoRepository = videojuegoRepository;
	}

	public List<Videojuego> listarVideojuegos() {
		return videojuegoRepository.findAll();
	}

	// Método para guardar un nuevo videojuego en la base de datos.
	public Videojuego guardarVideojuego(Videojuego videojuego) {
		return videojuegoRepository.save(videojuego);
	}

	// Método para actualizar un videojuego existente.
	public Videojuego actualizarVideojuego(Long id, Videojuego datosActualizados) {
		Videojuego videojuegoExistente = videojuegoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Videojuego no encontrado con id: " + id));

		videojuegoExistente.setTitulo(datosActualizados.getTitulo());
		videojuegoExistente.setPlataforma(datosActualizados.getPlataforma());
		videojuegoExistente.setGenero(datosActualizados.getGenero());
		videojuegoExistente.setEstado(datosActualizados.getEstado());
		videojuegoExistente.setPuntuacion(datosActualizados.getPuntuacion());
		videojuegoExistente.setHorasJugadas(datosActualizados.getHorasJugadas());
		videojuegoExistente.setFavorito(datosActualizados.getFavorito());

		return videojuegoRepository.save(videojuegoExistente);
	}

	// Método para borrar un videojuego existente.
	public void borrarVideojuego(Long id) {
		if (!videojuegoRepository.existsById(id)) {
			throw new RuntimeException("Videojuego no encontrado con id: " + id);
		}

		videojuegoRepository.deleteById(id);
	}
}