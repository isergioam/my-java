package listacompra.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ListaCompraView {
	
	private JPanel panelPrincipal;	

	private JFrame frame;
	private JTextField tfId, tfProducto, tfCantidad;
	private JCheckBox chkComprado;

	private JButton btnInsertar, btnBuscar, btnActualizar, btnBorrar, btnListar, btnLimpiar;

	private JTable table;
	private DefaultTableModel model;

	public ListaCompraView() {
		//SwingUtilities.invokeLater(() -> new ListaCompraView().start());
	//}

	//private void start() {
		// ------------------------
		// 1) VENTANA
		// -----------------------		
		frame = new JFrame("CARRITO DE LA COMPRA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ------------------------
		// 2) MODELO: los datos
		// ------------------------
		model = new DefaultTableModel(new Object[] { "ID", "Producto", "Cantidad", "Comprado" }, 0) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// ------------------------
		// 3) TABLA: la vista
		// ------------------------
		table = new JTable(model);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);

		JScrollPane sp = new JScrollPane(table);

		// ------------------------
		// 4) FORMULARIO (panel superior)
		// ------------------------
		panelPrincipal = new JPanel(new BorderLayout());
		
		JPanel form = new JPanel(new GridLayout(4, 2, 8, 8));

		tfId = new JTextField();
		tfProducto = new JTextField();
		tfCantidad = new JTextField();
		chkComprado = new JCheckBox();

		form.add(new JLabel("ID:"));
		form.add(tfId);
		form.add(new JLabel("Producto:"));
		form.add(tfProducto);
		form.add(new JLabel("Cantidad:"));
		form.add(tfCantidad);
		form.add(new JLabel("Comprado:"));
		form.add(chkComprado);

		// ------------------------
		// 5) BOTONES
		// ------------------------
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnInsertar = new JButton("Añadir");
		btnBuscar = new JButton("Buscar");
		btnActualizar = new JButton("Actualizar");
		btnBorrar = new JButton("Borrar");
		btnListar = new JButton("Listar");
		btnLimpiar = new JButton("Limpiar");

		buttons.add(btnInsertar);
		buttons.add(btnBuscar);
		buttons.add(btnActualizar);
		buttons.add(btnBorrar);		
		buttons.add(btnListar);
		buttons.add(btnLimpiar);

		// ------------------------
		// 6) PANEL NORTH (formulario + separación + botones)
		// ------------------------
		JPanel north = new JPanel();

		// ------------------------
		// 7) PANEL SOUTH (label Total + label suma)
		// ------------------------
		JPanel sur = new JPanel();

		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

		north.add(form);

		north.add(Box.createVerticalStrut(8));

		north.add(buttons);

		// ------------------------
		// 8) LAYOUT PRINCIPAL
		// ------------------------
		frame.setLayout(new BorderLayout(10, 10));
		panelPrincipal.add(north, BorderLayout.NORTH);
		panelPrincipal.add(sp, BorderLayout.CENTER);
		panelPrincipal.add(sur, BorderLayout.SOUTH);

		//DATOS INICIALES
		//model.addRow(new Object[] { 1, "Tomates", 20, 2 });
		
		// ------------------------
		// 10) EVENTOS
		// ------------------------
		
		//btnInsertar.addActionListener(e -> ItemCompraDAO.insertarCompra());
		//btnEdit.addActionListener(e -> editSelectedRow());
		//btnBorrar.addActionListener(e -> ItemCompraDAO.borrarCompra(tfId));
		//btnClear.addActionListener(e -> clearForm());

		// Cuando seleccionas una fila, copiamos sus datos al formulario.
	/*	table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				loadSelectedRowToForm();
			}
		});*/

		/*frame.setSize(760, 420);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);*/
		
		

	}
	
	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTfId() {
		return tfId;
	}

	public JTextField getTfProducto() {
		return tfProducto;
	}

	public JTextField getTfCantidad() {
		return tfCantidad;
	}

	public JCheckBox getChkComprado() {
		return chkComprado;
	}

	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}
	
	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnListar() {
		return btnListar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModel() {
		return model;
	}
}
