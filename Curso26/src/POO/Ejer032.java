package POO;

class Boton {
	String texto;
	int clicks;
	static int clicksTotales;

	public void click() {
		clicks++;
		clicksTotales++;
	}
}

public class Ejer032 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Boton b1 = new Boton();
		b1.texto = "1";
		b1.click();
		b1.click();
		b1.click();
		b1.click();
		b1.click();
		b1.click();
		b1.click();
		b1.click();
		b1.click();
		b1.click();
		b1.click();
		b1.click();

		Boton b2 = new Boton();
		b2.texto = "2";
		b2.click();
		b2.click();
		b2.click();
		b2.click();
		
		Boton b3 = new Boton();
		b3.texto = "3";
		b3.click();
		b3.click();
		b3.click();
		
		Boton b4 = new Boton();
		b4.texto = "4";
		b4.click();
		b4.click();
		b4.click();
		b4.click();
		b4.click();
		b4.click();

		System.out.println("Número total de clicks del Botón " + b1.texto + ": " + b1.clicks);
		System.out.println("Número total de clicks del Botón " + b2.texto + ": " + b2.clicks);
		System.out.println("Número total de clicks del Botón " + b3.texto + ": " + b3.clicks);
		System.out.println("Número total de clicks del Botón " + b4.texto + ": " + b4.clicks);
		System.out.println("Número total de clicks: " + Boton.clicksTotales);

	}

}
