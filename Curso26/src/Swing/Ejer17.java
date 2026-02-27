package Swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ejer17 {

    // Ventana principal
    private JFrame frame;

    // Campos del formulario
    private JTextField tfCodigo, tfTitulo, tfCurso, tfDias;
    private JCheckBox chkPrestado;

    // Indicadores
    private JTextField tfTotalLibros, tfTotalPrestados, tfTotalDias;

    // Tabla (vista)
    private JTable table;

    // Modelo (datos)
    private DefaultTableModel model;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ignored) {}

            new Ejer17().start();
        });
    }

    private void start() {

        // ------------------------
        //  1) VENTANA
        // ------------------------
        frame = new JFrame("Biblioteca escolar (préstamos rápidos)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ------------------------
        //  2) MODELO
        // ------------------------
        model = new DefaultTableModel(
                new Object[]{"Código", "Título", "Curso", "Prestado", "Días de préstamo"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // ------------------------
        //  3) TABLA
        // ------------------------
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);

        JScrollPane sp = new JScrollPane(table);

        // ------------------------
        //  4) FORMULARIO (panel superior)
        // ------------------------
        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));

        tfCodigo = new JTextField();
        tfTitulo = new JTextField();
        tfCurso  = new JTextField();
        chkPrestado = new JCheckBox("Sí");
        tfDias   = new JTextField();

        form.add(new JLabel("Código:"));
        form.add(tfCodigo);

        form.add(new JLabel("Título:"));
        form.add(tfTitulo);

        form.add(new JLabel("Curso:"));
        form.add(tfCurso);

        form.add(new JLabel("Prestado:"));
        form.add(chkPrestado);

        form.add(new JLabel("Días de préstamo:"));
        form.add(tfDias);

        // ------------------------
        //  5) BOTONES
        // ------------------------
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton btnAdd = new JButton("Añadir");
        JButton btnEdit = new JButton("Editar");
        JButton btnDelete = new JButton("Borrar");
        JButton btnClear = new JButton("Limpiar");
        JButton btnToggle = new JButton("Alternar Prestado");
        JButton btnPlusDay = new JButton("+1 Día");

        buttons.add(btnAdd);
        buttons.add(btnEdit);
        buttons.add(btnDelete);
        buttons.add(btnClear);
        buttons.add(btnToggle);
        buttons.add(btnPlusDay);

        // ------------------------
        //  6) PANEL NORTH (form + separación + botones)
        // ------------------------
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(form);
        north.add(Box.createVerticalStrut(8));
        north.add(buttons);

        // ------------------------
        //  7) PANEL SOUTH (indicadores)
        // ------------------------
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        south.add(new JLabel("Total libros:"));
        tfTotalLibros = new JTextField(5);
        tfTotalLibros.setEnabled(false);
        south.add(tfTotalLibros);

        south.add(new JLabel("Total prestados:"));
        tfTotalPrestados = new JTextField(5);
        tfTotalPrestados.setEnabled(false);
        south.add(tfTotalPrestados);

        south.add(new JLabel("Total días acumulados:"));
        tfTotalDias = new JTextField(6);
        tfTotalDias.setEnabled(false);
        south.add(tfTotalDias);

        // ------------------------
        //  8) LAYOUT PRINCIPAL
        // ------------------------
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(north, BorderLayout.NORTH);
        frame.add(sp, BorderLayout.CENTER);
        frame.add(south, BorderLayout.SOUTH);

        north.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        sp.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // ------------------------
        //  9) INDICADORES INICIALES
        // ------------------------
        actualizarIndicadores();

        // ------------------------
        //  10) EVENTOS
        // ------------------------
        btnAdd.addActionListener(e -> addRow());
        btnEdit.addActionListener(e -> editSelectedRow());
        btnDelete.addActionListener(e -> deleteSelectedRow());
        btnClear.addActionListener(e -> clearForm());
        btnToggle.addActionListener(e -> alternarPrestado());
        btnPlusDay.addActionListener(e -> masUnDia());

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadSelectedRowToForm();
            }
        });

        frame.setSize(860, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // =========================================================
    //  MÉTODOS CRUD
    // =========================================================

    private void addRow() {
        Integer codigo = parseInt(tfCodigo.getText(), "Código");
        if (codigo == null) return;

        String titulo = tfTitulo.getText().trim();
        if (titulo.isEmpty()) {
            showError("Título", "El título no puede estar vacío.");
            return;
        }

        String curso = tfCurso.getText().trim();
        if (curso.isEmpty()) {
            showError("Curso", "El curso no puede estar vacío (ej: 1ºDAW).");
            return;
        }

        Integer dias = parseInt(tfDias.getText(), "Días de préstamo");
        if (dias == null) return;
        if (dias < 0) {
            showError("Días de préstamo", "Los días no pueden ser negativos.");
            return;
        }

        boolean prestado = chkPrestado.isSelected();

        model.addRow(new Object[]{codigo, titulo, curso, prestado, dias});

        actualizarIndicadores();
        clearForm();
    }

    private void editSelectedRow() {
        int viewRow = table.getSelectedRow();
        int row = table.convertRowIndexToModel(viewRow);

        if (row == -1) {
            JOptionPane.showMessageDialog(frame, "Selecciona una fila para editar.");
            return;
        }

        Integer codigo = parseInt(tfCodigo.getText(), "Código");
        if (codigo == null) return;

        String titulo = tfTitulo.getText().trim();
        if (titulo.isEmpty()) {
            showError("Título", "El título no puede estar vacío.");
            return;
        }

        String curso = tfCurso.getText().trim();
        if (curso.isEmpty()) {
            showError("Curso", "El curso no puede estar vacío (ej: 1ºDAW).");
            return;
        }

        Integer dias = parseInt(tfDias.getText(), "Días de préstamo");
        if (dias == null) return;
        if (dias < 0) {
            showError("Días de préstamo", "Los días no pueden ser negativos.");
            return;
        }

        boolean prestado = chkPrestado.isSelected();

        model.setValueAt(codigo, row, 0);
        model.setValueAt(titulo, row, 1);
        model.setValueAt(curso, row, 2);
        model.setValueAt(prestado, row, 3);
        model.setValueAt(dias, row, 4);

        actualizarIndicadores();
        clearForm();
    }

    private void deleteSelectedRow() {
        int viewRow = table.getSelectedRow();
        int row = table.convertRowIndexToModel(viewRow);

        if (row == -1) {
            JOptionPane.showMessageDialog(frame, "Selecciona una fila para borrar.");
            return;
        }

        int opt = JOptionPane.showConfirmDialog(
                frame,
                "¿Seguro que quieres borrar el préstamo seleccionado?",
                "Confirmar borrado",
                JOptionPane.YES_NO_OPTION
        );

        if (opt == JOptionPane.YES_OPTION) {
            model.removeRow(row);
            actualizarIndicadores();
            clearForm();
        }
    }

    private void loadSelectedRowToForm() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        int rowModel = table.convertRowIndexToModel(row);

        tfCodigo.setText(String.valueOf(model.getValueAt(rowModel, 0)));
        tfTitulo.setText(String.valueOf(model.getValueAt(rowModel, 1)));
        tfCurso.setText(String.valueOf(model.getValueAt(rowModel, 2)));

        Boolean prestadoObj = (Boolean) model.getValueAt(rowModel, 3);
        chkPrestado.setSelected(prestadoObj != null && prestadoObj);

        tfDias.setText(String.valueOf(model.getValueAt(rowModel, 4)));
    }

    // =========================================================
    //  ACCIONES EXTRA
    // =========================================================

    private void alternarPrestado() {
        int viewRow = table.getSelectedRow();
        if (viewRow == -1) {
            JOptionPane.showMessageDialog(frame, "Selecciona un libro en la tabla.");
            return;
        }

        int row = table.convertRowIndexToModel(viewRow);

        Boolean prestadoObj = (Boolean) model.getValueAt(row, 3);
        boolean prestadoActual = (prestadoObj != null) ? prestadoObj : false;

        boolean prestadoNuevo = !prestadoActual;
        model.setValueAt(prestadoNuevo, row, 3);

        chkPrestado.setSelected(prestadoNuevo);

        actualizarIndicadores();
    }

    private void masUnDia() {
        int viewRow = table.getSelectedRow();
        if (viewRow == -1) {
            JOptionPane.showMessageDialog(frame, "Selecciona un libro en la tabla.");
            return;
        }

        int row = table.convertRowIndexToModel(viewRow);

        Integer diasObj = (Integer) model.getValueAt(row, 4);
        int diasActual = (diasObj != null) ? diasObj : 0;

        diasActual++;

        model.setValueAt(diasActual, row, 4);
        tfDias.setText(String.valueOf(diasActual));

        actualizarIndicadores();
    }

    // =========================================================
    //  INDICADORES (cálculos)
    // =========================================================

    private void actualizarIndicadores() {
        int totalLibros = calculaTotalLibros(model);
        int totalPrestados = calculaTotalPrestados(model);
        int totalDias = calculaTotalDias(model);

        tfTotalLibros.setText(String.valueOf(totalLibros));
        tfTotalPrestados.setText(String.valueOf(totalPrestados));
        tfTotalDias.setText(String.valueOf(totalDias));
    }

    public static int calculaTotalLibros(DefaultTableModel model) {
        return model.getRowCount();
    }

    public static int calculaTotalPrestados(DefaultTableModel model) {
        int total = 0;
        for (int row = 0; row < model.getRowCount(); row++) {
            Object p = model.getValueAt(row, 3);
            boolean prestado = Boolean.TRUE.equals(p);
            if (prestado) total++;
        }
        return total;
    }

    public static int calculaTotalDias(DefaultTableModel model) {
        int total = 0;
        for (int row = 0; row < model.getRowCount(); row++) {
            Object d = model.getValueAt(row, 4);
            if (d == null) continue;
            total += Integer.parseInt(String.valueOf(d));
        }
        return total;
    }

    // =========================================================
    //  LIMPIEZA + VALIDACIÓN
    // =========================================================

    private void clearForm() {
        tfCodigo.setText("");
        tfTitulo.setText("");
        tfCurso.setText("");
        chkPrestado.setSelected(false);
        tfDias.setText("");

        table.clearSelection();

        tfCodigo.requestFocus();
    }

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

    private void showError(String field, String msg) {
        JOptionPane.showMessageDialog(frame, msg, "Error en " + field, JOptionPane.ERROR_MESSAGE);
    }
}
