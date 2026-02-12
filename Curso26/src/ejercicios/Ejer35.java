package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;


public class Ejer35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);		
		ArrayList<Integer> num = new ArrayList<>();
		
		for(int i = 0; i < 5 ; i++) {
			System.out.println("Introduce un número: ");
			num.add(sc.nextInt());	
			
		}		
		System.out.println(num);
		
		sc.close();
	}

}
