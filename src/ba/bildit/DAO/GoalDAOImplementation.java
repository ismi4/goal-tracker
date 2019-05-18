package ba.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ba.bildit.DTO.Goal;
import ba.bildit.DTO.GoalList;


public class GoalDAOImplementation implements GoalDAO {

	Connection connection = ConnectionManager.getInstance().getConnection();
	
	@Override
	public Goal getGoal(int id, String goalName) throws SQLException {
		
		Goal goal = null;

		String query = "SELECT * FROM goals WHERE id = ? AND goalname = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);
			statement.setString(2, goalName);

			rs = statement.executeQuery();

			if (rs.next()) {

				goal = new Goal(rs.getInt("id"), rs.getString("goalname"), 
						rs.getString("goaltext"), rs.getBoolean("completed"));

				rs.close();
			}
		}

		return goal;
		
	}

	@Override
	public void setGoal(int id, String goalName, String goalText, boolean completed) throws SQLException {
		
		String query = "INSERT INTO goals(id, goalname, goaltext, completed) VALUES (?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);
			statement.setString(2, goalName);
			statement.setString(3, goalText);
			statement.setBoolean(4, completed);

			statement.executeUpdate();

		}
	}
		
		
	

	@Override
	public GoalList retrieveGoalsIntoList(int id) throws SQLException {
		
		ArrayList<Goal> goalList = new ArrayList<Goal>();
		
		String query = "SELECT * FROM goals WHERE id = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);
			rs = statement.executeQuery();

			while (rs.next()) {
				goalList.add(new Goal(rs.getInt("id"), rs.getString("goalname"), 
						rs.getString("goaltext"), rs.getBoolean("completed")));
			}

			return new GoalList(id, goalList);
		
	}

}

	@Override
	public void deleteGoal(int id, String goalName) throws SQLException {
		
		String query = "DELETE FROM goals WHERE id = ? AND goalname = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);
			statement.setString(2, goalName);

			statement.executeUpdate();
		
	}
	
}

	@Override
	public void editGoalCompletedField(int id, String goalName, boolean completed) throws SQLException {
	

		String query = "UPDATE goals SET completed = ? WHERE id = ? AND WHERE goalname = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setBoolean(1, completed);
			statement.setInt(2, id);
			statement.setString(3, goalName);
			
			statement.executeUpdate();

		}
		
	}

	@Override
	public void editGoal(int id, String goalName, String newGoalName, String newGoalText) throws SQLException {

		String query = "UPDATE goals SET goalname = ?, goaltext = ? WHERE id = ? AND WHERE goalname = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, newGoalName);
			statement.setString(2, newGoalText);
			statement.setInt(3, id);
			statement.setString(4, goalName);

			statement.executeUpdate();

		}

		
	}
	
}
