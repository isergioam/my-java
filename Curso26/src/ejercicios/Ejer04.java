package ejercicios;

import java.util.Scanner;


public class Ejer04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		int num = sc.nextInt();
		sc.nextLine();
		
		if(num % 2 == 0) {
			System.out.print("El número introducido es par");
			
		} else {
			System.out.print("El número introducido NO es par");
		}
		
		sc.close();
		
	}

}
