package POO;

class Parking {
	String[] plazas;

	public Parking(int cant) {
		this.plazas = new String[cant];

		/*for (String plaza : plazas) {
			plaza = null;
		}*/

	}
	
	public void entrar(String matricula) {
		for (int i = 0; i < plazas.length; i++) {
			if (this.plazas[i] == matricula) {
				System.out.println("El vehículo ya está aparcado.");
				return;
			}
		}
		for (int i = 0; i < plazas.length; i++) {
			if (this.plazas[i] == null) {
				this.plazas[i] = matricula;
				return;
			}
		}
	}

	public void salir(String matricula) {
		for (int i = 0; i < plazas.length; i++) {
			if (this.plazas[i] == matricula) {
				System.out.println("Sale el vehículo");
				this.plazas[i] = null;
				return;
			}
		}
		System.out.println("El coche no estaba dentro");
	}

	public void listar() {
		for (int i = 0; i < plazas.length; i++) {
			System.out.println(i + " - " + this.plazas[i]);
		}

	}

}

public class Ejer023 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Parking p = new Parking(5);
		p.entrar("12345 BMN");
		p.entrar("12345 BNZ");
		p.listar();
		p.salir("12345 BMN");
		p.listar();
		
		
	}

}
