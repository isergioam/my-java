package POO;

import java.util.ArrayList;

class Persona {
	String nombre;

	public Persona(String nombre) {
		this.nombre = nombre;

	}

	public void presentar() {
		System.out.println("Soy " + this.nombre);
	}
}

class Alumno3 extends Persona {
	int nota1;
	int nota2;

	public Alumno3(String nombre, int nota1, int nota2) {
		super(nombre);
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	@Override
	public void presentar() {
		System.out.println("Las notas del alumno " + this.nombre + " son: " + this.nota1 + " y " + this.nota2);
	}

}

class Profesor2 extends Persona {
	String especialidad;

	public Profesor2(String nombre, String especialidad) {
		super(nombre);
		this.especialidad = especialidad;
	}

	@Override
	public void presentar() {
		System.out.println("Soy " + this.nombre + " Profesor de " + this.especialidad);
	}
}

class Academia {
	ArrayList<Alumno3> alumnos = new ArrayList<>();
	ArrayList<Profesor2> profesores = new ArrayList<>();

	public void addAlumno(Alumno3 a) {
		alumnos.add(a);
	}

	public void addProfesor(Profesor2 p) {
		profesores.add(p);
	}

	public void presentacion() {
		for (Alumno3 a : alumnos) {
			a.presentar();
		}
		for (Profesor2 p : profesores) {
			p.presentar();
		}

	}

}

public class Ejer034 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Profesor2 p1 = new Profesor2("Paco", "Matemáticas");
		Profesor2 p2 = new Profesor2("María José", "Física y Química");
		Profesor2 p3 = new Profesor2("Sergio", "Informática");

		Alumno3 a = new Alumno3("Juan", 5, 7);
		
		
		Academia academia = new Academia();		
		academia.addAlumno(a);
		academia.addProfesor(p1);
		academia.addProfesor(p2);
		academia.addProfesor(p3);
		
		academia.presentacion();

	}

}
