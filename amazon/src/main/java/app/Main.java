package app;

import model.Cliente;
import model.Pedido;
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
            Pedido p1 = new Pedido(1, "Teclado MSI");
            Pedido p2 = new Pedido(2, "Ratón Razer");
            Pedido p3 = new Pedido(3, "Televisor LG");
            Pedido p4 = new Pedido(4, "Monitor HUAWEI");

            // Creamos dos empleados
            Cliente c1 = new Cliente(1, "Ana");
            Cliente c2 = new Cliente(2, "Luis");

            // Asociamos los empleados al departamento
            c1.addPedido(p1);
            c1.addPedido(p2);
            c2.addPedido(p3);
            c2.addPedido(p4);

            // Guardamos el departamento.
            // Como hay cascade = ALL, también se guardan los empleados.
            session.persist(c1);
            session.persist(c2);

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