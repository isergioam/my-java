package ejercicios;

import java.util.Scanner;

public class Ejer18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String email;
		
		
		System.out.println("Introduce tu email:");
		email = sc.nextLine();
		
		System.out.println("Su email es: " + email.replace(" ", "").toLowerCase());
		System.out.println("¿Tiene su @? " + email.contains("@"));
		
		sc.close();

	}

}
