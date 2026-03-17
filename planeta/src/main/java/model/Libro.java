package model;

import jakarta.persistence.*;

/**
 * Entidad que representa un empleado.
 */
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    private int id;

    @Column(nullable = false, length = 100)
    private String titulo;

    /**
     * Relación muchos a uno:
     * muchos empleados pueden pertenecer a un departamento.
     *
     * JoinColumn indica la columna de clave foránea.
     */
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    private int paginas;
    
    public Libro() {
    }

    public Libro(int id, String titulo, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", paginas=" + paginas + "]";
	}
}