package Swing;

import javax.swing.JOptionPane;

public class Ejer02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean salir = false;

		while (!salir) {

			String numtxt = JOptionPane.showInputDialog(null, "Introduce un número:", "Número",
					JOptionPane.QUESTION_MESSAGE);

			// Si cancelan, será null

			if (numtxt == null) {
				JOptionPane.showMessageDialog(null, "Operación cancelada.", "Fin", JOptionPane.INFORMATION_MESSAGE);
				return; // Salimos del main
			}

			try {
				int num = Integer.parseInt(numtxt); // Convertimos String -> int
				
				if (num % 2 == 0) {
					JOptionPane.showMessageDialog(null, "El número " + num + " es par.");
				} else {
					JOptionPane.showMessageDialog(null, "El número " + num + " es impar.");
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Eso no es un número entero válido.\nEjemplo válido: 18",
						"Error de formato", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
