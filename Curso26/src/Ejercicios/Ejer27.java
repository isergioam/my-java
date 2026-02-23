package Ejercicios;

public class Ejer27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a,b,c = "";
		
		a = tiraMaquina();
		b = tiraMaquina();
		c = tiraMaquina();
		
		System.out.println(a + " " + b + " " + c);

		
		if(a.equals(b)&& b.equals(c)) {
			System.out.println("Ding ding ding ding 10 monedas de premio");
		}
		else if(a.equals(b)||b.equals(c)|| c.equals(a)) {
			System.out.println("Ding Tira otra vez");
		}
		else {
			System.out.println("Tienes el calino encima");
		}	

	}
	
	public static String tiraMaquina() {
		int aleatorio = (int)(Math.random()*5) + 1;
		String simbolo = "";
		
		
		switch(aleatorio) {
			case 1: simbolo = "corazón"; break;
			case 2: simbolo = "diamante"; break;
			case 3: simbolo = "herradura"; break;
			case 4: simbolo = "campana"; break;
			case 5: simbolo = "limón"; break;
			
		} return simbolo;
		
		
	}

}
