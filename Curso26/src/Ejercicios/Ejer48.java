package Ejercicios;

import java.util.Scanner;
import java.util.ArrayList;


public class Ejer48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> lista = new ArrayList<>();
		boolean salir = false;
				
		while(!salir) {
			System.out.println("|| 1 AÑADIR || 2 ELIMINAR || 3 MOSTRAR || 0 SALIR ||");
			
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {			
				case 1: // AÑADIR CANCIÓN
					System.out.println("-> Canción: ");
					String cancion = sc.nextLine().toLowerCase();
					
					lista.add(cancion);
					
					break;
					
				case 2: // ELIMINAR CANCIÓN
					System.out.println("<- Eliminar canción: ");
					int index = sc.nextInt();
					lista.set(index, "");
					
					break;
					
				case 3: // MOSTRAR LISTA
					System.out.println("--- Playlist ---");
					System.out.println(lista);
					
					break;
					
				case 0: // SALIR DEL PROGRAMA
					System.out.println("Programa finalizado.");
					salir = true;
					break;
					
				default: // VALIDAR OPCIÓN
					System.out.println("Opción no válida.");
			
			}
			
		}
		
		sc.close();
		
		
		
		
		
		
		

	}

}
