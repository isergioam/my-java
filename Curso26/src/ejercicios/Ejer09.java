package ejercicios;

import java.util.Scanner;

public class Ejer09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca un color: ");
		String color = sc.nextLine().toLowerCase();
		
		switch(color) {
			case "rojo":				
				System.out.println("SEMÁFORO EN ROJO!!");
			break;
			case "amarillo":
				System.out.println("SEMÁFORO EN VERDE!!");
			break;
			case "verde": 
				System.out.println("SEMÁFORO EN AMBAR!!");
			break;
			default: 
				System.out.println("ERROR!!"); 
			break;
		}		
		
		sc.close();		
		
	}

}
