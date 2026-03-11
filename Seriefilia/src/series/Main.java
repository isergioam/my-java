package series;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import series.Controlador.Controlador;
import series.DAO.DAO;
import series.Vista.Vista;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DAO dao = new DAO();
            Vista view = new Vista();
            new Controlador(dao, view);

            JFrame ventana = new JFrame("CRUD Lista de la Compra");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setContentPane(view.getPanelPrincipal());
            ventana.setSize(800, 500);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }

}
