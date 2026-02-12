package ejercicios;

import java.util.Scanner;
import java.util.Random;

public class Ejer15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random aleatorio = new Random();		
		String pc_resultado = "";
		String resultado = "";
		int victoria = 0;
		int derrota = 0;
		int empate = 0;
		
		for(int rondas = 1; rondas <=3; rondas++) {
			
			System.out.println("¿Piedra, Papel o Tijera?");
			
			resultado = sc.nextLine().toLowerCase();
			int pc = aleatorio.nextInt(2);
		
			switch(pc) {
				case 0: pc_resultado = "piedra"; break;
				case 1: pc_resultado = "papel"; break;
				case 2: pc_resultado = "tijera"; break;
			}
			
			
			
			if (resultado.equals(pc_resultado)) {
				empate++;
				
			} else if (			
					(resultado.equals("piedra") && pc_resultado.equals("tijera")) ||
					(resultado.equals("papel") && pc_resultado.equals("piedra")) ||
					(resultado.equals("tijera") && pc_resultado.equals("papel"))){
				victoria++;
				
			} else {
				derrota++;
			}
		
			System.out.println("Victorias: " + victoria);
			System.out.println("Empates: " + empate);
			System.out.println("Derrotas: " + derrota);	
		
		
		}
		sc.close();
	}

}
