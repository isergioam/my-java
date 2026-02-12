package ejercicios;

import java.util.Scanner;

public class Ejer16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String name;
		
		System.out.println("¿Cual es tu nombre?");
		name = sc.nextLine();
		
		char first = name.charAt(0);				
		char last = name.charAt(name.length()-1);
		
		
		System.out.println("Tu nombre empieza por: " + first);
		System.out.println("Tu nombre termina en: " + last);
		
		sc.close();

	}

}
