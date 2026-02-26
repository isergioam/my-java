package Swing;

import javax.swing.*;

public class Ejer13 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            String[] columnas = {"ID", "Nombre", "Edad"};
            Object[][] datos = {
                    {1, "Ana", 20},
                    {2, "Luis", 22},
                    {3, "Marta", 19},
            };

            JTable table = new JTable(datos, columnas);
            JScrollPane sp = new JScrollPane(table);

            JFrame frame = new JFrame("JTable mínima");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(sp);
            frame.setSize(520, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
