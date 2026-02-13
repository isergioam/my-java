package POO;

class AlumnoNotas {
	String nombre;
	double[] notas;

	AlumnoNotas(String nombre, int num) {
		this.notas = new double[num];
		this.nombre = nombre;
	}

	public void ponerNota(int eva, double nota) {
		int indice = eva - 1;

		if (indice < 0 || indice > this.notas.length) {
			System.out.println("Evaluación incorrecta.");

		} else if (nota < 0 || nota > 10) {
			System.out.println("Nota erronea.");

		} else {
			this.notas[indice] = nota;
		}

	}

	public void media() {
		double suma = 0;
		for (double nota : this.notas) {
			suma = suma + nota;
		}

		double media = suma / this.notas.length;
		System.out.println("La nota media es: " + media);
	}

	public void info() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Notas: ");
		for (double nota : this.notas) {
			System.out.println(nota);
		}
	}

}

public class Ejer022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AlumnoNotas a = new AlumnoNotas("Paco",5);
		a.ponerNota(1, 10);
		a.ponerNota(2, 9.75);
		a.ponerNota(3, 10);
		a.ponerNota(4, 8);
		a.ponerNota(5, 7);
		a.ponerNota(1, 5);
		
		a.media();
		a.info();
		
	}

}
