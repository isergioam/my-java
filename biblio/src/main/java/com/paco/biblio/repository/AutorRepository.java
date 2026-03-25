package com.paco.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paco.biblio.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNombreContainingIgnoreCase(String texto);
}
