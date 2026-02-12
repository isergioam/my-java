package ejercicios;

import java.util.Scanner;

public class Ejer25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.print("Introduzca la base imponible:");
		double base = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("Introduzca el tipo de IVA (general, reducido o superreducido):");
		String iva = sc.nextLine().toLowerCase();
		double tipoIVA = tipoIVA(iva)*100;
		double sinIVA = tipoIVA(iva)*base;
		double total = sinIVA + base;
		
		
		System.out.print("Introduzca el código promocional:");
		String promo = sc.nextLine().toLowerCase();
		double tipoPromo = calculaPROMO(promo,total);
		double totaldesc = total - tipoPromo;
		
		System.out.printf("Base imponible: %.2f€ %nIVA(%.0f%%): %.2f€%nPrecio con IVA: %.2f€%nCód. promo.(%s): -%.2f€%nTOTAL: %.2f€", base, tipoIVA, sinIVA, total, promo , tipoPromo, totaldesc);
		
			
		sc.close();		
		
	}

	/* Función para calcular el precio sin IVA */
	public static double tipoIVA(String tipo) {
		
		switch (tipo) {
			case "general": return 0.21;
			case "reducido": return 0.10;
			case "superreducido": return 0.04;
			default: return 0;
		}
		
	}
	
	/* Función para calcular el precio con promoción */
	public static double calculaPROMO(String tipoPromo, double total) {

		switch (tipoPromo) {
			case "nopro": return 0;
			case "mitad": return total/2;
			case "meno5": return -5;
			case "5porc": return total*0.05;
			default: return 0;
		
		}
	}	
	
		
}

