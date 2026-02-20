package Swing;

import javax.swing.JOptionPane;

public class Ejer01 {
    public static void main(String[] args) {

        // Muestra un mensaje informativo
        JOptionPane.showMessageDialog(
                null,                           // Sin ventana padre (centrado)
                "Hola, Paco. Esto ya es GUI 😄", // Mensaje
                "Saludo",                       // Título
                JOptionPane.INFORMATION_MESSAGE  // Icono info
        );
    }
}