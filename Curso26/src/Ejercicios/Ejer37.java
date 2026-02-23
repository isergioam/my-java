package Ejercicios;

public class Ejer37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] tiempos = {50, 60, 45, 80, 120};
		int minimo = tiempos[0];
		int maximo = tiempos[0];
		
		
		for(int i = 1; i < tiempos.length; i++) {
			if (tiempos[i] > maximo) {
				maximo = tiempos[i];
			}
			
			if(tiempos[i] < minimo) {
				minimo = tiempos[i];
			}
					
		}
		
		System.out.println("El máximo es " + maximo + " y el mínimo es " + minimo);

	}

}
