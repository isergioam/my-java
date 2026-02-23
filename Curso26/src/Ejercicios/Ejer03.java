package Ejercicios;

import java.util.Scanner;

public class Ejer03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce la base: ");
		int base = sc.nextInt();
		sc.nextLine();
		System.out.print("Introduce la altura: ");
		int altura = sc.nextInt();
		sc.nextLine();
		
		int area = base * altura;
		
		System.out.print("Área: " + area + "m²");
		
		sc.close();

	}

}
