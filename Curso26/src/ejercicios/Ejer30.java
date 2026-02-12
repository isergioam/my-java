package ejercicios;

import java.util.Scanner;

public class Ejer30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[5];
		
		
		
		for (int i = 0; i < num.length; i++) {
			System.out.print("Introduzca el número " + (i + 1) + ":");
			num[i] = sc.nextInt();
			sc.nextLine();	
		}		
		
		System.out.println("-- Listado de números --");
		
		
		for(int i = 0; i < num.length; i++) {
			System.out.println("El número: " + (i + 1) + " es: " + num[i]);	
		}
		
		sc.close();
		
	}

}
