package ejercicios;

public class Ejer38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String objetos[] = {"Poción", "Mapa", "Llave", "Moneda", "Antorcha"};
		int pesos[] = {2,1,1,1,3};
		
		int pesoMax = 5;		
		int peso = 0;
		
		System.out.println("Objeto de la mochila (Poción, Mapa, Llave, Moneda, Antorcha)");
		
		/*String objeto = sc.nextLine().toLowerCase();*/
		
		for(int i = 0; i < objetos.length; i++) {
			peso += pesos[i];
			
			if(peso + pesos[i] <= pesoMax) {
				
				System.out.println("- " + objetos[i] + " (+" + pesos[i] + ")");
			}
					
		}
		
		System.out.println("Peso total: " + peso + "/" + pesoMax);
		
	}

}
