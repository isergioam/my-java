package MVC_Almacen;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InventarioVista {

	public void mostrarLista(ArrayList<Producto> productos) {

		//SwingUtilities.invokeLater(() -> {

			DefaultTableModel model = new DefaultTableModel(new Object[] { "Código", "Nombre", "Precio", "Stock" }, 0) {

				@Override
				public boolean isCellEditable(int row, int columnas) {
					return false;
				}

			};
			JTable table = new JTable(model);
			JScrollPane sp = new JScrollPane(table);

			JFrame frame = new JFrame("LISTA DE PRODUCTOS");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(sp);
			frame.setSize(520, 300);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

			for (Producto p : productos) {
				model.addRow(new Object[] { p.getCodigo(), p.getNombre(), p.getPrecio(), p.getStock(), 5, 20 });
			}

		//});
	}

	public void mostrarProducto(Producto p) {
		JOptionPane.showMessageDialog(null,
				"⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥\n ✜ # " + p.getCodigo() + "\n ✜ Nombre: " + p.getNombre() + "\n ✜ Precio: "
						+ p.getPrecio() + "€" + "\n ✜ Stock: " + p.getStock() + "\n⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥",
				"Producto", JOptionPane.CLOSED_OPTION);

	}

	public void msjError(String m) {
		JOptionPane.showMessageDialog(null, m, "Error", JOptionPane.ERROR_MESSAGE);
	}

}
