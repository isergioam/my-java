package POO;

class SalaCine {
	int[] asientos;

	SalaCine(int butacas) {
		this.asientos = new int[butacas];
	}

	public void reservar(int butaca) {
		int num = butaca - 1;
		if (this.asientos[num] == 1) {
			System.out.println("Asiento ocupado.");
		} else {
			this.asientos[num] = 1;
		}
	}

	public void cancelar(int butaca) {
		int num = butaca - 1;
		if (this.asientos[num] == 0) {
			System.out.println("Este asiento está libre.");
		} else {
			this.asientos[num] = 0;
		}
	}

	public int contarLibres() {
		int libres = 0;
		for (int butaca : this.asientos) {
			if (butaca == 0) {
				libres = libres + 1;
			}
		}
		return libres;
	}

	public void mostrarMapa() {
		String cadena = "[";
		for (int butaca : this.asientos) {
			if (butaca == 0) {
				cadena = cadena + "0";
			} else {
				cadena = cadena + "1";

			}
		}
		cadena = cadena + "]";
		System.out.println(cadena);
	}

}

public class Ejer021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SalaCine e = new SalaCine(6);
		e.reservar(1);
		e.reservar(3);
		e.reservar(5);
		System.out.println(e.contarLibres());
		e.mostrarMapa();

	}

}
