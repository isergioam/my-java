package ejercicios;

import java.util.Scanner;

public class Ejer17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String name;
		
		System.out.println("¿Cuál es tu nombre?");
		name = sc.nextLine();
		
		int size = name.length();
		String mayus = name.toUpperCase();
		int first = name.charAt(0);
		
		System.out.println("Tu nombre es: " + mayus);
		System.out.println("Tu nombre tiene " + size + " caracteres.");
		System.out.println("La primera letra de tu nombre es: " + first);
		
		sc.close();
		
		/*String a = "hola";		
		String b = "holo";
		
		String cadena = "         hhooooooooooo hoooo hoooooooooo       ho!!   ";
		String frase = "Me gusta el brocoli";*/
		
		
		/*String nombre = "Ana";
        int edad = 18;
        double nota = 8.456;
        
       String texto = "Hola Mundo Mundo Hola";

        String mensaje = String.format(
            "Alumno: %s | Edad: %d | Nota: %.2f | Descripción: %s",
            nombre, edad, nota, texto.toLowerCase()
        );

        System.out.println(mensaje);*/
		
		/*System.out.println(a==b);
		System.out.println(a.equals(b));
		System.out.println(cadena.trim());
		System.out.println(frase.replace("brocoli", "lomo"));*/
		
		
		
		
	}

}
