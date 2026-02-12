package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejer44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> lista = new ArrayList<>();
		
		lista.add("Paco");
		lista.add("Pepe");
		lista.add("Andres");
		lista.add("Ana");
		lista.add("Sofia");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Eliminar a: ");
		String nombre = sc.nextLine();
		
		if(lista.remove(nombre)) {
			System.out.println("Usuario eliminado.");
		} else {
			System.out.println("No estaba en la lista.");
		} 		
		
		
		System.out.println("--- Listado de Usuarios ---");
		System.out.println(lista);
		
		sc.close();
	}

}
