package sb.model;

public class Profesor {

	private String nombre;
	private String modulo;

	public Profesor() {
	}

	public Profesor(String nombre, String modulo) {
		super();
		this.nombre = nombre;
		this.modulo = modulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

}
