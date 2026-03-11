package listacompra.model;

public class ItemCompra {
	private int id;
	private String producto;
	private int cantidad;
	private boolean comprado;

	public ItemCompra(int id, String producto, int cantidad, boolean comprado) {
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.comprado = comprado;
	}
	public ItemCompra(String producto, int cantidad, boolean comprado) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.comprado = comprado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isComprado() {
		return comprado;
	}

	public void setComprado(boolean comprado) {
		this.comprado = comprado;
	}
	


}
