package Ejercicios;

import java.util.Scanner;

public class Ejer33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int num[] = new int[5];
		boolean found = false;
		
		
		for (int i = 0; i < num.length; i++) {
			System.out.print("Introduzca el valor de la posición " + (i + 1) + " de la array:");
			num[i] = sc.nextInt();		
		}	
		
		
		System.out.println("Dime el número que quieres buscar: ");		
		int search = sc.nextInt();
		
		for (int i = 0; i < num.length; i++) {
			if (num[i] == search) {
				found = true;
			}
		} System.out.println("Encontrado: " + found);
		
			
		sc.close();

	}

}
