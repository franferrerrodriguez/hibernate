package app;

import java.util.List;

import dao.ClientDAO;
import dao.UserDAO;
import entity.Client;
import entity.User;

/**
 * Java - Hibernate - MySQL
 *
 */
public class App {

	public static void main(String[] args) {

		// UserDAO

		UserDAO userDAO = new UserDAO();

		User usuario1 = new User();
		usuario1.setId(3);
		usuario1.setUsername("Usuario3");
		usuario1.setEmail("Usuario3@Usuario3.com");
		usuario1.setPassword("1234");

		userDAO.save(usuario1);
		System.out.println("**** USERS ****\n");
		User userById = userDAO.getUserById(3);
		System.out.println(String.format("Usuario by id: %s %s %s %s", userById.getId(), userById.getUsername(),
				userById.getEmail(), userById.getPassword()));

		List<User> users = userDAO.getUsers();

		for (User user : users) {
			System.out.println(String.format("%s %s %s %s", user.getId(), user.getUsername(), user.getEmail(),
					user.getPassword()));
		}

		userDAO.delete(userById);

		// clientDAO
		System.out.println("\n---------------------------------\n\n**** CLIENTS ****\n");

		ClientDAO clientDAO = new ClientDAO();

		List<Client> clients = clientDAO.getClients();

		for (Client client : clients) {
			System.out.println(String.format("%s %s %s %s", client.getId(), client.getFirstname(), client.getLastname(),
					client.getEmail()));
		}

	}

}