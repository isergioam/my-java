package POO;

class Procesador {
	String marca;
	int ghz;

	public Procesador(String marca, int ghz) {
		this.marca = marca;
		this.ghz = ghz;
	}

	@Override
	public String toString() {
		return marca + " " + ghz + "GHz";
	}

}

class Memoria {
	int gb;

	public Memoria(int gb) {
		this.gb = gb;
	}

	@Override
	public String toString() {
		return gb + "GB";
	}

}

class Computadora {
	String modelo;
	Procesador procesador;
	Memoria memoria;

	public Computadora(String modelo, Procesador procesador, Memoria memoria) {
		this.modelo = modelo;
		this.procesador = procesador;
		this.memoria = memoria;
	}

	@Override
	public String toString() {
		return "Ordenador " + modelo + "\nProcesador: " + procesador + "\nMemoria: " + memoria;
	}

}

public class Ejer033 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Procesador p = new Procesador("Intel", 5);

		Memoria m = new Memoria(16);

		Computadora c = new Computadora("MSI", p, m);

		System.out.println(c);

	}

}
