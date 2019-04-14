package app;

import java.util.List;

import dao.UserDAO;
import entity.User;

/**
 * Java - Hibernate - MySQL
 *
 */
public class App {

	public static void main(String[] args) {

		UserDAO userDao = new UserDAO();

		User usuario1 = new User();
		usuario1.setId(3);
		usuario1.setUsername("Usuario3");
		usuario1.setEmail("Usuario3@Usuario3.com");
		usuario1.setPassword("1234");

		userDao.save(usuario1);

		User userById = userDao.getUserById(3);
		System.out.println(String.format("Usuario by id: %s %s %s %s", userById.getId(), userById.getUsername(),
				userById.getEmail(), userById.getPassword()));

		List<User> users = userDao.getUsers();

		for (User user : users) {
			System.out.println(String.format("%s %s %s %s", user.getId(), user.getUsername(), user.getEmail(),
					user.getPassword()));
		}

		userDao.delete(userById);
	}

}