package com.paco.biblio.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paco.biblio.dto.LibroEntradaDTO;
import com.paco.biblio.dto.LibroSalidaDTO;
import com.paco.biblio.model.Autor;
import com.paco.biblio.model.Libro;
import com.paco.biblio.repository.AutorRepository;
import com.paco.biblio.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public LibroSalidaDTO crearLibro(LibroEntradaDTO dto) {
    	Optional<Autor> autorOptional = autorRepository.findById(dto.);
    	
        Libro libro = new Libro(
                dto.getTitulo(),
                dto.getIsbn(),
                dto.getAnioPublicacion(),
                dto.getDisponible()
        );

        Libro guardado = libroRepository.save(libro);
        return convertirASalidaDTO(guardado);
    }

    public List<LibroSalidaDTO> listarLibros() {
        return libroRepository.findAll()
                .stream()
                .map(this::convertirASalidaDTO)
                .toList();
    }

    public LibroSalidaDTO buscarPorId(Long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);

        if (libroOptional.isEmpty()) {
            return null;
        }

        return convertirASalidaDTO(libroOptional.get());
    }

    public List<LibroSalidaDTO> buscarPorTitulo(String texto) {
        return libroRepository.findByTituloContainingIgnoreCase(texto)
                .stream()
                .map(this::convertirASalidaDTO)
                .toList();
    }

    public LibroSalidaDTO actualizarLibro(Long id, LibroEntradaDTO dto) {
        Optional<Libro> libroOptional = libroRepository.findById(id);

        if (libroOptional.isEmpty()) {
            return null;
        }

        Libro libro = libroOptional.get();
        libro.setTitulo(dto.getTitulo());
        libro.setIsbn(dto.getIsbn());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setDisponible(dto.getDisponible());

        Libro actualizado = libroRepository.save(libro);
        return convertirASalidaDTO(actualizado);
    }

    public boolean borrarLibro(Long id) {
        if (!libroRepository.existsById(id)) {
            return false;
        }

        libroRepository.deleteById(id);
        return true;
    }

    private LibroSalidaDTO convertirASalidaDTO(Libro libro) {
        return new LibroSalidaDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getIsbn(),
                libro.getAnioPublicacion(),
                libro.getDisponible()
        );
    }
}