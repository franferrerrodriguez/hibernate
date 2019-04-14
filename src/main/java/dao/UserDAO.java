package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.User;
import util.HibernateUtil;

public class UserDAO {

	/**
	 * Insertar un User
	 * 
	 * @param user
	 */
	public void save(User user) {
		Session currentSesion = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = currentSesion.beginTransaction();

		currentSesion.save(user);

		tx.commit();

		currentSesion.close();
	}

	/**
	 * Listado de Users
	 * 
	 * @return Listado Users
	 */
	public List<User> getUsers() {
		Session currentSesion = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<User> users = new ArrayList<User>();

		try {
			tx = currentSesion.beginTransaction();

			users = currentSesion.createQuery("from users", User.class).list();

			tx.commit();

			return users;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			currentSesion.close();
		}

		return users;
	}

	/**
	 * Actualizar User
	 * 
	 * @param user
	 */
	public void update(User user) {
		Session currentSesion = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = currentSesion.beginTransaction();

		currentSesion.update(user);

		tx.commit();

		currentSesion.close();
	}

	/**
	 * Eliminar User
	 * 
	 * @param user
	 */
	public void delete(User user) {
		Session currentSesion = HibernateUtil.getSessionFactory().openSession();

		currentSesion.beginTransaction();

		if (user != null) {
			currentSesion.delete(user);
			currentSesion.getTransaction().commit();
			System.out.println(String.format("El usuario con id %s ha sido eliminado correctamente.", user.getId()));
		}

		currentSesion.close();
	}

	/**
	 * Ejemplo usando criteria
	 * 
	 * @return Listado Users
	 */
	public User getUserById(int id) {

		Session currentSesion = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		User user = null;
		Query<User> query = null;

		try {
			tx = currentSesion.beginTransaction();

			query = currentSesion.createQuery("from users where id = :id", User.class);
			query.setParameter("id", id);

			user = query.getSingleResult();

			tx.commit();

			return user;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			currentSesion.close();
		}

		return user;
	}

}