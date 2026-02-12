package Clases;

public class Ejer005c {

	private String nombre;
	private double precio;
	private int stock;

	public Ejer005c(String nombre, double precio, int stock) {
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setStock(stock);

		/*
		 * this.nombre = nombre; this.precio = precio; this.stock = stock;
		 * 
		 * if(precio < 0) { System.out.println("Cantidad Erronea."); } else {
		 * this.precio = precio; }
		 * 
		 * if(stock < 0) { System.out.println("Stock insuficiente"); } else { this.stock
		 * = stock; }
		 */

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio < 0) {
			System.out.println("Cantidad Erronea");
		} else {
			this.precio = precio;
		}
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock < 0) {
			System.out.println("Stock insuficiente");
		} else {
			this.stock = stock;
		}
	}

}
