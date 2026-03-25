package com.paco.biblio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paco.biblio.dto.AutorEntradaDTO;
import com.paco.biblio.dto.AutorSalidaDTO;
import com.paco.biblio.model.Autor;
import com.paco.biblio.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public AutorSalidaDTO crearAutor(AutorEntradaDTO dto) {
        Autor autor = new Autor(dto.getNombre(), dto.getPais());
        Autor guardado = autorRepository.save(autor);
        return convertirASalidaDTO(guardado);
    }

    public List<AutorSalidaDTO> listarAutores() {
        return autorRepository.findAll()
                .stream()
                .map(this::convertirASalidaDTO)
                .toList();
    }

    public AutorSalidaDTO buscarPorId(Long id) {
        Optional<Autor> autorOptional = autorRepository.findById(id);

        if (autorOptional.isEmpty()) {
            return null;
        }

        return convertirASalidaDTO(autorOptional.get());
    }

    public List<AutorSalidaDTO> buscarPorNombre(String texto) {
        return autorRepository.findByNombreContainingIgnoreCase(texto)
                .stream()
                .map(this::convertirASalidaDTO)
                .toList();
    }

    public AutorSalidaDTO actualizarAutor(Long id, AutorEntradaDTO dto) {
        Optional<Autor> autorOptional = autorRepository.findById(id);

        if (autorOptional.isEmpty()) {
            return null;
        }

        Autor autor = autorOptional.get();
        autor.setNombre(dto.getNombre());
        autor.setPais(dto.getPais());

        Autor actualizado = autorRepository.save(autor);
        return convertirASalidaDTO(actualizado);
    }

    public boolean borrarAutor(Long id) {
        if (!autorRepository.existsById(id)) {
            return false;
        }

        autorRepository.deleteById(id);
        return true;
    }

    private AutorSalidaDTO convertirASalidaDTO(Autor autor) {
        return new AutorSalidaDTO(
                autor.getId(),
                autor.getNombre(),
                autor.getPais()
        );
    }
}