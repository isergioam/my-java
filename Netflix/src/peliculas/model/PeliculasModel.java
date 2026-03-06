package peliculas.model;

public class PeliculasModel {

	private int id;
	private String titulo;
	private int anno_estreno;
	private int duracion;

	public PeliculasModel(int id, String titulo, int anno_estreno, int duracion) {
		this.id = id;
		this.titulo = titulo;
		this.anno_estreno = anno_estreno;
		this.duracion = duracion;
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

	public int getAnno_estreno() {
		return anno_estreno;
	}

	public void setAnno_estreno(int anno_estreno) {
		this.anno_estreno = anno_estreno;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Peliculas [ID: " + id + ", Título: " + titulo + ", Año de estreno: " + anno_estreno + ", Duración: "
				+ duracion + "]";
	}

}
