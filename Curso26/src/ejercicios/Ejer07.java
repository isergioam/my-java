package ejercicios;

import java.util.Scanner;

public class Ejer07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca la temperatura: ");
		double temp = sc.nextDouble();
		sc.nextLine();	
		
		double far = temp * 9 / 5 + 32;
		
		System.out.println("la temperatura es: " + far);

		sc.close();
	}
	

}
