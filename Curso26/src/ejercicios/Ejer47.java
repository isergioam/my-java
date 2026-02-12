package ejercicios;

import java.util.Scanner;
import java.util.ArrayList;


public class Ejer47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> insti = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		boolean salir = false;
		int indice = 0;
		
		while(!salir) {
			
			System.out.println("1 AÑADIR | 2 ELIMINAR | 3 MOSTRAR | 4 VACIAR | 5 SALIR");

			int option = sc.nextInt();
			sc.nextLine();
			
			switch(option){
			
				case 1:
					System.out.println("Añadir alumno");					
					String alumno = sc.nextLine();
					
					if(alumno.length() == 0) {
						System.out.println("La tarea está vacía");
					} else {
						insti.add(alumno);	
					}				
					break;				
										
				case 2:
					System.out.println("Borrar alumno");					
					indice = sc.nextInt();
					sc.nextLine();
					
					if(indice >= 0 && indice < insti.size()) {
						insti.remove(indice);
						System.out.println("Alumno eliminado");
					} else {
						System.out.println("Ese alumno no existe");	
					}				
					break;					
					
				case 3:
					System.out.println("--- Listado ---");
					int contador = 0;
					for(String show : insti) {
						System.out.println(contador + " - " + show);
						contador++;
					}
					
					break;
					
				case 4: 
					insti.clear();
					break;
					
				case 5: 
					salir = true;
					break;
					
				default:
					System.out.println("Opción no válida.");				
				
			}
			
			sc.close();	
			
			
		}		
	}

}
