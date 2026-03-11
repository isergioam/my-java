package listacompra.controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import listacompra.DAO.ItemCompraDAO;
import listacompra.model.ItemCompra;
import listacompra.view.ListaCompraView;

public class ListaCompraController {

	private ItemCompraDAO dao;
	private ListaCompraView view;

	public ListaCompraController(ItemCompraDAO dao, ListaCompraView view) {
		this.dao = dao;
		this.view = view;
		
		iniciarEventos();
		listarItems();
		
	}
	
	private void iniciarEventos() {
		view.getBtnInsertar().addActionListener(e -> insertarItem());
		view.getBtnBorrar().addActionListener(e -> borrarItem());
		view.getBtnListar().addActionListener(e -> listarItems());
		
		view.getTable().getSelectionModel().addListSelectionListener(e -> cargarFilaSeleccionada());
	}
	
	private void insertarItem() {
		//int id = Integer.parseInt(view.getTfId().getText().trim());
		String producto = view.getTfProducto().getText().trim();
		int cantidad = Integer.parseInt(view.getTfCantidad().getText().trim());
		boolean comprado = view.getChkComprado().isSelected();
		
		if(producto.isEmpty()) {
			System.out.println("El producto no puede estar vacío");
			return;
		}
		
		ItemCompra item = new ItemCompra(producto, cantidad, comprado);
		
		if(dao.insertarCompra(item)) {
			System.out.println("Producto insertado correctamente");
			listarItems();
		}
	}
	
	private void borrarItem() {
		try {
			int id = Integer.parseInt(view.getTfId().getText().trim());
			
			if(dao.borrarCompra(id)) {
				System.out.println("Producto borrado correctamente");
			}
			
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	
    private void listarItems() {
        ArrayList<ItemCompra> lista = dao.listarCompra();
        DefaultTableModel model = view.getModel();
        model.setRowCount(0);

        for (ItemCompra item : lista) {
            model.addRow(new Object[]{
            		item.getId(),
                    item.getProducto(),
                    item.getCantidad(),
                    item.isComprado()
            });
        }
    }
    
    private void cargarFilaSeleccionada() {
    	int fila = view.getTable().getSelectedRow();
    	
    	if(fila != 1) {
    		view.getTfId().setText(view.getModel().getValueAt(fila, 0).toString());
    		view.getTfProducto().setText(view.getModel().getValueAt(fila, 1).toString());
    		view.getTfCantidad().setText(view.getModel().getValueAt(fila, 2).toString());
    		view.getChkComprado().setSelected(Boolean.parseBoolean(view.getModel().getValueAt(fila, 3).toString()));
    	}
    }
    

}
