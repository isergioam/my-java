package POO;

class Humano {
	String nombre;
	int edad;
	
	public Humano(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public void presentarse() {
		System.out.println("Hola, " + nombre + " de " + edad + " años");
	}
}

class Estudiante extends Humano {
	String curso;
	
	public Estudiante(String nombre, int edad, String curso) {
		super(nombre, edad);
		this.curso = curso;
	
	}
	
	public void presentarse() {
		System.out.println("Hola, " + nombre + " de " + edad + " años y del curso de " + curso);
	}
	
}


public class Ejer018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Humano h = new Humano("Paco", 50);
		h.presentarse();
		
		Estudiante e = new Estudiante("Paco", 50, "Musica");
		e.presentarse();
	}

}
