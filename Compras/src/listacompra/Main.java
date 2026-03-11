package listacompra;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import listacompra.DAO.ItemCompraDAO;
import listacompra.controller.ListaCompraController;
import listacompra.view.ListaCompraView;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ItemCompraDAO dao = new ItemCompraDAO();
            ListaCompraView view = new ListaCompraView();
            new ListaCompraController(dao, view);

            JFrame ventana = new JFrame("CRUD Lista de la Compra");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setContentPane(view.getPanelPrincipal());
            ventana.setSize(800, 500);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
