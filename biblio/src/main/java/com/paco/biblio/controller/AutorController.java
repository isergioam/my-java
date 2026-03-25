package com.paco.biblio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.paco.biblio.dto.AutorEntradaDTO;
import com.paco.biblio.dto.AutorSalidaDTO;
import com.paco.biblio.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private final AutorService autorService;

	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}

	@PostMapping
	public ResponseEntity<AutorSalidaDTO> crearAutor(@RequestBody AutorEntradaDTO dto) {
		AutorSalidaDTO creado = autorService.crearAutor(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@GetMapping
	public ResponseEntity<List<AutorSalidaDTO>> listarAutores() {
		return ResponseEntity.ok(autorService.listarAutores());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AutorSalidaDTO> buscarPorId(@PathVariable Long id) {
		AutorSalidaDTO autor = autorService.buscarPorId(id);

		if (autor == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(autor);
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<AutorSalidaDTO>> buscarPorNombre(@RequestParam String texto) {
		return ResponseEntity.ok(autorService.buscarPorNombre(texto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AutorSalidaDTO> actualizarAutor(@PathVariable Long id, @RequestBody AutorEntradaDTO dto) {
		AutorSalidaDTO actualizado = autorService.actualizarAutor(id, dto);

		if (actualizado == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(actualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarAutor(@PathVariable Long id) {
		boolean borrado = autorService.borrarAutor(id);

		if (!borrado) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
}