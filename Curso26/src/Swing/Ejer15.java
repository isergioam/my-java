package Swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ejer15 {

	// Ventana principal
	private JFrame frame;

	// Campos del formulario
	private JTextField tfNombre, tfPrecio, tfCantidad;

	// Labels Total
	private JLabel lblTotal;

	// Tabla (vista)
	private JTable table;

	// Modelo (datos de la tabla)
	private DefaultTableModel model;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Ejer15().carrito());
	}

	private void carrito() {
		// ------------------------
		// 1) VENTANA
		// ------------------------
		frame = new JFrame("CARRITO DE LA COMPRA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ------------------------
		// 2) MODELO: los datos
		// ------------------------
		// DefaultTableModel es un TableModel ya hecho.
		// Le damos los nombres de columnas y 0 filas iniciales.
		// A partir de aquí, podremos usar addRow/removeRow/setValueAt.
		model = new DefaultTableModel(new Object[] { "Producto", "Precio", "Cantidad" }, 0) {
			// isCellEditable controla si el usuario puede editar directamente en la tabla.
			// Para aprender CRUD con formulario, desactivamos edición directa:
			// la edición se hace con el botón "Editar".
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// ------------------------
		// 3) TABLA: la vista
		// ------------------------
		// JTable(model): la tabla pinta lo que hay en el modelo.
		table = new JTable(model);

		// Selección: para CRUD básico, lo más claro es seleccionar UNA fila.
		// Así Editar/Borrar trabajan con una única fila y no hay ambigüedad.
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);

		// JScrollPane es el envoltorio estándar para JTable:
		// - cabecera visible
		// - barras de scroll
		JScrollPane sp = new JScrollPane(table);

		// ------------------------
		// 4) FORMULARIO (panel superior)
		// ------------------------
		JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));

		tfNombre = new JTextField();
		tfPrecio = new JTextField();
		tfCantidad = new JTextField();

		form.add(new JLabel("Producto:"));
		form.add(tfNombre);
		form.add(new JLabel("Precio:"));
		form.add(tfPrecio);
		form.add(new JLabel("Cantidad:"));
		form.add(tfCantidad);

		// ------------------------
		// 5) BOTONES
		// ------------------------
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton btnAdd = new JButton("Añadir");
		JButton btnEdit = new JButton("Editar");
		JButton btnDelete = new JButton("Borrar");
		JButton btnClear = new JButton("Limpiar");

		buttons.add(btnAdd);
		buttons.add(btnEdit);
		buttons.add(btnDelete);
		buttons.add(btnClear);

		// ------------------------
		// 6) PANEL NORTH (formulario + separación + botones)
		// ------------------------
		JPanel north = new JPanel();

		// ------------------------
		// 7) PANEL SOUTH (label Total + label suma)
		// ------------------------
		JPanel sur = new JPanel();

		String totalCarro = String.valueOf((5 * 20) + (22) + (2 * 50));

		lblTotal = new JLabel();
		lblTotal.setText(totalCarro);
		sur.add(new JLabel("Total:"));
		sur.add(lblTotal);

		// BoxLayout Y_AXIS apila componentes en vertical:
		// primero el formulario, debajo los botones.
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

		north.add(form);

		// createVerticalStrut(8) crea un hueco invisible de 8px
		// para que el formulario y los botones no queden pegados.
		north.add(Box.createVerticalStrut(8));

		north.add(buttons);

		// ------------------------
		// 8) LAYOUT PRINCIPAL
		// ------------------------
		frame.setLayout(new BorderLayout(10, 10));
		frame.add(north, BorderLayout.NORTH);
		frame.add(sp, BorderLayout.CENTER);
		frame.add(sur, BorderLayout.SOUTH);

		// ------------------------
		// 9) DATOS INICIALES
		// ------------------------
		// addRow(Object[]) añade una fila completa al modelo.
		// Cada fila es un Object[] con tantos elementos como columnas.
		model.addRow(new Object[] { "Tomates", 5, 20 });
		model.addRow(new Object[] { "Platanos", 1, 22 });
		model.addRow(new Object[] { "Lechugas", 2, 50 });

		// ------------------------
		// 10) EVENTOS
		// ------------------------
		btnAdd.addActionListener(e -> addRow());
		btnEdit.addActionListener(e -> editSelectedRow());
		btnDelete.addActionListener(e -> deleteSelectedRow());
		btnClear.addActionListener(e -> clearForm());

		// Cuando seleccionas una fila, copiamos sus datos al formulario.
		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				loadSelectedRowToForm();
			}
		});

		frame.setSize(760, 420);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// =========================================================
	// MÉTODOS DEL CRUD (aquí vive la lógica de control)
	// =========================================================

	private void addRow() {
		// 1) Leemos y validamos el formulario
		String nombre = tfNombre.getText().trim();
		if (nombre.isEmpty()) {
			showError("Producto", "El nombre no puede estar vacío.");
			return;
		}

		Integer precio = parseInt(tfPrecio.getText(), "Precio");
		if (precio == null)
			return;

		Integer cantidad = parseInt(tfCantidad.getText(), "Cantidad");
		if (cantidad == null)
			return;

		// 2) Evitar ID repetido (opcional pero muy didáctico)
		if (existsProduct(nombre)) {
			showError("Producto", "Ya existe un producto con nombre = " + nombre);
			return;
		}

		// 3) Alta: se hace en el MODELO, no en la tabla
		// addRow añade la fila y la tabla se actualiza sola.
		model.addRow(new Object[] { nombre, precio, cantidad });

		String totaldefinitivo = sumaProduct(precio, cantidad);

		lblTotal.setText(totaldefinitivo);

		// 4) Limpiamos la UI para seguir trabajando cómodamente
		clearForm();
	}

	private void editSelectedRow() {
		// 1) Necesitamos una fila seleccionada
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(frame, "Selecciona una fila para editar.");
			return;
		}

		// 2) Leemos y validamos el formulario
		String nombre = tfNombre.getText().trim();
		if (nombre.isEmpty()) {
			showError("Producto", "El nombre del producto no puede estar vacío.");
			return;
		}

		Integer precio = parseInt(tfPrecio.getText(), "Precio");
		Integer cantidad = parseInt(tfCantidad.getText(), "Cantidad");

		if (precio == null || cantidad == null)
			return;

		// 3) Si cambian el ID, evitamos choque con otro alumno
		String currentProduct = (String) model.getValueAt(row, 0);
		if (nombre != currentProduct && existsProduct(nombre)) {
			showError("Producto", "No puedes cambiar el nombre del Producto a uno ya existente: " + nombre);
			return;
		}

		// 4) Edición: setValueAt cambia UNA celda del modelo.
		// (fila row, columna 1 = Nombre)
		model.setValueAt(nombre, row, 0);
		// (fila row, columna 1 = precio)
		model.setValueAt(precio, row, 1);

		// (fila row, columna 2 = cantidad)
		model.setValueAt(cantidad, row, 2);

		String totaldefinitivo = sumaProduct(precio, cantidad);

		lblTotal.setText(totaldefinitivo);

		// 5) Limpieza final (quitar selección, vaciar campos, foco)
		clearForm();
	}

	private void deleteSelectedRow() {
		// 1) Necesitamos una fila seleccionada
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(frame, "Selecciona una fila para borrar.");
			return;
		}

		Integer precio = parseInt(tfPrecio.getText(), "Precio");
		Integer cantidad = parseInt(tfCantidad.getText(), "Cantidad");

		if (precio == null || cantidad == null)
			return;

		// 2) Confirmación (borrar sin preguntar es de villano)
		int opt = JOptionPane.showConfirmDialog(frame, "¿Seguro que quieres borrar la fila seleccionada?",
				"Confirmar borrado", JOptionPane.YES_NO_OPTION);

		if (opt == JOptionPane.YES_OPTION) {
			// 3) Borrado: se hace en el MODELO
			// removeRow elimina la fila y la tabla se actualiza sola.
			model.removeRow(row);

			String totaldefinitivo = sumaProduct(precio, cantidad);

			lblTotal.setText(totaldefinitivo);

			// 4) Limpiamos el formulario
			clearForm();
		}
	}

	private void loadSelectedRowToForm() {
		// Si no hay selección, no hacemos nada
		int row = table.getSelectedRow();
		if (row == -1)
			return;

		// Copiamos valores del modelo al formulario
		tfNombre.setText(String.valueOf(model.getValueAt(row, 0)));
		tfPrecio.setText(String.valueOf(model.getValueAt(row, 1)));
		tfCantidad.setText(String.valueOf(model.getValueAt(row, 2)));
	}

	// =========================================================
	// MÉTODO CLAVE: clearForm() (NO es Swing, es nuestro)
	// =========================================================

	private void clearForm() {
		// Vaciar campos
		tfNombre.setText("");
		tfPrecio.setText("");
		tfCantidad.setText("");

		// Quitar selección de la tabla (si la dejamos, confunde)
		table.clearSelection();

		// Devolver el foco al primer campo
		tfNombre.requestFocus();
	}

	// =========================================================
	// UTILIDADES DE VALIDACIÓN
	// =========================================================

	private Integer parseInt(String text, String field) {
		String t = text.trim();
		if (t.isEmpty()) {
			showError(field, "El campo está vacío.");
			return null;
		}
		try {
			return Integer.parseInt(t);
		} catch (NumberFormatException ex) {
			showError(field, "Debe ser un número entero.");
			return null;
		}
	}

	private boolean existsProduct(String nombre) {
		for (int r = 0; r < model.getRowCount(); r++) {
			String existing = (String) model.getValueAt(r, 0);
			if (existing == nombre)
				return true;
		}
		return false;
	}

	private String sumaProduct(int precio, int cantidad) {
		int total = 0;
		String txt_total;

		for (int r = 0; r < model.getRowCount(); r++) {
			precio = (int) model.getValueAt(r, 1);
			cantidad = (int) model.getValueAt(r, 2);

			total += precio * cantidad;

		}

		txt_total = String.valueOf(total);

		return txt_total;
	}

	private void showError(String field, String msg) {
		JOptionPane.showMessageDialog(frame, msg, "Error en " + field, JOptionPane.ERROR_MESSAGE);
	}
}
