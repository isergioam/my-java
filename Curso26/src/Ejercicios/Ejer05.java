package Ejercicios;

import java.util.Scanner;
/* Escribe un programa que, dado un número de mes (1 a 12) en la variable mes,
 *  imprima el nombre del mes. Usa switch. 
 *  Si el número está fuera de 1-12, imprime "Mes inválido"*/

public class Ejer05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el número de mes: ");
		int num = sc.nextInt();
		sc.nextLine();		
		
		String mes;
		
		switch(num){
			case 1: mes = "Enero"; break;
			case 2: mes = "Febrero"; break;
			case 3: mes = "Marzo"; break;
			case 4: mes = "Abril"; break;
			case 5: mes = "Mayo"; break;
			case 6: mes = "Junio"; break;
			case 7: mes = "Julio"; break;
			case 8: mes = "Agosto"; break;
			case 9: mes = "Septiembre"; break;
			case 10: mes = "Octubre"; break;
			case 11: mes = "Noviembre"; break;
			case 12: mes = "Diciembre"; break;
			default: mes = "Mes no válido";
		}
		
		System.out.print("Mes de " + mes);
		
		sc.close();
	}

}
