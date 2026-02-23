package Ejercicios;

import java.util.Scanner;
import java.util.HashMap;

public class Ejer49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> taquilla = new HashMap<>();
		boolean salir = false;
		String dni = "";
		String asiento = "";

		while (!salir) {
			System.out.println("|| 1 RESERVAR || 2 CONSULTAR RESERVA || 3 CANCELAR RESERVA || 4 LISTA || 0 SALIR ||");

			int num = comprobarEntero(sc);

			switch (num) {
			case 1: // HACER RESERVA
				System.out.println("Ingresa su DNI: ");
				dni = sc.nextLine();
				System.out.println("¿Cual va ser su asiento?");
				asiento = sc.nextLine();

				if (taquilla.containsKey(dni) || taquilla.containsValue(asiento)) {
					System.out.println("ERROR. DNI usado o asiento reservado.");
				}
				taquilla.put(dni, asiento);

				break;

			case 2: // CONSULTAR RESERVA
				do {
					System.out.println("Ingresa su DNI: ");
					dni = sc.nextLine();

				} while (dni.isEmpty() || asiento.isEmpty());

				if (!taquilla.containsKey(dni)) {
					System.out.println("DNI no encontrado.");
				}
				System.out.println("Tiene reservada la butaca: " + taquilla.get(dni));

				break;

			case 3: // ELIMINAR RESERVA
				System.out.println("Ingresa su DNI: ");
				dni = sc.nextLine();
				if (!taquilla.containsKey(dni)) {
					System.out.println("DNI no encontrado.");
				}
				System.out.println("Reserva " + dni + " cancelada.");
				taquilla.remove(dni);

				break;

			case 4: // MOSTRAR LISTADO DE RESERVAS
				if (taquilla.isEmpty()) {
					System.out.println("La taquilla está vacía.");
					
				} else {
					for (HashMap.Entry<String, String> entry : taquilla.entrySet()) {
						dni = entry.getKey();
						asiento = entry.getValue();
						System.out.println("DNI: " + dni + "-- Asiento: " + asiento);
					}

				}

				break;

			case 0: // SALIR DEL PROGRAMA
				System.out.println("Programa finalizado.");
				salir = true;

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
