package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase de utilidad para crear una única SessionFactory.
 */
public class HibernateUtil {

	/**
	 * SessionFactory única para toda la aplicación.
	 */
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Construye la SessionFactory leyendo la configuración de Hibernate.
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Error al crear SessionFactory: " + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Devuelve la SessionFactory.
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}