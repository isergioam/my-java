package com.paco.biblio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paco.biblio.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

	List<Libro> findByTituloContainingIgnoreCase(String texto);
}
