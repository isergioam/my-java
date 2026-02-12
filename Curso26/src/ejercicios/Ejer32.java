package ejercicios;

import java.util.Scanner;

public class Ejer32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		double notas[] = new double[5];
		int aprobados = 0;
		int suspensos = 0;
		
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Introduzca la nota:");
			double nota = sc.nextDouble();
			sc.nextLine();
			notas[i] = nota;
			if (nota < 5) {
				suspensos++;
			} else {
				aprobados++;
			}	
			
		}	
		System.out.println("Hay " + aprobados + " alumnos aprobados y " + suspensos + " supensos.");
		
		sc.close();
		
		

	}

}
