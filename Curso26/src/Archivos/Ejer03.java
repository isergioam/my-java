package Archivos;

import java.io.*;

public class Ejer03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] nombres = { "Paco", "Juan", "Pepe", "Andres", "María", "Ana", "Sergio" };
		int lineas = 0;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Archivos/Ejer03_nombres.txt", true))) {
			for (int i = 0; i < nombres.length; i++) {
				bw.write(nombres[i]);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/Ejer03_nombres.txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				lineas++;
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Nuestro archivo tiene " + lineas + " lineas.");

	}

}
