package MVC;

public class Ej01_Controlador {
	private Ej01_Modelo modelo;
	private Ej01_Vista vista;

	public Ej01_Controlador(Ej01_Modelo modelo, Ej01_Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	public void actualizarVista() {
		String nombre = modelo.getNombre();
		String apellidos = modelo.getApellidos();
		int edad = modelo.getEdad();
		
		if(nombre.length() < 3 || apellidos.length() < 3) {
			vista.error("El nombre o apellidos deben tener más de 3 caracteres.");
			return;

		}	
			
		if (edad < 0) {
			vista.error("El número debe ser positivo");
			return;
		} 
			vista.mostrarPersona(nombre, apellidos, edad);



	}
}
