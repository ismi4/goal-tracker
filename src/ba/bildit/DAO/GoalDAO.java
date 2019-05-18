package ba.bildit.DAO;

import java.sql.SQLException;
import ba.bildit.DTO.Goal;
import ba.bildit.DTO.GoalList;

public interface GoalDAO {

	public Goal getGoal(int id, String goalName) throws SQLException;
	public void setGoal(int id, String goalName, String goalText, boolean completed) throws SQLException;
	public GoalList retrieveGoalsIntoList(int id) throws SQLException;
	public void deleteGoal(int id, String goalName) throws SQLException;
	public void editGoalCompletedField(int id, String goalName, boolean completed) throws SQLException;
	public void editGoal(int id, String goalName, String newGoalName, String newGoalText) throws SQLException;
}
