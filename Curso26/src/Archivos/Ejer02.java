package Archivos;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;

public class Ejer02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	
		File f = new File("src/Archivos/saludo.txt");
		
		try {
			f.createNewFile();
			System.out.println("Fichero creado satisfactoriamente.");
			
		} catch (IOException e) {
			System.out.println("No se pudo crear el archivo: " + e.getMessage());
		}
		
*/
		
		File ruta = new File("src/Archivos/.").getAbsoluteFile();
		System.out.println("La ruta del archivo es: " + ruta);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Archivos/Ejer02_saludo.txt"))) {
			
			bw.write("Hola");
			bw.newLine();
			bw.write("Paco");
			bw.newLine();
			bw.write("¿Que tal?");
			bw.newLine();

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/Ejer02_saludo.txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
