package Swing;

import javax.swing.JOptionPane;

public class Ejer03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean salir = false;

		while (!salir) {

			String numtxt1 = JOptionPane.showInputDialog(null, "Introduzca el primer número: ", "Número 1",
					JOptionPane.QUESTION_MESSAGE);
			String numtxt2 = JOptionPane.showInputDialog(null, "Introduzca el segundo número: ", "Número 2",
					JOptionPane.QUESTION_MESSAGE);

			if (numtxt1 == null || numtxt2 == null) {
				JOptionPane.showMessageDialog(null, "Operación cancelada.", "Fin", JOptionPane.INFORMATION_MESSAGE);
				return; // Salimos del main
			}

			try {

				int num1 = Integer.parseInt(numtxt1); // Convertimos String -> int
				int num2 = Integer.parseInt(numtxt2); // Convertimos String -> int

				int total = (num1 + num2);

				JOptionPane.showMessageDialog(null, "la suma de " + num1 + " y " + num2 + " es: " + total);

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Formato inválido.", "Error", JOptionPane.ERROR_MESSAGE);

			}

		}

	}

}
