package app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Actor;
import model.Pelicula;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		 Session session = null;
	        Transaction tx = null;

	        try {
	            session = HibernateUtil.getSessionFactory().openSession();
	            tx = session.beginTransaction();

	            Actor actor = new Actor(1, "Tomás Ruiz");
	            Pelicula p1 = new Pelicula(1, "La Última Puerta");
	            Pelicula p2 = new Pelicula(2, "Ciudad de Sombras");

	            session.persist(p1);
	            session.persist(p2);
	            session.persist(actor);

	            actor.addPelicula(p1);
	            actor.addPelicula(p2);

	            tx.commit();

	            System.out.println("Actor y películas guardados correctamente.");

	        } catch (Exception e) {
	            if (tx != null) tx.rollback();
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            if (session != null) session.close();
	        }

	}

}
