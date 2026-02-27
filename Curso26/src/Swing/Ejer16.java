package Swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class Ejer16 {

	// Ventana principal
	private JFrame fr;

	// Campos del formulario
	private JTextField tfOrder, tfTitle, tfAutor, tfDura, tfAlbum, tfRepro;

	private JCheckBox chkFav;

	private JLabel lblTotal, lblTime;

	private JButton btnAdd, btnEdit, btnRemove, btnClear, btnPlay, btnFav;

	// Tabla (vista)
	private JTable t;

	// Modelo de datos
	private DefaultTableModel m;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (Exception ignored) {}

			new Ejer16().spoti5();

		});

	}

	private void spoti5() {
		// VENTANA
		fr = new JFrame("PlayList for Spoti5");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// MODELO DE DATOS
		m = new DefaultTableModel(
				new Object[] { "Orden", "Título", "Autor", "Duración", "Album", "Favorito", "Reproducciones" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// VISTA
		t = new JTable(m);

		t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		t.setAutoCreateRowSorter(true);

		JScrollPane sp = new JScrollPane(t);

		JPanel f = new JPanel(new GridLayout(7, 2, 8, 8));

		tfOrder = new JTextField();
		tfTitle = new JTextField();
		tfAutor = new JTextField();
		tfDura = new JTextField();
		tfAlbum = new JTextField();
		chkFav = new JCheckBox("Sí");
		tfRepro = new JTextField();

		// CAMPOS
		f.add(new JLabel("Orden:"));
		f.add(tfOrder);
		f.add(new JLabel("Título:"));
		f.add(tfTitle);
		f.add(new JLabel("Autor:"));
		f.add(tfAutor);
		f.add(new JLabel("Duración:"));
		f.add(tfDura);
		f.add(new JLabel("Album:"));
		f.add(tfAlbum);
		f.add(new JLabel("Favorita:"));
		f.add(chkFav);
		f.add(new JLabel("Reproducciones:"));
		f.add(tfRepro);

		// BOTONES
		JPanel b = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnAdd = new JButton("Añadir");
		b.add(btnAdd);
		btnEdit = new JButton("Editar");
		b.add(btnEdit);
		btnRemove = new JButton("Borrar");
		b.add(btnRemove);
		btnClear = new JButton("Vacíar");
		b.add(btnClear);
		btnPlay = new JButton("Reproducir");
		b.add(btnPlay);
		btnFav = new JButton("Favorita");
		b.add(btnFav);

		// CAMPOS + BOTONES + TOTAL
		JPanel n = new JPanel();
		n.setLayout(new BoxLayout(n, BoxLayout.Y_AXIS));

		n.add(f);
		n.add(Box.createVerticalStrut(8));
		n.add(b);

		JPanel s = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		lblTotal = new JLabel();
		lblTotal.setEnabled(false);
		s.add(new JLabel("Total de canciones:"));
		s.add(lblTotal);

		lblTime = new JLabel();
		lblTime.setEnabled(false);
		s.add(new JLabel("Tiempo Total:"));
		s.add(lblTime);

		// LAYOUT PRINCIPAL
		fr.setLayout(new BorderLayout(10, 10));
		fr.add(n, BorderLayout.NORTH);
		fr.add(sp, BorderLayout.CENTER);
		fr.add(s, BorderLayout.SOUTH);

		n.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
		sp.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

		// INICIAR
		int totalCanciones = calculaTotalCanciones(m);
		double totalTiempo = calculaTotalTiempo(m);

		lblTotal.setText(String.valueOf(totalCanciones));
		lblTime.setText(String.valueOf(totalTiempo));

		// EVENTOS
		btnAdd.addActionListener(e -> addRow());
		btnEdit.addActionListener(e -> editSelectedRow());
		btnRemove.addActionListener(e -> deleteSelectedRow());
		btnClear.addActionListener(e -> clearForm());
		btnPlay.addActionListener(e -> reproducir());
		btnFav.addActionListener(e -> marcarFav());

		// Cuando seleccionas una fila, copiamos sus datos al formulario.
		t.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				loadSelectedRowToForm();
			}
		});

		fr.setSize(760, 520);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);

	}

	// =========================================================
	// MÉTODOS DEL CRUD (aquí vive la lógica de control)
	// =========================================================

	private void addRow() {
		// CAPTURA
		Integer orden = parseInt(tfOrder.getText(), "Orden");
		String titulo = tfTitle.getText().trim();
		String autor = tfAutor.getText().trim();
		Double duracion = Double.parseDouble(String.valueOf(tfDura.getText()));
		String album = tfAlbum.getText().trim();
		boolean favorita = chkFav.isSelected();
		Integer reproducciones = parseInt(tfRepro.getText(), "Reproducciones");

		// CONDICIONES
		if (orden == null || duracion == null || reproducciones == null)
			return;

		if (titulo.isEmpty()) {
			showError("Título", "El nombre de la cancion no puede estar vacio.");
			return;
		}

		if (autor.isEmpty()) {
			showError("Autor", "El nombre del autor no puede estar vacio.");
			return;
		}

		if (duracion < 0) {
			showError("Duración", "La duración de la canción no puede ser negativa");
			return;
		}

		if (album.isEmpty()) {
			showError("Álbum", "El nombre del álbum no puede estar vacio.");
			return;
		}

		if (reproducciones < 0) {
			showError("Reproducciones", "El número de reproducciones no puede ser negativo.");
			return;
		}

		m.addRow(new Object[] { orden, titulo, autor, duracion, album, favorita, reproducciones });

		int total = calculaTotalCanciones(m);
		double tiempo = calculaTotalTiempo(m);

		lblTotal.setText(String.valueOf(total));
		lblTime.setText(String.valueOf(tiempo));

		clearForm();
	}

	public static int calculaTotalCanciones(DefaultTableModel model) {
		int total = 0;

		total = model.getRowCount();
		return total;
	}

	public static double calculaTotalTiempo(DefaultTableModel model) {
		double total = 0;

		for (int row = 0; row < model.getRowCount(); row++) {
			Object tiempo = model.getValueAt(row, 3);

			if (tiempo == null)
				continue;

			double tiempo_number = Double.parseDouble(String.valueOf(tiempo));

			total += tiempo_number;
		}
		total = Math.round(total * 100.0) / 100.0;

		return total;
	}

	private void editSelectedRow() {
		// 1) Necesitamos una fila seleccionada

		int viewRow = t.getSelectedRow();
		int row = t.convertRowIndexToModel(viewRow);

		if (row == -1) {
			JOptionPane.showMessageDialog(fr, "Selecciona una fila para editar.");
			return;
		}

		// 2) Leemos y validamos el formulario
		Integer orden = parseInt(tfOrder.getText(), "Orden");
		if (orden == null)
			return;

		String titulo = tfTitle.getText().trim();
		if (titulo.isEmpty()) {
			showError("Título", "El nombre de la cancion no puede estar vacio.");
			return;
		}

		String autor = tfAutor.getText().trim();
		if (autor.isEmpty()) {
			showError("Autor", "El nombre del autor no puede estar vacio.");
			return;
		}

		Double duracion;
		try {
			duracion = Double.parseDouble(tfDura.getText().trim());
		} catch (NumberFormatException ex) {
			showError("Duración", "Debe ser un número (puede tener decimales).");
			return;
		}
		if (duracion < 0) {
			showError("Duración", "La duración de la canción no puede ser negativa");
			return;
		}

		String album = tfAlbum.getText().trim();
		if (album.isEmpty()) {
			showError("Álbum", "El nombre del álbum no puede estar vacio.");
			return;
		}

		boolean favorita = chkFav.isSelected();

		Integer reproducciones = parseInt(tfRepro.getText(), "Reproducciones");
		if (reproducciones == null)
			return;
		if (reproducciones < 0) {
			showError("Reproducciones", "El número de reproducciones no puede ser negativo.");
			return;
		}

		// 4) Edición: setValueAt cambia UNA celda del modelo.
		m.setValueAt(orden, row, 0);
		m.setValueAt(titulo, row, 1);
		m.setValueAt(autor, row, 2);
		m.setValueAt(duracion, row, 3);
		m.setValueAt(album, row, 4);
		m.setValueAt(favorita, row, 5);
		m.setValueAt(reproducciones, row, 6);

		int total = calculaTotalCanciones(m);
		double tiempo = calculaTotalTiempo(m);

		lblTotal.setText(String.valueOf(total));
		lblTime.setText(String.valueOf(tiempo));

		// 5) Limpieza final (quitar selección, vaciar campos, foco)
		clearForm();
	}

	private void deleteSelectedRow() {
		// 1) Necesitamos una fila seleccionada
		int row = t.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(fr, "Selecciona una fila para borrar.");
			return;
		}

		// 2) Confirmación (borrar sin preguntar es de villano)
		int opt = JOptionPane.showConfirmDialog(fr, "¿Seguro que quieres borrar la fila seleccionada?",
				"Confirmar borrado", JOptionPane.YES_NO_OPTION);

		if (opt == JOptionPane.YES_OPTION) {
			// 3) Borrado: se hace en el MODELO
			// removeRow elimina la fila y la tabla se actualiza sola.
			m.removeRow(row);

			int total = calculaTotalCanciones(m);
			double tiempo = calculaTotalTiempo(m);

			lblTotal.setText(String.valueOf(total));
			lblTime.setText(String.valueOf(tiempo));

			// 4) Limpiamos el formulario
			clearForm();
		}
	}

	private void loadSelectedRowToForm() {
		// Si no hay selección, no hacemos nada
		int row = t.getSelectedRow();
		if (row == -1)
			return;

		int rowModel = t.convertRowIndexToModel(row);

		// Copiamos valores del modelo al formulario
		tfOrder.setText(String.valueOf(m.getValueAt(rowModel, 0)));
		tfTitle.setText(String.valueOf(m.getValueAt(rowModel, 1)));
		tfAutor.setText(String.valueOf(m.getValueAt(rowModel, 2)));
		tfDura.setText(String.valueOf(m.getValueAt(rowModel, 3)));
		tfAlbum.setText(String.valueOf(m.getValueAt(rowModel, 4)));
		chkFav.setSelected((Boolean) m.getValueAt(rowModel, 5));
		tfRepro.setText(String.valueOf(m.getValueAt(rowModel, 6)));

	}

	private void reproducir() {
		int reproducciones = Integer.parseInt(String.valueOf(tfRepro.getText()));
		reproducciones++;
		tfRepro.setText(String.valueOf(reproducciones));
	}

	// =========================================================
	// MÉTODO CLAVE: clearForm() (NO es Swing, es nuestro)
	// =========================================================

	private void clearForm() {
		// Vaciar campos
		tfOrder.setText("");
		tfTitle.setText("");
		tfAutor.setText("");
		tfDura.setText("");
		tfAlbum.setText("");
		chkFav.setSelected(false);
		tfRepro.setText("");

		// Quitar selección de la tabla (si la dejamos, confunde)
		t.clearSelection();

		// Devolver el foco al primer campo
		tfRepro.requestFocus();
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

	private void showError(String field, String msg) {
		JOptionPane.showMessageDialog(fr, msg, "Error en " + field, JOptionPane.ERROR_MESSAGE);
	}

	private void marcarFav() {
		int viewRow = t.getSelectedRow();
		if (viewRow == -1) {
			JOptionPane.showMessageDialog(fr, "Selecciona una canción en la tabla.");
			return;
		}

		int row = t.convertRowIndexToModel(viewRow);

		Boolean favObj = (Boolean) m.getValueAt(row, 5);
		boolean favActual = (favObj != null) ? favObj : false;

		boolean favNuevo = !favActual;
		m.setValueAt(favNuevo, row, 5);

		// Actualizamos el checkbox del formulario para que coincida
		chkFav.setSelected(favNuevo);
	}

}
