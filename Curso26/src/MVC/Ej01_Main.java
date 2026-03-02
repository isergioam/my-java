package MVC;

public class Ej01_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Ej01_Modelo modelo = new Ej01_Modelo("Paco Imperator","Es el mejor", 57);
        Ej01_Vista vista = new Ej01_Vista();
        Ej01_Controlador controlador = new Ej01_Controlador(modelo, vista);
        controlador.actualizarVista();

	}

}
