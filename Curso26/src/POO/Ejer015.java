package POO;

class Vehiculo {
	int velocidad;
	
	public void acelerar() {
		this.velocidad = this.velocidad + 10;
	}
	public void mostrarVelocidad() {
		System.out.println("Su velocidad es " + velocidad);
	}

}

class Bicicleta extends Vehiculo {
	@Override
	public void acelerar() {
		this.velocidad = this.velocidad + 5;
	}
	@Override
	public void mostrarVelocidad() {
		System.out.println("Su velocidad es " + velocidad);
	}
}




public class Ejer015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehiculo v = new Vehiculo();
		v.velocidad = 0;
		v.acelerar();
		v.mostrarVelocidad();		
		
		Bicicleta b = new Bicicleta();
		b.velocidad = 0;
		b.acelerar();
		b.mostrarVelocidad();
	}

}
