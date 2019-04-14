package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

import entity.User;

public class HibernateUtil {
	/*
	 * private static final SessionFactory sessionFactory; private static final
	 * ServiceRegistry serviceRegistry;
	 * 
	 * static { Configuration conf = new Configuration(); conf.configure();
	 * serviceRegistry = new
	 * ServiceRegistryBuilder().applySettings(conf.getProperties()).
	 * buildServiceRegistry(); try { sessionFactory =
	 * conf.buildSessionFactory(serviceRegistry); } catch (Exception e) {
	 * System.err.println("Initial SessionFactory creation failed." + e); throw new
	 * ExceptionInInitializerError(e); } }
	 * 
	 * public static SessionFactory getSessionFactory() { return sessionFactory; }
	 */

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration conf = new Configuration().configure("hibernate.cfg.xml");
			conf.addAnnotatedClass(User.class);
			return conf.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
