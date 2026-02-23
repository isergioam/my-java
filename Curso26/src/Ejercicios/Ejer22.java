package Ejercicios;

public class Ejer22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numMayor(30,50);
		
		
	}
	
	public static void numMayor(int a, int b) {
		if(a > b) {
			System.out.println("El mayor es: ");
		} else if(a < b) {
			System.out.println("El menor es: ");
		} else {
			System.out.println("Son iguales");
		}
	}

}
