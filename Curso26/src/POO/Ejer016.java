package POO;

class Cuenta {
	double saldo;
	
	public void ingresar(double cant) {
		this.saldo = this.saldo + cant;
	}
	
	public void retirar(double cant) {
		this.saldo = this.saldo - cant;
	}
}

class CuentaAhorro extends Cuenta{
	public void aplicarInteres() {
		this.saldo += (this.saldo * 0.02);
	}
}

public class Ejer016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CuentaAhorro ca = new CuentaAhorro();
		ca.ingresar(50);
		System.out.println("Saldo Actual: " + ca.saldo + "€");
		
		ca.retirar(25);
		System.out.println("Saldo Actual: " + ca.saldo + "€");		
		
		ca.aplicarInteres();
		System.out.println("Saldo Actual: " + ca.saldo + "€");
	}

}
