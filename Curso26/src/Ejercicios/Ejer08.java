package Ejercicios;

import java.util.Scanner;

public class Ejer08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca su edad: ");
		int edad = sc.nextInt();
		sc.nextLine();
		
		if(edad >= 18) {
			System.out.print("Eres mayor de edad");
			
		} else {
			System.out.print("Eres un yogurin");
		}
		
		sc.close();
		

	}

}
