package Swing;

import javax.swing.JOptionPane;

public class Ejer04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean salir = false;
		String user = "admin";
		String pass = "1234";

		int intentos = 0;

		while (intentos < 3 && !salir) {
			intentos++;

			String userOK = JOptionPane.showInputDialog(null, "Introduzca el nombre de usuario: ", "Usuario",
					JOptionPane.QUESTION_MESSAGE);

			String passOK = JOptionPane.showInputDialog(null, "Introduzca la contraseña: ", "Contraseña",
					JOptionPane.QUESTION_MESSAGE);

			if (userOK.equals(user) && passOK.equals(pass)) {

				JOptionPane.showMessageDialog(null, "Bienvenido, usuario", "Login", JOptionPane.INFORMATION_MESSAGE);
				salir = true;

			} else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "ERROR",
						JOptionPane.INFORMATION_MESSAGE);

			}

		}

		if (salir == false) {

			JOptionPane.showMessageDialog(null, "Usuario bloqueado.", "Error.", JOptionPane.ERROR_MESSAGE);
		}

	}

}
