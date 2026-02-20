package Swing;

import javax.swing.JOptionPane;

public class Ejer05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean salir = false;

		String[] ops = { "Sumar", "Restar", "Multiplicar", "Dividir", "Salir" };

		while (!salir) {

			int op = JOptionPane.showOptionDialog(null, "Elige una operación:", "CALCULADORA",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);

			try {

				if (op == 4 || op == -1) {
					JOptionPane.showMessageDialog(null, "Operación cancelada.", "Fin", JOptionPane.INFORMATION_MESSAGE);
					salir = true;
				} else {
					String numtxt1 = JOptionPane.showInputDialog(null, "1. Introduzca un número: ", "Calculadora",
							JOptionPane.QUESTION_MESSAGE);
					String numtxt2 = JOptionPane.showInputDialog(null, "2. Introduzca un número: ", "Calculadora",
							JOptionPane.QUESTION_MESSAGE);

					int num1 = Integer.parseInt(numtxt1); // Convertimos String -> int
					int num2 = Integer.parseInt(numtxt2); // Convertimos String -> int

					if (op == 0) {
						JOptionPane.showMessageDialog(null,
								"La suma de " + num1 + " y " + num2 + " es " + (num1 + num2));
					}
					if (op == 1) {
						JOptionPane.showMessageDialog(null,
								"La resta de " + num1 + " y " + num2 + " es " + (num1 - num2));
					}
					if (op == 2) {
						JOptionPane.showMessageDialog(null,
								"La Multiplicación de " + num1 + " y " + num2 + " es " + (num1 * num2));
					}
					if (op == 3) {
						JOptionPane.showMessageDialog(null,
								"La División de " + num1 + " y " + num2 + " es " + (num1 / num2));
					}

				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Eso no es un número entero válido.\nEjemplo válido: 18",
						"Error de formato", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

}
