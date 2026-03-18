package app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Jugador;
import model.Videojuego;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Jugador jugador = new Jugador(1, "Carlos");
			Videojuego v1 = new Videojuego(1, "Minecraft");
			Videojuego v2 = new Videojuego(2, "FIFA");

			session.persist(v1);
			session.persist(v2);
			session.persist(jugador);

			jugador.addVideojuego(v1);
			jugador.addVideojuego(v2);

			tx.commit();

			System.out.println("Jugador y videojuegos guardados correctamente.");

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
	}

}
