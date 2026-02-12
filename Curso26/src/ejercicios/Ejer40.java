package ejercicios;

public class Ejer40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int picos[] = {2,4,3,6,5,7,1,2};
		
		for(int i = 1; i < picos.length-1; i++) {
			if(picos[i] > picos[i - 1] && picos[i] > picos[i +1]) {
				System.out.println("La posición es " + (i+1) + " y su pico " + picos[i]);
				
			}
		}

	}

}
