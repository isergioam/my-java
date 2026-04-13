package com.paco.arenaxp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paco.arenaxp.entity.Videojuego;
import com.paco.arenaxp.service.VideojuegoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//Ruta base para este controlador.
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

	private final VideojuegoService videojuegoService;

	// Inyección de dependencias por constructor.
	public VideojuegoController(VideojuegoService videojuegoService) {
		this.videojuegoService = videojuegoService;
	}

	// Endpoint GET que devuelve la lista de videojuegos.
	@GetMapping
	public List<Videojuego> listarVideojuegos() {
		return videojuegoService.listarVideojuegos();
	}

	// Endpoint POST para crear un nuevo videojuego.
	@PostMapping
	public Videojuego crearVideojuego(@RequestBody Videojuego videojuego) {
		return videojuegoService.guardarVideojuego(videojuego);
	}

	// Endpoint PUT para actualizar un videojuego existente.
	@PutMapping("/{id}")
	public Videojuego actualizarVideojuego(@PathVariable Long id, @RequestBody Videojuego videojuego) {
		return videojuegoService.actualizarVideojuego(id, videojuego);
	}

	// Endpoint DELETE para borrar un videojuego existente.
	@DeleteMapping("/{id}")
	public void borrarVideojuego(@PathVariable Long id) {
		videojuegoService.borrarVideojuego(id);
	}
}