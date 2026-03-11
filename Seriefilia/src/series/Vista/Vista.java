package series.Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Vista {

    private JPanel panelPrincipal;

    private JTextField tfId;
    private JTextField tfTitulo;
    private JTextField tfCapitulo;
    private JTextField tfTemporada;
    private JTextField tfValoracion;
    

    private JButton btnInsertar;
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JButton btnBorrar;
    private JButton btnListar;
    private JButton btnLimpiar;

    private JTable tabla;
    private DefaultTableModel model;

    public Vista() {
        panelPrincipal = new JPanel(new BorderLayout());

        // Panel formulario
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createTitledBorder("Datos de la serie"));
        
        tfId = new JTextField();
        tfTitulo = new JTextField();
        tfCapitulo = new JTextField();
        tfTemporada = new JTextField();
        tfValoracion = new JTextField();

        panelForm.add(new JLabel("ID:"));
        panelForm.add(tfId);
        panelForm.add(new JLabel("Título:"));
        panelForm.add(tfTitulo);
        panelForm.add(new JLabel("Capítulo:"));
        panelForm.add(tfCapitulo);
        panelForm.add(new JLabel("Temporada:"));
        panelForm.add(tfTemporada);
        panelForm.add(new JLabel("Valoración:"));
        panelForm.add(tfValoracion);

        // Panel botones
        JPanel panelBotones = new JPanel(new FlowLayout());

        btnInsertar = new JButton("Añadir");
        btnBorrar = new JButton("Borrar");
        btnActualizar = new JButton("Editar");        
        btnListar = new JButton("Mostrar");
        btnLimpiar = new JButton("Vacíar");
        btnBuscar = new JButton("Buscar");

        panelBotones.add(btnInsertar);
        panelBotones.add(btnBorrar);
        panelBotones.add(btnActualizar);        
        panelBotones.add(btnListar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnBuscar);

        // Tabla
        model = new DefaultTableModel(new Object[]{"ID", "Titulo", "Capitulo", "Temporada", "Valoracion"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Listado de series"));

        // Panel superior
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelForm, BorderLayout.CENTER);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public JTextField getTfId() {
        return tfId;
    }

    public JTextField getTfTitulo() {
        return tfTitulo;
    }

    public JTextField getTfCapitulo() {
        return tfCapitulo;
    }

    public JTextField getTfTemporada() {
        return tfTemporada;
    }
    
    public JTextField getTfValoracion() {
    	return tfValoracion;
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

    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(panelPrincipal, mensaje);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(panelPrincipal, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void limpiarFormulario() {
        tfId.setText("");
        tfTitulo.setText("");
        tfCapitulo.setText("");
        tfTemporada.setText("");
        tfValoracion.setText("");
        tfId.requestFocus();
    }
}
