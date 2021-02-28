package utilidades;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session session;
	private HibernateUtil() {
	}

	public static void conectar() {
		if (session == null) {
			Configuration configuracion = new Configuration().configure();
			SessionFactory sessionF = configuracion
					.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
			session = sessionF.openSession();
		}
	}

	public static Session getSession() {
		return session;
	}

	public static void apagar() {
		session.close();
	}
}
