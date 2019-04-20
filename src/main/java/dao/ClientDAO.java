package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Client;
import util.HibernateUtil;

public class ClientDAO {

	/**
	 * Insertar un Client
	 * 
	 * @param client
	 */
	public void save(Client client) {
		Session currentSesion = HibernateUtil.getSessionFactoryClients().openSession();

		Transaction tx = currentSesion.beginTransaction();

		currentSesion.save(client);

		tx.commit();

		currentSesion.close();
	}

	/**
	 * Listado de Clients
	 * 
	 * @return Listado Clients
	 */
	public List<Client> getClients() {
		Session currentSesion = HibernateUtil.getSessionFactoryClients().openSession();
		Transaction tx = null;
		List<Client> clients = new ArrayList<Client>();

		try {
			tx = currentSesion.beginTransaction();

			clients = currentSesion.createQuery("from clients", Client.class).list();

			tx.commit();

			return clients;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			currentSesion.close();
		}

		return clients;
	}

	/**
	 * Actualizar Client
	 * 
	 * @param client
	 */
	public void update(Client client) {
		Session currentSesion = HibernateUtil.getSessionFactoryClients().openSession();

		Transaction tx = currentSesion.beginTransaction();

		currentSesion.update(client);

		tx.commit();

		currentSesion.close();
	}

	/**
	 * Eliminar Client
	 * 
	 * @param client
	 */
	public void delete(Client client) {
		Session currentSesion = HibernateUtil.getSessionFactoryClients().openSession();

		currentSesion.beginTransaction();

		if (client != null) {
			currentSesion.delete(client);
			currentSesion.getTransaction().commit();
			System.out.println(String.format("El usuario con id %s ha sido eliminado correctamente.", client.getId()));
		}

		currentSesion.close();
	}

	/**
	 * Ejemplo usando criteria
	 * 
	 * @return Listado Clients
	 */
	public Client getClientById(int id) {

		Session currentSesion = HibernateUtil.getSessionFactoryClients().openSession();
		Transaction tx = null;
		Client client = null;
		Query<Client> query = null;

		try {
			tx = currentSesion.beginTransaction();

			query = currentSesion.createQuery("from clients where id = :id", Client.class);
			query.setParameter("id", id);

			client = query.getSingleResult();

			tx.commit();

			return client;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			currentSesion.close();
		}

		return client;
	}

}