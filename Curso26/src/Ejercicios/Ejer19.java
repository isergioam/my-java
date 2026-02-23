package Ejercicios;

import java.util.Scanner;

public class Ejer19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su producto:");
		String prod = sc.nextLine();
		
		System.out.println("Introduzca su precio:");
		double price = sc.nextDouble();
		
		System.out.println(String.format("Producto: %-5s | Precio: %5.2f €", prod, price));

		sc.close();
	}

}
