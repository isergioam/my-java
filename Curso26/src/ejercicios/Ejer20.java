package ejercicios;

public class Ejer20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double precio = 89.99;
		double iva = calcularIVA(precio);
		
		System.out.println("Precio:" + precio + "€");
		System.out.println("IVA:" + calcularIVA(precio) + "%" );
		System.out.println("Total:" + (precio + iva) + "€");
		

	}
	
	public static double calcularIVA(double precio) {		
		return precio *0.21;
		
	}

}
