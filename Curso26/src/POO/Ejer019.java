package POO;

class Empleado2 {
	String nombre;
	int sueldoBase = 1000;
	
	public Empleado2(String nombre, int sueldoBase) {
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
	}
	
	public double calcularSueldo() {
		return this.sueldoBase;
	}
}

class EmpleadoFijo extends Empleado2{
	int plus;
	
	public EmpleadoFijo(String nombre, int sueldoBase, int plus) {
		super(nombre,sueldoBase);
		this.plus = plus;
	}
	public int calcularSueldo() {
		return this.sueldoBase + this.plus;
	}
}


public class Ejer019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
