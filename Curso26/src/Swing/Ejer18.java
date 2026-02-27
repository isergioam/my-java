package Swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ejer18 {

	private JFrame fr;
	
	private JTextField tfId, tfAula, tfTiempo;
	
	private JComboBox<String> cbTipo, cbPrio;
	
	private JCheckBox chkResuelta;
	
	private JButton btnAdd, btnEdit, btnDelete, btnClear, btnResuelta, btn10;
	
	private JLabel lblTotal, lblPendientes, lblTotalGeneral;
	
	String[] comboTipo = {"-", "PC", "Red", "Proyector", "Otro"};
	String[] comboPrio = {"-", "Baja", "Media", "Alta"};
	
	// Definimos nuestra tabla y su tipo
	private JTable t;
	
	private DefaultTableModel m;	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Ejer18().start();
		});
	}
	
	private void start() {
		// VENTANA PRINCIPAL
		fr = new JFrame("Gestor de incidencias del aula (helpdesk)");		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// MODELO
        m = new DefaultTableModel(
                new Object[]{"ID", "Aula", "Tipo", "Prioridad", "Resuelta", "Tiempo"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
		
        // TABLA
        t = new JTable(m);
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		t.setAutoCreateRowSorter(true);
		
		JScrollPane sp = new JScrollPane(t); //Importante no olvidarse del Scroll.
		
		// FORMULARIO
		JPanel f = new JPanel(new GridLayout(6,2,8,8));
		
		tfId = new JTextField();
		tfAula = new JTextField();
		cbTipo = new JComboBox<>(comboTipo);
		cbPrio = new JComboBox<>(comboPrio);
		chkResuelta = new JCheckBox("Sí");
		tfTiempo = new JTextField();		
		
		f.add(new JLabel("ID:"));
		f.add(tfId);
		f.add(new JLabel("Aula:"));
		f.add(tfAula);
		f.add(new JLabel("Tipo:"));
		f.add(cbTipo);
		f.add(new JLabel("Prioridad:"));
		f.add(cbPrio);
		f.add(new JLabel("Resuelta:"));
		f.add(chkResuelta);
		f.add(new JLabel("TIempo:"));
		f.add(tfTiempo);				
		
		// BOTONES
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton btnAdd = new JButton("Añadir");
        JButton btnEdit = new JButton("Editar");
        JButton btnDelete = new JButton("Borrar");
        JButton btnClear = new JButton("Limpiar");
        JButton btnToggle = new JButton("Resuelta");
        JButton btnPlusDay = new JButton("+10 Minutos");

        buttons.add(btnAdd);
        buttons.add(btnEdit);
        buttons.add(btnDelete);
        buttons.add(btnClear);
        buttons.add(btnToggle);
        buttons.add(btnPlusDay);
		
		// ORGANIZAR PANELES        
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(f);
        north.add(Box.createVerticalStrut(8));
        north.add(buttons);
        
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        south.add(new JLabel("Total incidencias:"));
        lblTotal = new JLabel();
        lblTotal.setEnabled(false);
        south.add(lblTotal);

        /*south.add(new JLabel("Total pendientes:"));
        tfTotalPrestados = new JTextField(5);
        tfTotalPrestados.setEnabled(false);
        south.add(tfTotalPrestados);

        south.add(new JLabel("Total días acumulados:"));
        tfTotalDias = new JTextField(6);
        tfTotalDias.setEnabled(false);
        south.add(tfTotalDias);*/

        // ------------------------
        //  8) LAYOUT PRINCIPAL
        // ------------------------
        fr.setLayout(new BorderLayout(10, 10));
        fr.add(north, BorderLayout.NORTH);
        fr.add(sp, BorderLayout.CENTER);
        fr.add(south, BorderLayout.SOUTH);

        north.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        sp.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        
        
		// MOSTRAR PROGRAMA
		fr.setSize(860,520);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		
		
	}

}
