package MVC;

public class Ej01_Vista {
	// mostrar persona
	public void mostrarPersona(String nombre, String apellidos, int edad) {
		System.out.println("⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥");		 
		System.out.println("✜ Nombre: " + nombre + "\n✜ Apellidos: " + apellidos + "\n✜ Edad: " + edad);
		System.out.println("⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥");	
	}
	
	public void error(String mensaje) {
		System.out.println(mensaje);
	}
}
