package ba.bildit.BO;

import java.sql.SQLException;

import ba.bildit.DAO.UserDAOImplementation;
import ba.bildit.UI.InitialMenu;
import ba.bildit.main.Main;

public class RegistrationProcess {

	public static void registrationProcess() throws SQLException {
	
		System.out.println("Enter username:");
		String username = Main.input.next();
		
		if (doesUserExists(username)) {
			System.out.println("That username is already taken!");
			InitialMenu.initialMenu();
		}
		
		System.out.println("Enter your name: ");
		String name = Main.input.next();

		System.out.println("Enter your surname: ");
		String surname = Main.input.next();
		
		System.out.println("Enter your password:");
		String password = Main.input.next();
		
		createUser(username, name, surname, password);
		System.out.println("The user has been successfully created!");
	}
	
	
	public static boolean doesUserExists(String username) throws SQLException {
		
		UserDAOImplementation accessUsers = new UserDAOImplementation();
		
		if (accessUsers.getUser(username) == null)
			return false;
		
		return true;
		
	}
	
	public static void createUser(String username, String name, String surname, String password) throws SQLException {
		
		UserDAOImplementation accessUsers = new UserDAOImplementation();
		
		accessUsers.addUser(username, name, surname, password);
		
	}
		
	}
	

