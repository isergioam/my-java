package POO;

import java.util.ArrayList;

class Item {
	String nombre;
	double precio;
	int cantidad;

	Item(String nombre, double precio, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public double subtotal() {
		return this.precio * this.cantidad;
	}
	
	@Override
	public String toString() {
		return
				"///////////////////////////////\n- Producto: " + this.nombre + "\n- Cantidad: " + this.cantidad + "\n- Precio: " + this.precio +" €\n///////////////////////////////";
	}

}

class Carrito {

	ArrayList<Item> objetos = new ArrayList<>();

	public void agregar(String nombre, double precio, int cantidad) {
		for (Item item : objetos) {
			if (item.nombre.equals(nombre)) {
				item.cantidad = item.cantidad + cantidad;

				return;
			}
		}

		objetos.add(new Item(nombre, precio, cantidad));

	}

	public void eliminar(String nombre) {
		for (Item item : objetos) {

			if (item.nombre.equals(nombre)) {
				objetos.remove(item);
				return;
			}
		}
		System.out.println("Eso no está en el carro");
	}

	public double total() {

		double t = 0;
		for (Item item : objetos) {
		
			t += item.subtotal();
		}
		return t;

	}

	public void mostrar() {
		for (Item item : objetos) {
			System.out.println(item);
		}

	}

}

public class Ejer025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Carrito c = new Carrito();
		c.agregar("Paco", 1, 1);
		c.agregar("Paco", 1, 1);
		c.agregar("Paco", 1, 10);
		c.agregar("Pepe", 10, 10);
		c.agregar("Juan", 30, 20);
		c.total();
		c.mostrar();		
		c.eliminar("Paco");
		c.mostrar();
	}

}
