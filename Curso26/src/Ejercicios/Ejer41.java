package Ejercicios;

import java.util.Scanner;

public class Ejer41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int disparos[] = {0,1,1,0,0,1,0,0,1,1};
		
		int score = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i <= 5; i++) {
			System.out.println("Dispara: ");

			int disparo = sc.nextInt();
			
			if(disparo < 0 || disparo>= disparos.length) {
				System.out.println("Disparo no válido");
				continue;	
			}
						
			if(disparos[disparo] == 0) {
				System.out.println("Agua...");
			} else {
				System.out.println("BOOOOOOOOOOOOOMBA!!");				
				score += 1;
			}
		}
		
		System.out.println("Puntuación final: "+ score);
	sc.close();	
	}

}
