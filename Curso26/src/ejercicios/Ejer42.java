package ejercicios;

import java.util.Scanner;
import java.util.ArrayList;

public class Ejer42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> deseos = new ArrayList<>();
		
		String deseo ="";
		
		do {
		
			System.out.println("Introduzca su deseo: (\"fin\" para cancelar)");
			
			deseo = sc.nextLine().toLowerCase();
			
			if(!deseo.equals("fin")) {			
				deseos.add(deseo);
				
			}	
			
		} while(!deseo.equals("fin"));	
		
		System.out.println("--- Lista de deseos ---");
		for(String peticion : deseos) {
			 System.out.println(peticion);
		}
		
		sc.close();
	}

}
