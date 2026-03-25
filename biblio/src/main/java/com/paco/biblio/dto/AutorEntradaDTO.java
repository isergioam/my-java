package com.paco.biblio.dto;

public class AutorEntradaDTO {

	private String nombre;
	private String pais;

	public AutorEntradaDTO() {
	}

	public AutorEntradaDTO(String nombre, String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}