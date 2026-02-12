package ejercicios;

import java.util.Scanner;
import java.util.ArrayList;


public class Ejer46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int indice = 0;
		
		ArrayList<String> tareas = new ArrayList<>();
		
		while(!salir) {
			
			System.out.println("1 AÑADIR | 2 HACER | 3 LISTADO | 0 SALIR");
			
			int option = sc.nextInt();
			sc.nextLine();
			
			switch (option){
				case 1:
					System.out.println("Añadir nueva tarea");					
					String nueva_tarea = sc.nextLine();
					
					if(nueva_tarea.length() == 0) {
						System.out.println("La tarea está vacía");
					} else {
						tareas.add(nueva_tarea);	
					}				
					break;				
				
				case 2:
					System.out.println("Borrar tarea");					
					indice = sc.nextInt();
					sc.nextLine();
					
					if(indice >= 0 && indice < tareas.size()) {
						tareas.remove(indice);
						System.out.println("Tarea eliminada");
					} else {
						System.out.println("Esa tarea no existe");	
					}				
					break;					
					
				case 3:
					System.out.println("--- Listado ---");
					int contador = 0;
					for(String tarea : tareas) {
						System.out.println(contador + " - " + tarea);
						contador++;
					}
					
					break;
					
				case 0:
					salir = true;
					break;
					
				default:
					System.out.println("Opción no válida.");
			}
			
			/*if (!salir) {
                System.out.println("\nPulsa ENTER para volver al menú...");
                sc.nextLine();
            }*/			
		}
		
		System.out.println("Programa terminado.");
		sc.close();
	}

}
