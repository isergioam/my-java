package Ejercicios;

public class Ejer39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int vida = 20;		
		int golpes[] = {4,6,5,0,8,2,7,3};

		for(int i = 0; i < golpes.length; i++) {
			vida = vida - golpes[i];
			System.out.println("Turno " + (i+1) + ": daño " + golpes[i] + " -> vida enemiga: " + vida);
		if (vida <= 0) {
			System.out.println("Enemigo derrotado en el turno: " + (i+1));
			
			return;
		}
		
		}
		System.out.println("Le quedó " + vida + " puntos de vida.");
		
	}

}
