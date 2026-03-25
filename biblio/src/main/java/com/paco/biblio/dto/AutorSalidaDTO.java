package com.paco.biblio.dto;

public class AutorSalidaDTO {

	private Long id;
	private String nombre;
	private String pais;

	public AutorSalidaDTO() {
	}

	public AutorSalidaDTO(Long id, String nombre, String pais) {
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPais() {
		return pais;
	}
}