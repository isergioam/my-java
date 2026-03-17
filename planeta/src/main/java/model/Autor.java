package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un departamento.
 */
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    private int id;

    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false, length = 50)
    private String nacionalidad;

    /**
     * Relación uno a muchos:
     * un departamento puede tener muchos empleados.
     *
     * mappedBy indica que la relación se gestiona
     * desde el atributo "departamento" de Empleado.
     */
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros = new ArrayList<>();

    public Autor() {
    }

    public Autor(int id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	/**
     * Método de ayuda para mantener la relación sincronizada
     * en memoria por ambos lados.
     */
    public void addLibro(Libro libro) {
        libros.add(libro);
        libro.setAutor(this);
    }

    @Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", libros=" + libros + "]";
	}
}
