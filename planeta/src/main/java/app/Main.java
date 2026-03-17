package app;

import model.Autor;
import model.Libro;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Ejemplo de commit con relación 1 a muchos.
 */
public class Main {

    public static void main(String[] args) {

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Creamos los libros
            Libro l1 = new Libro(1, "Don Quijote de la Mancha", 500);
            Libro l2 = new Libro(2, "El Señor de los Anillos", 600);

            // Creamos dos autores
            Autor a1 = new Autor(1, "Cervantes", "Española");
            Autor a2 = new Autor(2, "J.R.R. Tolkien", "Británica");

            // Asociamos los autores a los libros
            a1.addLibro(l1);
            a2.addLibro(l2);

            // Guardamos el libro.
            // Como hay cascade = ALL, también se guardan los autores.
            session.persist(a1);
            session.persist(a2);

            // Confirmamos
            tx.commit();

            System.out.println("Commit realizado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

            if (tx != null) {
                tx.rollback();
                System.out.println("Rollback ejecutado.");
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}