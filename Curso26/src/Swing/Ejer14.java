package Swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ejer14 {

    // Ventana principal
    private JFrame frame;

    // Campos del formulario
    private JTextField tfId, tfNombre, tfApellidos, tfEdad;

    // Tabla (vista)
    private JTable table;

    // Modelo (datos de la tabla)
    private DefaultTableModel model;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ejer14().start());
    }

    private void start() {
        // ------------------------
        //  1) VENTANA
        // ------------------------
        frame = new JFrame("CRUD local con JTable (sin BD)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ------------------------
        //  2) MODELO: los datos
        // ------------------------
        // DefaultTableModel es un TableModel ya hecho.
        // Le damos los nombres de columnas y 0 filas iniciales.
        // A partir de aquí, podremos usar addRow/removeRow/setValueAt.
        model = new DefaultTableModel(new Object[]{"ID", "Nombre", "Apellidos", "Edad"}, 0) {
            // isCellEditable controla si el usuario puede editar directamente en la tabla.
            // Para aprender CRUD con formulario, desactivamos edición directa:
            // la edición se hace con el botón "Editar".
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // ------------------------
        //  3) TABLA: la vista
        // ------------------------
        // JTable(model): la tabla pinta lo que hay en el modelo.
        table = new JTable(model);

        // Selección: para CRUD básico, lo más claro es seleccionar UNA fila.
        // Así Editar/Borrar trabajan con una única fila y no hay ambigüedad.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // JScrollPane es el envoltorio estándar para JTable:
        // - cabecera visible
        // - barras de scroll
        JScrollPane sp = new JScrollPane(table);

        // ------------------------
        //  4) FORMULARIO (panel superior)
        // ------------------------
        JPanel form = new JPanel(new GridLayout(4, 2, 8, 8));

        tfId = new JTextField();
        tfNombre = new JTextField();
        tfApellidos = new JTextField();
        tfEdad = new JTextField();

        form.add(new JLabel("ID:"));
        form.add(tfId);
        form.add(new JLabel("Nombre:"));
        form.add(tfNombre);
        form.add(new JLabel("Apellidos:"));
        form.add(tfApellidos);
        form.add(new JLabel("Edad:"));
        form.add(tfEdad);

        // ------------------------
        //  5) BOTONES
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
        //  6) PANEL NORTH (formulario + separación + botones)
        // ------------------------
        JPanel north = new JPanel();

        // BoxLayout Y_AXIS apila componentes en vertical:
        // primero el formulario, debajo los botones.
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(form);

        // createVerticalStrut(8) crea un hueco invisible de 8px
        // para que el formulario y los botones no queden pegados.
        north.add(Box.createVerticalStrut(8));

        north.add(buttons);

        // ------------------------
        //  7) LAYOUT PRINCIPAL
        // ------------------------
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(north, BorderLayout.NORTH);
        frame.add(sp, BorderLayout.CENTER);

        // ------------------------
        //  8) DATOS INICIALES
        // ------------------------
        // addRow(Object[]) añade una fila completa al modelo.
        // Cada fila es un Object[] con tantos elementos como columnas.
        model.addRow(new Object[]{1, "Ana", "Márquez", 20});
        model.addRow(new Object[]{2, "Luis", "Blanco", 22});
        model.addRow(new Object[]{3, "Marta", "Fernández", 19});

        // ------------------------
        //  9) EVENTOS
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
    //  MÉTODOS DEL CRUD (aquí vive la lógica de control)
    // =========================================================

    private void addRow() {
        // 1) Leemos y validamos el formulario
        Integer id = parseInt(tfId.getText(), "ID");
        if (id == null) return;

        String nombre = tfNombre.getText().trim();
        if (nombre.isEmpty()) {
            showError("Nombre", "El nombre no puede estar vacío.");
            return;
        }
        String apellidos = tfApellidos.getText().trim();
        if (nombre.isEmpty()) {
        	showError("Apellidos", "El apellido no puede estar vacío.");
        	return;
        }

        Integer edad = parseInt(tfEdad.getText(), "Edad");
        if (edad == null) return;
        if (edad < 0 || edad > 130) {
            showError("Edad", "La edad debe estar entre 0 y 130.");
            return;
        }

        // 2) Evitar ID repetido (opcional pero muy didáctico)
        if (existsId(id)) {
            showError("ID", "Ya existe un alumno con ID=" + id);
            return;
        }

        // 3) Alta: se hace en el MODELO, no en la tabla
        // addRow añade la fila y la tabla se actualiza sola.
        model.addRow(new Object[]{id, nombre, apellidos, edad});

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
        Integer id = parseInt(tfId.getText(), "ID");
        if (id == null) return;

        String nombre = tfNombre.getText().trim();
        if (nombre.isEmpty()) {
            showError("Nombre", "El nombre no puede estar vacío.");
            return;
        }
        String apellidos = tfApellidos.getText().trim();
        if (apellidos.isEmpty()) {
        	showError("Apellidos", "El apellido no puede estar vacío.");
        	return;
        }

        Integer edad = parseInt(tfEdad.getText(), "Edad");
        if (edad == null) return;
        if (edad < 0 || edad > 130) {
            showError("Edad", "La edad debe estar entre 0 y 130.");
            return;
        }

        // 3) Si cambian el ID, evitamos choque con otro alumno
        int currentId = (int) model.getValueAt(row, 0);
        if (id != currentId && existsId(id)) {
            showError("ID", "No puedes cambiar el ID a uno ya existente: " + id);
            return;
        }

        // 4) Edición: setValueAt cambia UNA celda del modelo.
        // (fila row, columna 0 = ID)
        model.setValueAt(id, row, 0);

        // (fila row, columna 1 = Nombre)
        model.setValueAt(nombre, row, 1);
        
        // (fila row, columna 1 = Apellidos)
        model.setValueAt(apellidos, row, 2);

        // (fila row, columna 2 = Edad)
        model.setValueAt(edad, row, 3);

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

        // 2) Confirmación (borrar sin preguntar es de villano)
        int opt = JOptionPane.showConfirmDialog(
                frame,
                "¿Seguro que quieres borrar la fila seleccionada?",
                "Confirmar borrado",
                JOptionPane.YES_NO_OPTION
        );

        if (opt == JOptionPane.YES_OPTION) {
            // 3) Borrado: se hace en el MODELO
            // removeRow elimina la fila y la tabla se actualiza sola.
            model.removeRow(row);

            // 4) Limpiamos el formulario
            clearForm();
        }
    }

    private void loadSelectedRowToForm() {
        // Si no hay selección, no hacemos nada
        int row = table.getSelectedRow();
        if (row == -1) return;

        // Copiamos valores del modelo al formulario
        tfId.setText(String.valueOf(model.getValueAt(row, 0)));
        tfNombre.setText(String.valueOf(model.getValueAt(row, 1)));
        tfApellidos.setText(String.valueOf(model.getValueAt(row, 2)));
        tfEdad.setText(String.valueOf(model.getValueAt(row, 3)));
    }

    // =========================================================
    //  MÉTODO CLAVE: clearForm() (NO es Swing, es nuestro)
    // =========================================================

    private void clearForm() {
        // Vaciar campos
        tfId.setText("");
        tfNombre.setText("");
        tfApellidos.setText("");
        tfEdad.setText("");

        // Quitar selección de la tabla (si la dejamos, confunde)
        table.clearSelection();

        // Devolver el foco al primer campo
        tfId.requestFocus();
    }

    // =========================================================
    //  UTILIDADES DE VALIDACIÓN
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

    private boolean existsId(int id) {
        for (int r = 0; r < model.getRowCount(); r++) {
            int existing = (int) model.getValueAt(r, 0);
            if (existing == id) return true;
        }
        return false;
    }

    private void showError(String field, String msg) {
        JOptionPane.showMessageDialog(frame, msg, "Error en " + field, JOptionPane.ERROR_MESSAGE);
    }
}
