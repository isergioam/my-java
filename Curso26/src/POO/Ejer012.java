package POO;

import java.util.ArrayList;

class Alumno2 {
	private String nombre;
	private int nota;

	public Alumno2(String nombre, int nota) {
		this.nombre = nombre;
		this.nota = nota;
	}

	public void mostrarInfo() {
		System.out.println("Nombre: " + this.nombre + ", Nota: " + this.nota);
	}

}

class Curso2 {
	private String nombreCurso;
	private ArrayList<Alumno2> alumnos = new ArrayList<>();

	public Curso2(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public void agregarAlumno(Alumno2 alumno) {
		this.alumnos.add(alumno);
	}

	public void mostrarAlumnos() {
		System.out.println("Alumnos del curso " + nombreCurso + ":");
		for (Alumno2 alumno : alumnos) {
			alumno.mostrarInfo();
		}

	}

}

public class Ejer012 {
	public static void main(String[] args) {
		Curso2 c = new Curso2("Matemáticas");

		Alumno2 alumno1 = new Alumno2("Juan", 85);
		Alumno2 alumno2 = new Alumno2("María", 92);
		Alumno2 alumno3 = new Alumno2("Pedro", 78);

		c.agregarAlumno(alumno1);
		c.agregarAlumno(alumno2);
		c.agregarAlumno(alumno3);

		c.mostrarAlumnos();
	}
}
