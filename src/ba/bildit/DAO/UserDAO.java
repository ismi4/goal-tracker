package ba.bildit.DAO;

import java.sql.SQLException;

import ba.bildit.DTO.User;

public interface UserDAO {

	public User getUser(String username) throws SQLException;

	public void addUser(String username, String name, String surname, String password) throws SQLException;
	
}
