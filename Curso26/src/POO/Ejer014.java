package POO;

class Empleado {
	String nombre;
	
	public void presentarse() {
		System.out.println("Hola, soy " + this.nombre);
	}
	
}

class Profesor extends Empleado {
	public void presentarse() {
		System.out.println(this.nombre + " dijo Hola");
	}
}

public class Ejer014 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Empleado e1 = new Empleado();
		e1.nombre = "Paco";
		e1.presentarse();
	}

}
