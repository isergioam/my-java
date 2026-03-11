package series.Controlador;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import series.DAO.DAO;
import series.Modelo.Modelo;
import series.Vista.Vista;

public class Controlador {

	private DAO dao;
	private Vista view;

	public Controlador(DAO dao, Vista view) {
		this.dao = dao;
		this.view = view;

		iniciarEventos();
		listarItems();

	}

	private void iniciarEventos() {
		view.getBtnInsertar().addActionListener(e -> insertarItem());
		view.getBtnBorrar().addActionListener(e -> borrarItem());

		view.getBtnActualizar().addActionListener(e -> actualizarItem());

		view.getBtnLimpiar().addActionListener(e -> view.limpiarFormulario());

		view.getBtnListar().addActionListener(e -> listarItems());

		view.getBtnBuscar().addActionListener(e -> buscarItem());

		view.getTabla().getSelectionModel().addListSelectionListener(e -> cargarFilaSeleccionada());
	}

	private void insertarItem() {
		String titulo = view.getTfTitulo().getText().trim();
		int capitulo = Integer.parseInt(view.getTfCapitulo().getText().trim());
		int temporada = Integer.parseInt(view.getTfTemporada().getText().trim());
		int valoracion = Integer.parseInt(view.getTfValoracion().getText().trim());

		if (titulo.isEmpty()) {
			System.out.println("El producto no puede estar vacío");
			return;
		}

		Modelo item = new Modelo(titulo, capitulo, temporada, valoracion);

		if (DAO.insertar(item)) {
			System.out.println("Producto insertado correctamente");
			listarItems();
		}
	}

	private void borrarItem() {
		try {
			int id = Integer.parseInt(view.getTfId().getText().trim());

			if (dao.borrar(id)) {
				System.out.println("Producto borrado correctamente");
			}

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void actualizarItem() {
		String titulo = view.getTfTitulo().getText().trim();
		int capitulo = Integer.parseInt(view.getTfCapitulo().getText().trim());
		int temporada = Integer.parseInt(view.getTfTemporada().getText().trim());
		int valoracion = Integer.parseInt(view.getTfValoracion().getText().trim());

		if (titulo.isEmpty()) {
			System.out.println("El producto no puede estar vacío");
			return;
		}

		Modelo item = new Modelo(titulo, capitulo, temporada, valoracion);

		if (DAO.actualizar(item)) {
			System.out.println("Producto insertado correctamente");
			listarItems();
		}
	}
	
	private void buscarItem() {
		int id = Integer.parseInt(view.getTfId().getText().trim());

		Modelo item = DAO.buscar(id);
		
		if (item != null) {
			System.out.println("El titulo no puede estar vacío");
			return;
		}

		if (DAO.insertar(item)) {
			System.out.println("Serie insertado correctamente");
			listarItems();
		}
	}

	private void listarItems() {
		ArrayList<Modelo> lista = DAO.listarSeries();
		DefaultTableModel model = view.getModel();
		model.setRowCount(0);

		for (Modelo item : lista) {
			model.addRow(new Object[] { item.getId(), item.getTitulo(), item.getCapitulo(), item.getTemporada(),
					item.getValoracion() });
		}
	}

	private void cargarFilaSeleccionada() {
		int fila = view.getTabla().getSelectedRow();

		if (fila != -1) {
			view.getTfId().setText(view.getModel().getValueAt(fila, 0).toString());
			view.getTfTitulo().setText(view.getModel().getValueAt(fila, 1).toString());
			view.getTfCapitulo().setText(view.getModel().getValueAt(fila, 2).toString());
			view.getTfTemporada().setText(view.getModel().getValueAt(fila, 3).toString());
			view.getTfValoracion().setText(view.getModel().getValueAt(fila, 4).toString());
		}
	}

}
