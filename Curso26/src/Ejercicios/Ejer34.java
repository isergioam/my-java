package Ejercicios;

import java.util.ArrayList;

public class Ejer34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> num = new ArrayList<>();
		
		num.add(1);
		num.add(10);
		num.add(100);
		num.add(1000);
		num.add(10000);
		num.add(100000);
		
		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}

	}

}
