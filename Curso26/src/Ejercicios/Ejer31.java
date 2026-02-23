package Ejercicios;

import java.util.Scanner;

public class Ejer31 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			int[] num = new int[5];
			
			int suma = 0;
			
			for (int i = 0; i < num.length; i++) {
				System.out.print("Introduzca el número " + (i + 1) + ":");
				num[i] = sc.nextInt();
				sc.nextLine();
				suma += num[i];
			}		
			
			System.out.println("-- Listado de números --");
			
			
			
			
			for(int i = 0; i < num.length; i++) {
				System.out.println("El número: " + (i + 1) + " es: " + num[i]);	
			}
			
			System.out.println("La suma total de todos los números es: " + suma);
			System.out.print("El valor medio de todos los números es: " + suma / num.length);
			
			
			sc.close();
			
		}

	}