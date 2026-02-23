package Ejercicios;

import java.util.Scanner;

public class Ejer28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Cuantas horas has trabajado?");
		int horas = sc.nextInt();
		sc.nextLine();		
		
		calcularSalario(horas);
		
		sc.close();

	}
	
	public static void calcularSalario(int horas) {
		
		int menos40;
		int mas40;
		int horasNormales;
		
		if (horas < 40) {			
			menos40 = horas * 12;
			System.out.println("Su salario es: " + menos40 );
			
		
		} else {
			horasNormales = 40 * 12;
			mas40 = horasNormales + (horas - 40) * 16;
			System.out.println("Su salario es: " + mas40);	
		}	
		
	} 

}
