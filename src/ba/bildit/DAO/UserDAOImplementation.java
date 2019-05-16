package ba.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ba.bildit.DTO.User;
import ba.bildit.DTO.UserBuilder;

public class UserDAOImplementation {

	Connection connection = ConnectionManager.getInstance().getConnection();

	public User getUser(String username) throws SQLException {

		User user = null;

		String query = "SELECT * FROM users WHERE username = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, username);

			rs = statement.executeQuery();

			if (rs.next()) {

				user = new UserBuilder(rs.getInt("id")).withName(rs.getString("name"))
						.withUsername(rs.getString("username")).withSurname(rs.getString("surname"))
						.withPassword(rs.getString("password")).build();

				rs.close();
			}
		}

		return user;

	}

	public void addUser(String username, String name, String surname, String password) throws SQLException {

		String query = "INSERT INTO users(username, name, surname, password) VALUES (?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, username);
			statement.setString(2, name);
			statement.setString(3, surname);
			statement.setString(4, password);

			statement.executeUpdate();

		}
	}

}
