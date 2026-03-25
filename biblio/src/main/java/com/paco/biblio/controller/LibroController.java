package com.paco.biblio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.paco.biblio.dto.LibroEntradaDTO;
import com.paco.biblio.dto.LibroSalidaDTO;
import com.paco.biblio.service.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<LibroSalidaDTO> crearLibro(@RequestBody LibroEntradaDTO dto) {
        LibroSalidaDTO creado = libroService.crearLibro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<LibroSalidaDTO>> listarLibros() {
        return ResponseEntity.ok(libroService.listarLibros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroSalidaDTO> buscarPorId(@PathVariable Long id) {
        LibroSalidaDTO libro = libroService.buscarPorId(id);

        if (libro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(libro);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<LibroSalidaDTO>> buscarPorTitulo(@RequestParam String texto) {
        return ResponseEntity.ok(libroService.buscarPorTitulo(texto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroSalidaDTO> actualizarLibro(@PathVariable Long id,
                                                          @RequestBody LibroEntradaDTO dto) {
        LibroSalidaDTO actualizado = libroService.actualizarLibro(id, dto);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarLibro(@PathVariable Long id) {
        boolean borrado = libroService.borrarLibro(id);

        if (!borrado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}