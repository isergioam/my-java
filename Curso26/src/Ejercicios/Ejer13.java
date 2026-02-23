package Ejercicios;

import java.util.Scanner;

public class Ejer13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String usuario = "admin";
		String password = "1234";
		int intentos = 0;
		
		String user;
		String pass;
		
		
		do {
			System.out.println("Nombre de Usuario:");
			user = sc.nextLine();
			
			System.out.println("Contraseña:");
			pass = sc.nextLine();
			
			intentos++;
			
			if(!user.equals(usuario)) {
				System.out.println("Usuario incorrecto!");
			}
			if(!pass.equals(password)) {
				System.out.println("Contraseña incorrecta!");
			}
			} while (!user.equals(usuario) || !pass.equals(password) && intentos <3);
			if(user.equals(usuario) && pass.equals(password)) {
				System.out.println("Bienvenido, Admin");				
				
			} else {
				System.out.println("No tienes más intentos");
			}
		
		
			;
			sc.close();

				}
			
			}
	
	/*
		System.out.println("Nombre de Usuario:");
		String user = sc.nextLine().toLowerCase();
		
		System.out.print("Contraseña:");
		String pass = sc.nextLine();
		
		if (user.equals("admin") && pass.equals("1234")) {
			System.out.println("Usuario y contraseña son correctas!");
		} else {
			System.out.println("Usuario o contraseña incorrectas.");
		}
		
		sc.close();
		
		
	
	}

}


do {
	
	
	
} while();*/