package Ejercicios;

public class Ejer23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("La suma es: " + sumar(3,5));
		System.out.println("La resta es: " + restar(5,3));
		System.out.println("La multiplicación es: " + multiplicar(5,3));
		System.out.println("La división es: " + dividir(5,0));
		

	}
	
	public static double sumar(double a, double b) {
		
		double num = a + b;
		
		return num;
		
	}
	public static double restar(double a, double b) {
		double num = a - b;
		
		return num;
		
	}
	public static double multiplicar(double a, double b) {
		double num = a * b;
		
		return num;
		
	}
	public static double dividir(double a, double b) {
		double num = a / b;
		
		return num;
		
	}

}
