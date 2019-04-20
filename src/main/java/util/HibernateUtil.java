package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Client;
import entity.User;

public class HibernateUtil {

	private static final SessionFactory sessionFactoryUsers = buildSessionFactoryUsers();
	private static final SessionFactory sessionFactoryClients = buildSessionFactoryClients();

	/* buildSession for Users */
	private static SessionFactory buildSessionFactoryUsers() {
		try {
			Configuration conf = new Configuration().configure("hibernate-users.cfg.xml");
			conf.addAnnotatedClass(User.class);
			return conf.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactoryUsers() {
		return sessionFactoryUsers;
	}

	public static void shutdownUsers() {
		// Close caches and connection pools
		getSessionFactoryUsers().close();
	}

	/* buildSession for Clients */
	private static SessionFactory buildSessionFactoryClients() {
		try {
			Configuration conf = new Configuration().configure("hibernate-clients.cfg.xml");
			conf.addAnnotatedClass(Client.class);
			return conf.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactoryClients() {
		return sessionFactoryClients;
	}

	public static void shutdownClients() {
		// Close caches and connection pools
		getSessionFactoryClients().close();
	}

}