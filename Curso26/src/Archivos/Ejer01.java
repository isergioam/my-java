package Archivos;

import java.util.Scanner;
/*import java.io.File;*/
import java.io.FileWriter;
import java.io.IOException;

public class Ejer01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el texto:");

		String txt = sc.nextLine();

		/*File archivo = new File("src/Archivos/log.txt");

		try {

			boolean creado = archivo.createNewFile();
			System.out.println("Archivo creado: " + creado);
		} catch (IOException e) {
			System.out.println("No se pudo crear el archivo: " + e.getMessage());
		}*/

		try (FileWriter fw = new FileWriter("src/Archivos/Ejer01_log.txt", true)) {
			fw.write(txt);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Entrada añadida al log.txt");

		sc.close();
		
	}

}
