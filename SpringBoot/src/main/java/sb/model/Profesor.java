package sb.model;

public class Profesor {

	private String nombre;
	private String modulo;
	private int horas;

	public Profesor() {
	}

	public Profesor(String nombre, String modulo, int horas) {
		this.nombre = nombre;
		this.modulo = modulo;
		this.horas = horas;
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

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
}
