package Ejercicios;

import java.util.Scanner;

public class Ejer14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);		
		int num;
		int cont = 0;
		
		
		do {
			System.out.println("Introduzca una cantidad:");
			num = sc.nextInt();
			
			cont += num;
			
		}while(num != 0);
		
		
		System.out.println("Total: " + cont);
		
		sc.close();
		
		

	}

}
