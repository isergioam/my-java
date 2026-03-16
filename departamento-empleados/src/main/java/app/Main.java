package app;

import model.Departamento;
import model.Empleado;
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

            // Creamos un departamento
            Departamento d = new Departamento(1, "Informática");

            // Creamos dos empleados
            Empleado e1 = new Empleado(1, "Ana");
            Empleado e2 = new Empleado(2, "Luis");

            // Asociamos los empleados al departamento
            d.addEmpleado(e1);
            d.addEmpleado(e2);

            // Guardamos el departamento.
            // Como hay cascade = ALL, también se guardan los empleados.
            session.persist(d);

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