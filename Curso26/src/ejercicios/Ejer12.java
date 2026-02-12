package ejercicios;

import java.util.Scanner;
import java.util.Random;

public class Ejer12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Random aleatorio = new Random();
		int def = aleatorio.nextInt(10)+1;
		int num;
		
		int cont = 0;
		
		do {
			cont++;
			System.out.print("Introduzca un número:");
			num = sc.nextInt();

			
		 if (num < def) {
			System.out.println("Demasiado bajo");
			
		} else if ( num > def) {
			System.out.println("Demasiado alto");
		}
		} while (num != def);
		
			System.out.print("Has acertado!");
			System.out.println(" Después de " + cont + " intentos!");
		
		
		sc.close();
	}
	

}
