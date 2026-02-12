package ejercicios;

public class Ejer06 {
	
 /* Usando un bucle "for", calcula la suma de los números del 1 al 10.
     Muestra el resultado.*/

	public static void main(String[] args) {
		
		int sum = 0;
		for(int i=1; i<= 10; i++) {
			sum +=i;
		}
		System.out.println("Contador: " + sum);

	}

}
