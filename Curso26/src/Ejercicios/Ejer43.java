package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejer43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> ok = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		
		String userOK = "";
		String user = "";
		
		// LISTA DE ACCESO
		
		do {
			
			System.out.println("Usuario Permitido: (\"fin\" para cancelar)");
			
			user = sc.nextLine().toLowerCase();
			
			if(!user.equals("fin")) {			
				ok.add(user);
				
			}	
			
		} while(!user.equals("fin"));	
		
		
		// COMPROBAR USUARIO
		
		do {
			
			System.out.println("Introduce Usuario para comprobar: (\"fin\" para cancelar)");
			
			userOK = sc.nextLine().toLowerCase();
			
			if(userOK.contains(user)) {			
				System.out.println("Usuario admitido");
				
			}	else {
				System.out.println("Usuario no válido");
			}
			
		} while(!userOK.equals("fin"));	

		sc.close();
		
	}

}
