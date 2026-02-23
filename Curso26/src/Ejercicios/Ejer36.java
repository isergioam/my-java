package Ejercicios;

import java.util.Scanner;

public class Ejer36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Que número quieres buscar?");
		int num = sc.nextInt();
		int index = -1;		
		
		int[] list = {2, 6, 9, 15};
		
		for (int i = 0; i < list.length; i++) {
            if (list[i] == num) {
                index = i;
            }
       
		}
		
		 if(index != -1) {
	        	System.out.println("Su posición es: " + (index+1));
	        } else {
	        	System.out.println("No encontrado");
	        }
		 
		 sc.close();
	}

}
