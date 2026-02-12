package POO;

class Figura{
	int area() {
		return 0;
	}
}

class Rectangulo2 extends Figura{
	int ancho;
	int alto;
	
	int area() {
		return this.ancho * this.alto;
	}
	
}

class Cuadrado extends Rectangulo2 {
	
	public void iguaLado(int lado) {
		this.ancho = lado;
		this.alto = lado;
	}
}


public class Ejer017 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangulo2 r = new Rectangulo2();
		r.alto = 10;
		r.ancho = 20;
		
		System.out.println("Área del Rectángulo: " + r.area());
		
		Cuadrado c = new Cuadrado();
		c.iguaLado(20);
		
		System.out.println("Área del Cuadrado: " + c.area());
		
	}

}
