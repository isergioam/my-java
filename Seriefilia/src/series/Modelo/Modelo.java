package series.Modelo;

public class Modelo {

	private int id;
	private String titulo;
	private int capitulo;
	private int temporada;
	private int valoracion;
	
	public Modelo(int id, String titulo, int capitulo, int temporada, int valoracion) {
		this.id = id;
		this.titulo = titulo;
		this.capitulo = capitulo;
		this.temporada = temporada;
		this.valoracion = valoracion;
	}
	
	public Modelo(String titulo, int capitulo, int temporada, int valoracion) {
		this.titulo = titulo;
		this.capitulo = capitulo;
		this.temporada = temporada;
		this.valoracion = valoracion;
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

	public int getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	public int getTemporada() {
		return temporada;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", titulo=" + titulo + ", capitulo=" + capitulo + ", temporada=" + temporada
				+ ", valoracion=" + valoracion + "]";
	}
	
}
