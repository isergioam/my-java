package POO;

class Bici {
	int id;
	boolean enUso;	

	public Bici(int id) {
		this.id = id;
		this.enUso = false;
	}
	
	public void alquilar() {
		if (this.enUso == true) {
			System.out.println("La bicicleta " + this.id + " está en uso.");
			return;
		} else {
			this.enUso = true;
			System.out.println("Has alquilado la bicicleta " + this.id + " correctamente.");
			return;
		}		
	}
	
	public void devolver() {
		enUso = false;
		System.out.println("La bicicleta ha sido entregada.");
	}

}

/*class BiciElectrica extends Bici {
	
}*/


public class Ejer020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bici b = new Bici(20);
		b.alquilar();		
		b.devolver();
		
		Bici b1 = new Bici(20);
		b1.alquilar();
		
		Bici b2 = new Bici(20);
		b2.alquilar();
		
	}

}
