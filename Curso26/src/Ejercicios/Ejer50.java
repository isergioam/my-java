package Ejercicios;

import java.util.Scanner;
import java.util.HashMap;

public class Ejer50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> inventario = new HashMap<>();
		boolean salir = false;
		String obj = "";
		int cant = 0;
		
		while(!salir){
			System.out.println("|| 1 AÑADIR || 2 VENDER || 3 BUSCAR || 4 LISTA || 0 SALIR ||");
			
			int num = comprobarEntero(sc);
			
			switch(num) {
			
				case 1: //AÑADIR PRODUCTOS
					System.out.println("Añadir Objeto: ");
					obj = sc.nextLine();
					System.out.println("Introduce la cantidad:");
					cant = sc.nextInt();
					sc.nextLine();
					if(inventario.containsKey(obj)) {
						int cant_old = inventario.get(obj);
						
						int cant_new = cant_old + cant;
						
						inventario.put(obj, cant_new);
						
					} else {
						inventario.put(obj, cant);
					}
					
					break;
					
				case 2: //VENDER PRODUCTO
					System.out.println("¿Qué producto quieres vender?");
					obj = sc.nextLine();
					
					if(!inventario.containsKey(obj)) {
						System.out.println("Ese producto no está en el inventario");
						break;
					}
					
					System.out.println("Cantidad a vender: ");
					cant = sc.nextInt();
					sc.nextLine();
					
					int cantActual = inventario.get(obj);
					
					if(cantActual < cant) {
						
						System.out.println("No hay suficiente producto");
						
					} else {
						cantActual = cantActual - cant;
						inventario.put(obj, cantActual);
					}
					
					
					break;
					
				case 3: // BUSCAR PRODUCTO
					System.out.println("¿Que objeto quieres buscar?");
					String obj_ok = sc.nextLine().toLowerCase();
					
					if(!inventario.containsKey(obj_ok)) {
						System.out.println("Producto no encontrado.");
					} System.out.println(inventario.get(obj_ok));
					
					break;
					
				case 4: // MOSTRAR LISTA DE PRODUCTOS
					for (HashMap.Entry<String, Integer> entry : inventario.entrySet()) {
						obj = entry.getKey();
						cant = entry.getValue();
						
						System.out.println("Producto: " + obj + " Cantidad: " + cant);
						
					}			
					
					break;
					
				case 0:
					salir = true;
					System.out.println("Programa finalizado.");
										
					break;
				
			
			}
		}	
		
		sc.close();
	}

	static public int comprobarEntero(Scanner linea) {
		while (true) {
			String texto = linea.nextLine();
			try {
				return Integer.parseInt(texto);
			} catch (NumberFormatException e) {
				System.out.println("Opción no válida");
			}
		}
	}
	
}
