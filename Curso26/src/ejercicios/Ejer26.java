package ejercicios;

import java.util.Random;

public class Ejer26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		
		int dado1, dado2 = 0;
		
		do {
			
			dado1 = r.nextInt(6)+1;
			dado2 = r.nextInt(6)+1;
		
			System.out.println("Dado 1: " + dado1 + " Dado 2: " + dado2);
			
		} while (dado1 != dado2);

	}

}
