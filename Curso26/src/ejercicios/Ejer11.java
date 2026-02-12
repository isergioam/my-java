package ejercicios;

import java.util.Scanner;

public class Ejer11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		
		do {
		System.out.print("Introduzca un número: ");
		num = sc.nextInt();
		
		if (num < 1 || num > 10) {
			System.out.println("Número no válido.");
			
		}
		} while (num < 1 || num > 10);
			for(int i = 1; i <= 10; i++) {
				System.out.println(num + " * " + i + " = " + num*i);
		}
		
		sc.close();
			
	}
}